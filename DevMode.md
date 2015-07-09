Currently there is no dev mode for iOS or Android (although I am working on that)
If gwt-phonegap runs in dev mode it tries to emulate the phonegap enviroment as good as it can.

Basically you develop your phonegap app in gwt dev mode in a simulated enviroment and compile to run on different devices.

This is why you should not instantiate any implementation of the phonegap Interface but use GWT Deferred Bindung:

```
PhoneGap phoneGap = GWT.create(PhoneGap.class);
```

You will always get the appropriate implementation for you current enviroment.

## Detect Dev Mode ##

You can detect mode like this:
```
if(phoneGap.isDevMode()){
//do something you would only do in dev mode
}
```