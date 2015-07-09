# Show an alert #

```
phoneGap.getNotification().alert("daniel says hi", new AlertCallback() {

	@Override
	public void onOkButtonClicked() {

	}
}, "gwt-phonegap", "buttonText");
```


# Confirm something #

```
phoneGap.getNotification().confirm("question?", new ConfirmCallback() {

	@Override
	public void onConfirm(int button) {

	}
}, "gwt-phonegap");
```

# Beep #
```
phoneGap.getNotification().vibrate(2500);
```

# Vibrate #
```
phoneGap.getNotification().beep(2);
```

# notfication in dev mode #
Alert and confirm use the browser equivalents. Beep and vibrate are a noop in dev mode.