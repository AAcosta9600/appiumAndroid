package appiumtests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Device {

	@JsonProperty
	private String name;
	@JsonProperty
	private String udid;
	@JsonProperty
	private String platform;
	@JsonProperty
	private String platformVersion;
	@JsonProperty
	private String appPackage;
	@JsonProperty
	private String appActivity;

	public Device(String name, String udid, String platform, String platformVersion, String appPackage, String appActivity) {
		this.name= name;
		this.udid = udid;
		this.platform=platform;
		this.platformVersion=platformVersion;
		this.appPackage=appPackage;
		this.appActivity=appActivity;
		
	
		
		
	}

	public Device() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUdid() {
		return udid;
	}

	public void setUdid(String udid) {
		this.udid = udid;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getPlatformVersion() {
		return platformVersion;
	}

	public void setPlatformVersion(String platformVersion) {
		this.platformVersion = platformVersion;
	}

	public String getAppPackage() {
		return appPackage;
	}

	public void setAppPackage(String appPackage) {
		this.appPackage = appPackage;
	}

	public String getAppActivity() {
		return appActivity;
	}

	public void setAppActivity(String appActivity) {
		this.appActivity = appActivity;
	}

	@Override
	public String toString() {
		return "Device [name=" + name + ", udid=" + udid + ", platform=" + platform + ", platformVersion="
				+ platformVersion + ", appPackage=" + appPackage + ", appActivity=" + appActivity + "]";
	}
	
	
}
