BIMM185-Filters
===============

BIMM185 Project - Filters for Cytoscape app

This Cytoscape app/plugin allows the user to apply filters to different pathways and datasets. 
The jar file to be generated (the app) is a simple app (different from a bundle app). The requirements are a copy of the
Java Development Kit (JDK) version 1.6 or later and download the Cytoscape Swing App API JAR, in order to be able 
to use the different cytoscape classes. The code is written in Java, the main class is MaizeApp which provides the 
adapter for the other classes the contain the actual functionality and connects it to Cytoscape. 
There are 5 additional classes, each provides one functionality, and all talk to the MaizeApp class. 
An App Manifest should also be in the same directory and contain information about the version and compatibility (text file).
The code can be pulled from github. In order to compile with the Cytoscape Swing API jar we use the command:
javac -cp ".:/path/2/cytoscape-swing-app-api-3.x.x.jar" *.java
Where path/2/ is the path to the cytoscape swing API jar file.  In order to generate the jar file, use the command:
jar cfm MaizeApp.jar app-manifest *.class
The jar file will be generated. It can be used in Cytoscape 3 by selecting Apps->App Manager from the menu. 
On the dialog, click the button Install from File. Then select MaizeApp.jar and can now test the app by going to the 
Apps menu and choosing Maize App. 
