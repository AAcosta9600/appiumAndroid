package appiumtests;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import java.awt.Color;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CalculatorTest {

	static AndroidDriver driver;
	
	public static void main(String[] args) {
		
		
		try {
			//opens amazon video and clicks first video
			openVideo();
			
			//takes screenshots and compares images
			//Boolean bool = openCamera();
			//System.out.println(bool);
			

		}
		catch(Exception exp){
			System.out.println(exp.getCause());
			System.out.println(exp.getMessage());
			exp.printStackTrace();
		}
		
	}
	

	
	
	public static void openVideo() throws Exception{
		
		// Loading the YAML file from the /resources folder
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		File file = new File(classLoader.getResource("config.yaml").getFile());

		// Instantiating a new ObjectMapper as a YAMLFactory
		ObjectMapper om = new ObjectMapper(new YAMLFactory());
		om.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		// Mapping the employee from the YAML file to the Employee class
		Devices devices = om.readValue(file, Devices.class);
		
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", devices.getDevices().get(1).getName());
		cap.setCapability("udid", devices.getDevices().get(1).getUdid());
		cap.setCapability("platformName", devices.getDevices().get(1).getPlatform());
		cap.setCapability("platformVersion", devices.getDevices().get(1).getPlatformVersion());
		cap.setCapability("autoGrantPermissions",true);
		cap.setCapability("autoAcceptAlerts",true);
		cap.setCapability("noReset","true");
		cap.setCapability("appPackage", devices.getDevices().get(1).getAppPackage());
		cap.setCapability("appActivity",devices.getDevices().get(1).getAppActivity());
		
		

		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		
		driver = new AndroidDriver(url,cap);
		System.out.println("App Open");
		driver.findElement(By.id("com.amazon.avod.thirdpartyclient:id/icon")).click();
		//clicks first video in popular videos
		driver.findElement(By.id("com.amazon.avod.thirdpartyclient:id/hide_overlay")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("com.amazon.avod.thirdpartyclient:id/detail_page_header_play_button_image")).click();
		
//		Thread.sleep(4000);
//		File file1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(file1,new File("vid1.jpg"));
//		Thread.sleep(4000);
//		File file2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(file2,new File("vid2.jpg"));
		
	}
	
	public static boolean openCamera() throws Exception{
		
		// Loading the YAML file from the /resources folder
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		File file = new File(classLoader.getResource("config.yaml").getFile());

		// Instantiating a new ObjectMapper as a YAMLFactory
		ObjectMapper om = new ObjectMapper(new YAMLFactory());
		om.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		// Mapping the employee from the YAML file to the Employee class
		Devices devices = om.readValue(file, Devices.class);
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", devices.getDevices().get(0).getName());
		cap.setCapability("udid", devices.getDevices().get(0).getUdid());
		cap.setCapability("platformName", devices.getDevices().get(0).getPlatform());
		cap.setCapability("platformVersion", devices.getDevices().get(0).getPlatformVersion());
		cap.setCapability("autoGrantPermissions",true);
		cap.setCapability("autoAcceptAlerts",true);
		cap.setCapability("noReset","true");
		cap.setCapability("appPackage", devices.getDevices().get(0).getAppPackage());
		cap.setCapability("appActivity",devices.getDevices().get(0).getAppActivity());
		
		System.out.println("Attempt");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");

		driver = new AndroidDriver(url,cap);
		driver.findElement(By.id("com.lge.camera:id/next_button")).click();
		driver.findElement(By.id("com.lge.camera:id/cancel_button")).click();
		driver.findElement(By.id("com.lge.camera:id/cancel_button")).click();
		//takes the picture
		//driver.findElement(By.id("com.lge.camera:id/shutter_bottom_comp")).click();
		

		//takes screenshot and saves file on workspace
		File file1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file1,new File("screen1.jpg"));
		System.out.println("First Screenshot Taken...");
		
		Thread.sleep(3000);
		
		File file2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file2,new File("screen2.jpg"));
		System.out.println("Second Screenshot Taken...");
		
		return compareImages(file1,file2);
		
	}
	
	public static boolean compareImages(File file1, File file2) {
		try {
			BufferedImage img1 = ImageIO.read(file1);
			BufferedImage img2 = ImageIO.read(file2);
			int w1 = img1.getWidth();
			int w2 = img2.getWidth();
			int h1 = img1.getHeight();
			int h2 = img2.getHeight();
			if((w1!=w2)||(h1!=h2)) {
				return false;
			}
			else {
				double diff = 0;
				for (int j = 0; j < h1; j++) {
		            for (int i = 0; i < w1; i++) {
		               //Getting the RGB values of a pixel
		               int pixel1 = img1.getRGB(i, j);
		               Color color1 = new Color(pixel1, true);
		               int r1 = color1.getRed();
		               int g1 = color1.getGreen();
		               int b1 = color1.getBlue();
		               int pixel2 = img2.getRGB(i, j);
		               Color color2 = new Color(pixel2, true);
		               int r2 = color2.getRed();
		               int g2 = color2.getGreen();
		               int b2= color2.getBlue();
		               double data = Math.abs(r1-r2)+Math.abs(g1-g2)+ Math.abs(b1-b2);
		               diff = diff+data;
		            }     
				}
			double avg = diff/(w1*h1*3);
		    double percentage = (avg/255)*100;
		    System.out.println("Difference: "+percentage+"%");
			return true;
		}
		}
		
		catch(Exception e){
			System.out.println("Process Failed");
			return false;
		}
	}
}
