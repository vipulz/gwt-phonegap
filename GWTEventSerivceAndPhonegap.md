# How to make GWTEventService work in a GWTPhoneGap app? #

This article was written by Roman Kaufmann.

## Introduction ##
''GWTEventService is an event-based client-server communication framework. It uses GWT-RPC and the Comet / server-push technique. … Events can be added to a context/domain on the server side and the listeners on the client side get informed about the incoming events.''

The above statement is taken directly from the corresponding [project homepage](http://code.google.com/p/gwteventservice/).

## Issue description ##
In its current version (1.2.0) the GWTEventService framework can’t be used directly in a Phonegap application. The reason for this is that it currently does not expose its ServiceTargetDef interface. Therefore you can’t apply the method that is described by Daniel in his Blog [here](http://blog.daniel-kurka.de/2012/04/gwt-rpc-with-phonegap-revisited.html).

A more detailed issue description can be found [here](http://code.google.com/p/gwteventservice/issues/detail?id=22#c6).

## Problem resolution ##
I’ve created two helper classes which can be used to solve the problem. The only usage requirement is that the following line of code is called before the first event listener is created:

<tt>// Special handling for GWTEventService</tt>

<tt>RemoteEventServiceFactory.getInstance().getRemoteEventService(new GWTPhoneGapRemoteEventConnector( new GWTPhoneGapEventServiceCreator(url "/com.roksoft.posy.Main/", "gwteventservice")));</tt>


The required helper classes are attached to the detailed issue description on the gwteventservice homepage as well as to this Wikipedia article.

## Weblinks ##
**[GWT Event Service Project](http://code.google.com/p/gwteventservice/)** [GWT Event Service - Issue 22](http://code.google.com/p/gwteventservice/issues/detail?id=22#c6)
