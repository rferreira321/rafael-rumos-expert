# Rafael Rumos Expert Certification Project

A Selenium-based test automation project built with Java, Maven, Selenium, Cucumber, TestNG and designed to validate web application functionality with detailed reporting using Allure.
The website tested is [JPetStore Demo](https://petstore.octoperf.com/)

# Author
Rafael Ferreira - [LinkedIn](https://www.linkedin.com/in/rafael--ferreira/)

## Table of Contents
1. [Introduction](#introduction)
2. [Prerequisites](#prerequisites)
3. [Setup Instructions](#setup-instructions)
4. [Running Tests](#Running-Tests)
5. [Viewing the Allure Report](#viewing-the-allure-report)
6. [General Considerations and Errors](#general-considerations-and-errors)

## Introduction
This project automates web application testing using Selenium WebDriver, Java, and Maven. Allure is used to generate clear and interactive test reports.

It uses:
- **Selenium**: For browser automation.
- **TestNG**: For managing and running test cases (allows parallel test execution)
- **Cucumber**: For Behavior-Driven Development (BDD) test scenarios.
- **Allure**: For detailed and interactive reporting.

## Prerequisites
Before running the project, ensure the following are installed on your system:
- IDE: InteliJ or Eclipse
- **Java JDK 8+**: [Download Here](https://www.oracle.com/java/technologies/javase-downloads.html)
- **Apache Maven**: [Download Here](https://maven.apache.org/download.cgi)
- **Allure CLI** (optional for viewing reports):  
  [Installation Instructions](https://docs.qameta.io/allure/#_installing_a_commandline)
- **Cucumber**

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

```mvn clean install```

# Running-Tests
To execute tests, use the following Maven command:

```mvn clean test```

# Viewing-the-Allure-Report
Generate and serve the Allure report:

```allure serve target/surefire-reports```

This will launch a local server and display the report in your browser.

Open the report manually by navigating to allure-report/index.html.

# General Considerations and Errors

After running several executions there's still some flakiness in the tests. Sometimes all tests pass but other times 2 or 3 tests fail with no obvious pattern.
Maybe trying to change the way webdriver is instantiated might fix the issue.
There are two main reasons they fail:

One is:
```Session ID is null. Using WebDriver after calling quit()?```

Another one is:
```stale element reference: stale element not found```
