# filtrack -L03 - GR2

## 2XB3 Final Project

FilTrack is the solution for finding the perfect music based on user’s mood without spending hours going through the generic playlists. All the user needs to do is select criteria based on their mood (high tempo, liveliness etc.) and FilTrack will filter through the Million Song Database to find the personalized best fit tracks for the user. Success of FilTrack will be determined by the user feedback after users try the recommended tracks. FilTrack is unique from the existing solutions in a way that it respects the privacy of the user when offering personalized suggestions by not storing any data. At the same time this approach allows the app to give better results by allowing users to try something new each time based on their current mood rather than showing the similar tracks the user always listens to based on their history like many other apps do.

## Images

Main Page
![Main Page](/FilTrack_Main_Page.jpg)

Results Page
![Results Page](/FilTrack_Results_Page.jpg)

Graph Algorithm
![Graph1](/FilTrack_Graph_Algorithm_Suggestions.jpg)

Graph Algorithm with Multiple Searches
![Graph2](/FilTrack_Graph_Algorithm_Suggestions_Multiple_Searches.jpg)

## Videos

How to Deploy & Configure FilTrack

[![Deployment](https://img.youtube.com/vi/82u8ng76lRs/0.jpg)](http://www.youtube.com/watch?v=82u8ng76lRs)

FilTrack Demo

[![Deployment](https://img.youtube.com/vi/2cj87IP4OkY/0.jpg)](http://www.youtube.com/watch?v=2cj87IP4OkY)

## Deployment File

When you import the filtrack project you might have to configure the project as Dynamic Web Project (DWP) if it is not
already configured as DWP. To do so, right click on the project name (filtrack folder) in eclipse then select properties
towards the bottom. Then go to Project Facets from the menu on the left and configure as Dynamic Web Module by selecting
the checkbox of Dynamic Web Module then hit apply and close button.
To sum up:
Properties->Project Facets -> Dynamic Web Module

You would need Tomcat server to run the project. Once you configure the tomcat server go to folder WebContent in filtrack
then open the WebContent/index.hmtl in eclipse with text editor. Then right somewhere empty in the index.html file and select run as ->
run on server -> select tomcat server configured on your device.

Another issue is that you would have to change the path to the csv file in Java Resources/src/com/web/mainSearch to an absolute path in your computer.
The reason for that is (as far as I found online) when the web app is running on tomcat server it is searching relative paths
starting from the where the Tomcat/bin folder is located (start place of the server) and not where the project is located.
Thus, even if I give a relative path to where the Tomcat server files are located in my computer it might be different in
your computer (mine is located in downloads and most probably default location is not there). So, to run it you would have to
change path. (I showed it in the filtrack demo video).

 Java files are under the Java Resources/src/com/web/, also under the WebContent/ there are several modules as well: namely
 WebContent/index.html, WebContent/result.jsp, WebContent/css/stle.css, WebContent/css/result.css
