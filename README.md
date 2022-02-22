# appiumTests

# Set Up
- open *cmd* and type *adb devices* to start up daemon. Then type again to list devices if devices not listed. (Make sure phone is connected in photo transfer protocol)
- open *Appium Server GUI*
- Click Edit configuration and change *ADROID_HOME* environment variable to where your sdk is installed. (Ex. C:\Users\user\AppData\Local\Android\Sdk)
- Save and Restart to go back and then click *Start Server*. (Host 0.0.0.0 and Port 4723 are default)
- Edit *config.yaml* to edit app information. 
- Run program on your IDE to open apps. 

# Required Technologies
- Android Studio(brings sdk)
- Java
- Maven
- IDE of your choice(Ex. Eclipse, SpringToolSuite, etc)
- Appium Server GUI
- Appium Inspector(If more commands are needed)
- Apk Info(A Phone app to see appPackages and appActivities for different apps)
