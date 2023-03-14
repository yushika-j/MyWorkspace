Prerequisites to the tests working:

All files must be present*. 

All files must compile*.

All files must have the exact name expected.

All methods must be present with the exact name expected.

All methods must have the exact signature expected.

 

*Even if you could not complete a particular exercise, the files must be included, they must compile, and contain all the method definitions required by the exercise.

----------------------------------------
Usage:

For running the tests, you need the two libraries: junit and hamcrest.

You can use them using two options: 
(1) adding the jar files containing the libraries in the same folder as the unit tests
 OR 
(2) updating your CLASSPATH.

***

(Option 1) If you have NOT updated your CLASSPATH to point at the JUnit libraries, then:

1. Copy all your .java files, the test files, junit-4.13.jar and hamcrest-core-1.3.jar into one folder.

2. From that folder, compile and run TestL1.java:
Under macOS, Linux, or Unix in general:
> javac -cp junit-4.13.jar:hamcrest-core-1.3.jar:. TestL1.java

> java -cp junit-4.13.jar:hamcrest-core-1.3.jar:. TestL1

Under Windows
> javac -cp "junit-4.13.jar;hamcrest-core-1.3.jar;." TestL1.java

> java -cp "junit-4.13.jar;hamcrest-core-1.3.jar;." TestL1


***

(Option 2) If you have updated your CLASSPATH to point at the JUnit libraries (for instructions on how to do that, please see the setup requirements and instructions below), then:

1. Copy all your .java files and all of the test files into one folder

2. From that folder, compile and run TestL1.java:
> javac TestL1.java

> java TestL1
 


Setup:

Instructions for updating the CLASSPATH:

1. Download JUnit and Hamcrest-core jars.

2. Update your CLASSPATH.

For Windows:
		
			Go to Setings> Edit the system environment variables > Environment variables > System variables > CLASSPATH.

			Add two new entries containing the paths that point to the downloaded jar files. For example: 
			C:\javalibs\junit-4.13.jar
			C:\javalibs\hamcrest-core-1.3.jar

    **

For macOS/Linux/Unix:

			Add to .bash_profile (or run in terminal each time):

			export CLASSPATH=$CLASSPATH:/Users/yourusername/lib/java/junit-4.13/junit-4.13.jar:/Users/yourusername/lib/java/junit-4.13/hamcrest-core-1.3.jar:.

			replace "yourusername" with your username.
