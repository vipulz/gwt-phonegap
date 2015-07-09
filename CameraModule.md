# Take a foto #

A quick example how to take a foto:
```
PictureOptions options = new PictureOptions(25);
options.setDestinationType(PictureOptions.DESTINATION_TYPE_DATA_URL);
options.setSourceType(PictureOptions.PICTURE_SOURCE_TYPE_CAMERA);

phoneGap.getCamera().getPicture(options, new PictureCallback() {

	@Override
	public void onSuccess(String data) {
		display.setImageData("data:image/jpeg;base64," + data);
	}

	@Override
	public void onFailure() {
		Window.alert("failure");

	}
});
```


# Dev Mode and Mocked Images #

In dev mode gwt-phonegap returns default images for the camera. you can change them like this:
```
if (phoneGap.isDevMode()) {
			MyCustomBundle bundleInstance = GWT.create(MyCustomBundlec.class);
			((CameraMock)phoneGap.getCamera()).setCameraBundle(bundleInstance);
			
			((CameraMock)phoneGap.getCamera()).setPictureUrl(GWT.getModuleBaseURL() + "/mypicture.jpg");
		}
```

If you want the camera to fail in dev mode you can do this by setting:
```
if (phoneGap.isDevMode()) {
 ((CameraMock)phoneGap.getCamera()).setShouldFail(true);			
}
```