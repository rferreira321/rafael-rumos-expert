# Rumos Expert Certification Project

A Selenium-based test automation project built with Java, Maven, Selenium, Cucumber, TestNG and designed to validate web application functionality with detailed reporting using Allure.
The website tested is [JPetStore Demo](https://petstore.octoperf.com/)

# Author
Rafael Ferreira - [LinkedIn](https://www.linkedin.com/in/rafael--ferreira/)

Thanks to Sara Cunha for helping with the webdriver instantion issue! =D

## Table of Contents
1. [Introduction](#introduction)
2. [Prerequisites](#prerequisites)
3. [Setup Instructions](#setup-instructions)
4. [Running Tests](#Running-Tests)
5. [Viewing the Allure Report](#viewing-the-allure-report)
6. [General Considerations and Errors](#general-considerations-and-errors)

## Introduction
This project automates web application testing using Selenium WebDriver, Java, and Maven. Allure is used to generate clear and interactive test reports.

## Prerequisites
Before running the project, ensure the following are installed on your system:
- IDE: InteliJ or Eclipse
-   In your IDE plugins:
  - **Cucumber**
  - **TestNG**
  - **JUnit**
- **Java JDK 21+**: [Download Here](https://www.oracle.com/java/technologies/javase-downloads.html)
- **Apache Maven**: [Download Here](https://maven.apache.org/download.cgi)
- **Allure CLI** (optional for viewing reports):  
  [Installation Instructions](https://docs.qameta.io/allure/#_installing_a_commandline)
- Chrome
- Firefox

# Setup-instructions
Clone the repository:
```
git clone https://github.com/rferreira321/rafael-rumos-expert.git
cd rafael-rumos-expert
```
Verify Maven setup: Ensure Maven is correctly installed by running:

```mvn -v```

This should display the Maven version.

Download dependencies: Use Maven to install the necessary dependencies defined in the pom.xml:
Access the 'Petstore' project directory and execute the command:
```mvn clean install```

# Running-Tests
Access the 'Petstore' project directory and execute the command:
To execute tests, use the following Maven command:

```mvn clean test```

Running tests in jenkins:
Configure your Root POM directory with:
```
Petstore/pom.xml
```
And for Allure report jenkins plugin:
```
Petstore/target/surefire-reports
```

# Viewing-the-Allure-Report
Generate and serve the Allure report:

```allure serve target/surefire-reports```

This will launch a local server and display the report in your browser.

Open the report manually by navigating to allure-report/index.html.

# General Considerations and Errors

After running several executions there's still some flakiness in the tests. Sometimes all tests pass but other times 2 or 3 tests fail with no obvious pattern.
Maybe trying to change the way webdriver is instantiated might fix the issue.

In the folder of this project ```Evidences/"Failing runs"``` you can find logs of the failing runs, but below I've compiled are some of the most frequent errors found:

```Session ID is null. Using WebDriver after calling quit()?```
Maybe due to incorrect webdriver instantiation?

```stale element reference: stale element not found```
Element is not found in the DOM, but why?
Added a try catch to debug but couldn't reproduce the scenario
```
    public void clickEnterStore() {

        try {
            enterStore = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(enterStoreButton));
            enterStore.click();
            testUtils.sleep(1000);
        }
        catch (Exception e) {
            System.err.println("Error: enter store button is not visible." + e.getMessage());
        }

    }
```


```
org.openqa.selenium.remote.UnreachableBrowserException: 
Error communicating with the remote browser. It may have died.
```
Not sure how this happens :\

# Improvements that could be done in the future

Add more extensive tests such as:
- Add multiple items to the cart
- Remove items from the cart
- Enter an invalid username and password
- Try to register an already registered user

Solve the test flakiness by debugging the known issues mentioned above.

Improve function documentation.

Reduce introduced sleeps by better understanding where failures are happening.
