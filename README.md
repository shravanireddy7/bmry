### Pre-requisites:

Java is installed on your machine.https://java.com/en/download/help/mac_install.xml

Install JDK : https://www.oracle.com/java/technologies/javase-downloads.html

Chrome Webdriver is on your machine and is in the PATH. https://chromedriver.chromium.org/downloads 

Give permission to chromedriver by executing following command in your terminal 

'xattr -d com.apple.quarantine chromedriver'

Here is one resource from the internet that'll help you.

https://help.crossbrowsertesting.com/selenium-testing/frameworks/junit-eclipse/

Eclipse is installed on your machine if you want to run these tests from IDE.
https://www.eclipse.org/downloads/


### Steps to run the tests 

Git clone this repo by running following command in terminal

git clone https://github.com/shravanireddy7/bmry.git, or download this as a Zip file and unzip it
Navigate to just cloned folder bmry-master.

Under src , open SignupTestsT1.java or SignupTestsT2.java

If you want to run test from IDE perform following steps:

1. Import the project as a java project in Eclipse.
2. Run or Debug class SignupTestsT1.java or SignupTestsT2.java as a Junit test.


### About Tests
Used Junit annotations to make code more readable and simple

Provided description of each variable, method, class in each test file clearly

Useed BaseClass to run common methods i.e. loading the page where the test needs to start and quitting the page after tests are run.

