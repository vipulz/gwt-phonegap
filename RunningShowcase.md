First make sure to have a current maven version (3.0.3) running and (if you like) eclipse installed.



You need to checkout the project from version control:

```
git clone https://code.google.com/p/gwt-phonegap.showcase/
```

The gwt part of the showcase project is located at **gwt-phonegap-showcase/gwtphonegap.showcase.gwt/**
After that go into the this directory and run

```
mvn eclipse:eclipse
```
This will build a .project and a .classpath file for the showcase project.


After that run
```
mvn war:exploded
```

After that you can import the project into eclipse:
File -> Import -> General -> Existing Projects into Workspace

And you may get an error such as:
"The GWT SDK JAR gwt-servlet.jar is missing in the WEB-INF/lib directory"

Just use the quick fix and let the google eclipse plugin redeploy the servlet file.



More information on how this works can be found in this [blog post](http://blog.daniel-kurka.de/2011/11/how-to-mavenize-your-eclipse-projects.html)