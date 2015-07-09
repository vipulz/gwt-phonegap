# Back Button Event (Android) #
```
phoneGap.getEvent().getBackButton().addBackButtonPressedHandler(new BackButtonPressedHandler() {

	@Override
	public void onBackButtonPressed(BackButtonPressedEvent event) {
		//backbutton was pressed
	}
});
```


# Offline Event #
```
phoneGap.getEvent().getOffLineHandler().addOfflineHandler(new OffLineHandler() {

	@Override
	public void onOffLine(OffLineEvent event) {
		//device is now offline
	}
});
```

# Offline Event #
```
phoneGap.getEvent().getOnlineHandler().addOnlineHandler(new OnlineHandler() {

	@Override
	public void onOnlineEvent(OnlineEvent event) {
		//device is now online
	}
});

```

# Pause Event #
```
phoneGap.getEvent().getPauseHandler().addPauseHandler(new PauseHandler() {

	@Override
	public void onPause(PauseEvent event) {
		//application will get paused
	}
});
```


# Resume Event #
```
phoneGap.getEvent().getResumeHandler().addResumeHandler(new ResumeHandler() {

	@Override
	public void onResumeEvent(ResumeEvent event) {
		//application was resumed
	}
});
```


# Search Button (Android) #
```
phoneGap.getEvent().getSearchButton().addSearchButtonHandler(new SearchButtonPressedHandler() {

	@Override
	public void onSearchButtonPressed(SearchButtonPressedEvent event) {
		//search button was pressed
	}
});
```


# Event in dev mode #
Registering for events is supported in dev mode. But events will never get fired. If you want to fire an event you can do it like htis:
```
if (phoneGap.isDevMode()) {
	((EventMock) phoneGap.getEvent()).fireBackEvent();
}
```