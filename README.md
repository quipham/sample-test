# Test Framework Sample

## Libraries
- Selenium Webdriver (Interact with WebElement)
- Unirest (HTTP request)
- Extend HTML Report (Generating Cucumber pretty report)
- Apache Log4J (Generating Log)

## Installation
1/ Clone this repo to your local

2/ Install requirements
- MacOS (Currently using MacOS chrome driver)
- Install JAVA 8
- Install IntelliJ IDE latest version
- Install Maven (https://www.mkyong.com/maven/how-to-install-maven-in-windows/)(Optional If you run direct by TestNG)

3/ Open Project
- Import this project as Maven project
- Synchronize pom.xml file

4/ Execute  this command to run the Exercise Test by Maven
```
mvn clean test
```
Note:
- If maven can't build project and run the test the issue maybe in `setting.xml` file on your local `m2repository`. You can run directly by TestNG with file `FormCaptureSuite.xml` on package `src/test/resources/suites` (right click on this file to open menu> click on RUN)

## Viewing Test report
- Open file `*/reports/{DateTimeExecute}.html` on any browser

## Test case
##### 1/ By Pass the Login Page to access Lead Capture Form Page
##### 2/ Fill the form with given Test data
##### 3/ Verify the form has been submit successfully by calling API to get form list
