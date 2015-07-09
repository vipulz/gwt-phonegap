# Basic Usage #

```
phoneGap.getDevice().getVersion();//version of the underlying OS
phoneGap.getDevice().getName(); // name of the device
phoneGap.getDevice().getPhoneGapVersion(); //phonegap version
phoneGap.getDevice().getPlatform(); // Android, Blackberry, iPhone, Browser...
phoneGap.getDevice().getUuid(); // a unique id identifiying the device
```


# Device module in dev mode #

  * OS Version is empty
  * Name is Empty
  * No phonegap version
  * Plattform returns Browser
  * a pseudo UUID saved to a cookie