# Getting compass values #

You can read the compass like this:
```
watcher = phoneGap.getCompass().watchHeading(new CompassOptions(), new CompassCallback() {

	@Override
	public void onSuccess(double heading) {
		

	}

	@Override
	public void onError() {
		

	}
});
```


# dev mode and compass #

In dev mode the compass module alwys returns 0. You can change that like this:
```
ArrayList<Double> list = new ArrayList<Double>();
list.add(1.2);
list.add(10.2);
((CompassMock) phoneGap.getCompass()).setMockValues(list);
```

If you want the compass to fail you can achieve that like this:
```
if (phoneGap.isDevMode()) {
	((CompassMock) phoneGap.getCompass()).setShouldFail(true);
}
```