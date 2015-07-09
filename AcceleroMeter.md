# Basic Usage #

Start watching the accelerometer:
```
AccelerationOptions options = new AccelerationOptions();
options.setFrequency(50);
AccelerometerWatcher watcher = phoneGap.getAccelerometer().watchAcceleration(options, new AccelerationCallback() {

			@Override
			public void onSuccess(Acceleration acceleration) {
				// X - Axis 
				acceleration.getX();
				// Y - Axis 
				acceleration.getY();
				// Z - Axis 
				acceleration.getZ();

				//time
				acceleration.getTimeStamp();

			}

			@Override
			public void onFailure() {

			}
		});
```

Stop watching the accelerometer:
```
phoneGap.getAccelerometer().clearWatch(watcher);
```

Add values for the mock implementation:
```
if (phoneGap.isDevMode()) {
			AccelermeterMock mock = ((AccelermeterMock) phoneGap.getAccelerometer());

			ArrayList<Acceleration> list = new ArrayList<Acceleration>();
			list.add(new AccelerationBrowserImpl(1, 1, 1));
			list.add(new AccelerationBrowserImpl(1, 0, 0));
			list.add(new AccelerationBrowserImpl(0, 1, 0));
			list.add(new AccelerationBrowserImpl(0, 0, 1));
			mock.setMockValues(list);
		}
```