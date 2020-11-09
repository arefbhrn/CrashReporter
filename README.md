<img src=https://github.com/arefbhrn/CrashReporter/blob/master/assets/crash_reporter_banner.png >

# CrashReporter

[![](https://jitpack.io/v/arefbhrn/CrashReporter.svg)](https://jitpack.io/#arefbhrn/CrashReporter)
[![Open Source Love](https://badges.frapsoft.com/os/v1/open-source.svg?v=102)](https://opensource.org/licenses/Apache-2.0)
[![License](https://img.shields.io/badge/license-Apache%202.0-blue.svg)](https://github.com/arefbhrn/CrashReporter/blob/master/LICENSE)

### CrashReporter is a handy tool to capture app crashes and save them in a file.

### Why CrashReporter? 

While developing features we get crashes and if device is not connected to logcat we miss the crash log. In worst case scenario we might not be able to reproduce the crash and endup wasting effort. This library captures all unhandled crashes and saves them locally on device. I found a problem with other libraries that they capture crashes and then uploads them to server and sometimes few crashes aren't logged to server. That's the purpose of this library use it as a debug feature to capture crashes locally and immediately.

### Run the sample
<img src=https://github.com/arefbhrn/CrashReporter/blob/master/assets/crash_reporter_work_flow.gif >

### Crash Reporter APIs

- Track all crashes
- Use Log Exception API to log Exception
- All crashes and exceptions are saved in device
- Choose your own path to save crash reports and exceptions
- Share Instantly crash log with your team with other device data.

### Crash reporter doesn't takes any permission or root access
### Using Crash Reporter Library in your application
add below dependency in your app's gradle
```
Implementation 'com.github.arefbhrn:crashreporter:1.2.0'
```
### If you only want to use Crash reporter in debug builds only add
```
debugImplementation 'com.github.arefbhrn:crashreporter:1.2.0'
```

## Crash Reporter On Duty
- It'll capture all unhandled crashes and write them to a file in below directory
```
/Android/data/{your-app-package-name}/files/crashReports
```
- To save crashes in a path of your choice, add below line in onCreate method of your Application class
```
CrashReporter.initialize(this, crashReporterPath);
```
Note: You don't need to call CrashReporter.initialize() if you want logs to be saved in default directory. If you want to use external storage then add storage permission in you manifest file.

```
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
```

### Using log Exception API
### If you want to capture exceptions then you can use below API
for ex :
```
try {
    // Do your stuff
} catch (Exception e) {
    CrashReporter.logException(e);
}
```
Pass exception thrown in below method

```
logException(Exception exception)
```

### To get default crash reports path
```
CrashUtil.getDefaultPath()
```
you can access all crash/exception log files from this path and upload them to server for your need. Remember it's default path 
if you provide your own path you know where to find the logs...

### Find this project useful ? :heart:
* Support it by clicking the :star: button on the upper right of this page. :v:

### That's it for now

### Contact - Let's connect and share knowledge
- [Twitter](https://twitter.com/arefbhrn)
- [Github](https://github.com/arefbhrn)
- [Facebook](https://www.facebook.com/arefbhrn)
