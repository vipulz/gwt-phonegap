# Watch the position #

```
GeolocationOptions options = new GeolocationOptions();
options.setFrequency(1000);
GeolocationWatcher watcher = phoneGap.getGeolocation().watchPosition(options, new GeolocationCallback() {

	@Override
	public void onSuccess(Position position) {
		// do something with the position

	}

	@Override
	public void onFailure(PositionError error) {
		// oops

	}
});
```


# Stop watching the position #

```
phoneGap.getGeolocation().clearWatch(watcher);
```


# Geolocation in dev mode #
In dev mode the geolocation tries to use the browsers geo location. If this fails it returns an PERMISSION\_DENIED Error to the caller