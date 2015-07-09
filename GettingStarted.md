# Maven #
```
<dependency>
      <groupId>com.googlecode.gwtphonegap</groupId>
      <artifactId>gwtphonegap</artifactId>
      <version>1.8.1.0</version>
</dependency>
```


# Setting up a Project #

[Setting up a project with maven](http://code.google.com/p/mgwt/wiki/SetupProject)

<a href='http://www.youtube.com/watch?feature=player_embedded&v=ZSTuS52E0ko' target='_blank'><img src='http://img.youtube.com/vi/ZSTuS52E0ko/0.jpg' width='425' height=344 /></a>


# Getting started #

There are two things that you need to do. Use gwt-phonegap in your GWT project and write your code and compile it to javascript.
After that you need to copy the output of the gwt compiler to your phonegap projects www folder.

## Setting up the GWT Project ##
  1. Download the latest copy of [gwt-phonegap.jar](http://gwt-phonegap.googlecode.com/files/gwtphonegap-1.8.1.0.jar) and place it inside your classpath, or use maven central repo.
  1. Add the following line to your .gwt.xml file: `<inherits name='com.googlecode.gwtphonegap.PhoneGap' />`
  1. Since gwt-phonegap is only tested on iPhone and Android you can tell GWT to only compile for safari: `<set-property name="user.agent" value="safari" />`. This significantly reduces your compile time.


## Setting up a phonegap project ##
You need to setup a normal phonegap project for your platform. This is documented at the phonegap project [Getting started](http://docs.phonegap.com/en/1.7.0/guide_getting-started_index.md.html)

If you are want to run an android project, make sure to read this [blog post](http://blog.daniel-kurka.de/2012/04/gwt-phonegap-16-issues-with-loading-on.html)

In you phonegap project make sure to include the cordova.js file.

## GWT Code ##

Starting phonegap example: http://code.google.com/p/gwt-phonegap/source/browse/gwtphonegap.showcase.gwt/src/main/java/com/googlecode/gwtphonegap/showcase/client/ShowCaseEntryPoint.java?repo=showcase

You may want to take a look at the [ShowCase](http://code.google.com/p/gwt-phonegap/source/browse/trunk/gwt-phonegap-showcase/) app to see how GWT-Phonegap is used. Here is a quick example on how to start GWT-Phonegap:

```
final PhoneGap phoneGap = GWT.create(PhoneGap.class);

phoneGap.addHandler(new PhoneGapAvailableHandler() {

	@Override
	public void onPhoneGapAvailable(PhoneGapAvailableEvent event) {
		//start your app - phonegap is ready

	}
});

phoneGap.addHandler(new PhoneGapTimeoutHandler() {

	@Override
	public void onPhoneGapTimeout(PhoneGapTimeoutEvent event) {
		//can not start phonegap - something is for with your setup

	}
});

phoneGap.initializePhoneGap();

```

# Code Examples #
For each module there is a quick Code example. An overview of all modules is in the [feature wiki](http://code.google.com/p/gwt-phonegap/wiki/Features) wiki


# Phonegap Timout #

If you are experiencing timeouts, this can be due a lot of reasons, check the following things:
  * forgot to include the phonegap.js file for your plattform?
  * if running on Android did you include a listener for the phonegap ready event as described above?



