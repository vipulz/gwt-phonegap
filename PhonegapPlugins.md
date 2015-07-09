# Basics #

Sometimes it is necessary to extend phonegap with some plugin, because not all possible native functionality is covered in the phonegap core. There is a great deal of good phonegap plugins out there. This is why gwt phonegap supports an easy way to include phonegap plugins.

If you like to use a phonegap plugin first check if the plugin has already been wrapped. If it has been wrapped the code is already part of gwt phonegap and be used very easily.
If it has not been wrapped you need to wrap the plugin yourself. You could also post your code as a patch so that it can be included into gwt phonegap after review.

# Wrapped Plugins #
  * Badge Plugin
  * ChildBrowser


# How to wrap a plugin #

## Building a Java Interface for the Plugin ##
You need duplicate the javascript functions from your plugin and build a corresponding java interface that extends [PhoneGapPlugin](http://code.google.com/p/gwt-phonegap/source/browse/src/main/java/com/googlecode/gwtphonegap/client/plugins/PhoneGapPlugin.java).
If the plugin has a javascript function like:
```
   function(someString){
      return "foo";
   }
```

you would have a function in your java interface like this:
```
   public String doSomething(String someString);
```

## Implementations the interface ##
GWT Phonegap uses deferred binding for dev mode and production, so your plugin has to have at least two implementations. One for dev mode and one for production. Sometimes there is no possible emulation for features in dev mode, then you need to build an implementation that does nothing or can be used to supply mocked values.

### Production Implementation ###
In your production implementation you need to initialize the native plugin (if neccessary) and call the native javascript function via [JSNI](http://code.google.com/intl/de-DE/webtoolkit/doc/latest/DevGuideCodingBasicsJSNI.html).
A good example is the production implementation of childbrowser: [ChildBrowserPhoneGapImpl](http://code.google.com/p/gwt-phonegap/source/browse/src/main/java/com/googlecode/gwtphonegap/client/plugins/childbrowser/ChildBrowserPhoneGapImpl.java).

### Dev Mode Implementation ###
Do something that is suitable for the plugin you are wrapping.

## Binding the Plugin ##
You need to tell GWT when to use which implementation of your plugin in your gwt.xml file. The GWT property that you will be using is "phonegap.env".

Here is what it looks like for the ChildBrowser plugin.
```
    <!-- Plugins -->
    <!-- Childbrowser -->
	<replace-with
		class="com.googlecode.gwtphonegap.client.plugins.childbrowser.ChildBrowserPhoneGapImpl">
		<when-type-is
			class="com.googlecode.gwtphonegap.client.plugins.childbrowser.ChildBrowser" />
		<all>
			<when-property-is name="phonegap.env" value="yes" />
		</all>
	</replace-with>
	<replace-with
		class="com.googlecode.gwtphonegap.client.plugins.childbrowser.ChildBrowserBrowserImpl">
		<when-type-is
			class="com.googlecode.gwtphonegap.client.plugins.childbrowser.ChildBrowser" />
		<all>
			<when-property-is name="phonegap.env" value="no" />
		</all>
	</replace-with>
```

## Initialize the Plugin ##

After the start of your App in your PhoneGapAvailableHandler you have to create an instance of your plugin and put it in the plugin registry. Here is the childBrowser as an example:
```
   // load plugin
   ChildBrowser cb = (ChildBrowser) GWT.create(ChildBrowser.class);
   cb.initialize();
   phoneGap.loadPlugin("childBrowser", cb);
```

If you want to use the plugin at some other place in your app, you can easily retrieve it from the plugin registory like this:
```
   ChildBrowser cb = (ChildBrowser) phoneGap.getPluginById("childBrowser");
```