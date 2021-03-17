# Translate App

<p> command line java application to translate a text from a source language to another language leveraging google cloud translation basic api</p>

# Requirements

* JDK 11
* GCP service account key
* Gradle 6+


# Steps to Use

* build the project<br> ```gradlew clean shadowJar```
* go to build/libs and run the jar<br>```java -jar jarname <input string> <absolute keypath>```
* input string format ```"text=hello world;sl=en;tl=de```
  * the text to be converted is identified by key **text**
  * the source language is identified by key **sl**
  * the target language is identified by key **tl**
  * the delimiter **;** is a must
* keypath format ```/home/user43/key```
* example ``` java -jar translate-app-topcoder-1.0-SNAPSHOT-all.jar "text=hello;sl=en;tl=de" "/home/user12/key.json"```

