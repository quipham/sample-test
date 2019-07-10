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


# Answer the Question
To implement automated testing on CI/CD process, we can follow those steps below:
1 - Make the Test Framework (TF) executable by CMD
2 - Define the CI/CD process again to determine which Phase we should trigger the Automation Test, it needs to include the following Team's capabilities
3 - Find good CI/CD tool that we can integration our TF, Have Test reporting, Schedule, ... (Few popular Tool: Jenkins, TeamCity, ...)
4 - Setup one Host machine with CI/CD tool your choice and Repository for TF If you need to run the Test independently, Create new Job schedule nightly to execute the test on this machine
5 - To notify the Test result we can use the default notify method of CI/CD tool, usually by Email method. The other way we can integrate with Chat Platform like Slack.
