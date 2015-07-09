# gwt-logging #

First you need to understand how GWT Logging works for the client side. A good explanation can be found here: http://code.google.com/intl/de-DE/webtoolkit/doc/latest/DevGuideLogging.html
Logging with gwt-phonegap is as simple as logging with GWT.

Simply create an instance of the logger you want to use and start logging:
```
Logger logger = Logger.getLogger("myname");

logger.severe("log something");
```


# gwt-phonegap and logging #

gwt-phonegap uses the same mechanism provided for logging by gwt.
It configures gwt-logging not to use the default console handler, but builds its own to deal with specific phonegap issues. Logging is turned on by default in gwt-phonegap.

Logging can be turned on by using:
```
 <set-property name="gwt.logging.enabled" value="TRUE" />
```
and can be disabled by setting:
```
 set-property name="gwt.logging.enabled" value="FALSE" />
```

The log level can be set this way:
```
 <set-property name="gwt.logging.logLevel" value="INFO"/>
```

## Local Logging (Console) ##
For local logging gwt-phonegap uses console.log. If your telephone is connected to your ide this output can be seen in Logcat (on Android) or XCode. The local logging handler can be turned off by setting this:
```
<set-property name="phonegap.logging.consoleHandler" value="DISABLED" />
```


## Remote Logging (via GWT Service) ##
If telephones are not connected to a development enviroment, you won´t be able to see any log output. This is why there is an integrated remote logger in gwt-phonegap. It will accept all log records and put them in a buffer. If a log record is equal or higher than the threshold log level it will send the complete buffer to the server. It is turned on by default.
The remote Logger can be turned off by setting:
```
<set-property name="phonegap.logging.remoteHandler" value="DISABLED" />
```

The threshold level can be configured this way:

```
 <set-configuration-property name="phonegap.logging.threshold" value="WARNING" /> 
```

The number of log records in the buffer can be customized by setting this:
```
 <set-configuration-property name="phonegap.logging.maxentries" value="100" /> 
```


The RemoteLogger needs to know the ServiceUrl to post LogRecords to the server.
You need to set the url by calling:
```
phoneGap.getLog().setRemoteLogServiceUrl("http://yourserviceurl");
```

and in your web.xml:
```
<servlet>
		<servlet-name>phonegapRemoteLogger</servlet-name>
		<servlet-class>com.googlecode.gwtphonegap.server.log.PhoneGapLogServiceStandardImpl</servlet-class>
	</servlet>
	<servlet-mapping>
		<servlet-name>phonegapRemoteLogger</servlet-name>
		<url-pattern>yourserviceurl</url-pattern>
	</servlet-mapping>
```

The default implementation PhoneGapLogServiceStandardImpl will use java.util.Logging to log the logrecords on the server. It will add the clientId (Device.getUUid()) to the log message, so that you can distinguish between different clients.