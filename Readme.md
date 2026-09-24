# Test Automation Framework
A scalable, maintainable, and configurable Java-based UI test automation framework built using Selenium WebDriver, TestNG, Maven, OpenCSV, Gson, Apache POI, Java Faker, Extent Reports, Log4j, and LambdaTest.

## Author
- [@harivenkateshsj](https://github.com/harivenkateshsj)
- Email Address: harivenkateshsj@gmail.com
## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://github.com/harivenkateshsj)
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/sjhari/)

## 🚀 About Me
Hello! I'm Harivenkatesh, an Automation Testing professional with over 6 years of experience in designing, developing, and maintaining scalable, robust test automation frameworks and CI/CD solutions.

## Technical Skills
- UI Automation: Selenium WebDriver, Playwright
- API Testing: Rest Assured, Postman
- Mobile Automation: Appium
- DevOps & CI/CD: Experience in automating build, test, and deployment workflows
I am passionate about delivering high-quality software through efficient test automation, continuous integration, and modern DevOps practices. I specialize in building scalable, maintainable, and reliable automation frameworks, optimizing testing processes, and enabling faster, more dependable software delivery pipelines.

## Prerequisite
Before running this framework, ensure the following software is installed on your system:
- **Java 11** - Make sure Java is installed and the JAVA_HOME environment variable is set.
- **Maven** - Ensure Maven is installed and added to the system path.

## Features
- **Java 11 Based Framework** – Built using Java 11 for reliable and maintainable test automation.
- **Selenium WebDriver** – Automates web application testing across supported browsers.
- **TestNG Integration** – Provides test execution, assertions, annotations, test organization, and data-driven test support.
- **Cross-Browser Testing** – Supports execution across different browsers such as Chrome and Firefox.
- **Local & Cloud Execution** – Tests can be executed either locally or remotely on LambdaTest.
- **LambdaTest Integration** – Enables cloud-based browser execution and cross-browser testing without requiring local browser infrastructure.
- **Headless Execution** – Supports headless browser execution to reduce execution overhead and improve suitability for CI/CD environments.
- **Data-Driven Testing** – Supports executing the same test scenarios with multiple sets of test data.
- **CSV Test Data Support** – Uses OpenCSV to read and process CSV-based test data.
- **JSON Test Data Support** – Uses Gson for reading and processing JSON-based test data.
- **Excel Test Data Support** – Uses Apache POI to read and process Excel-based test data.
- **Dynamic Test Data Generation** – Uses Java Faker to generate realistic and unique test data during execution.
- **Maven-Based Execution** – Uses Maven for dependency management, build lifecycle, and command-line test execution.
- **Maven Surefire Integration** – Enables TestNG tests to be executed through Maven with runtime parameters.
- **Configurable CLI Execution** – Browser, LambdaTest execution, and headless mode can be controlled through Maven command-line parameters:
  - `browser`
  - `isLambdaTest`
  - `isHeadless`
- **Extent Reports** – Generates an HTML test execution report as `reports.html`.
- **Log4j Logging** – Provides execution and debugging logs under the `logs/` directory.
- **CI/CD Friendly** – Supports command-line execution and headless mode, making the framework suitable for integration with CI/CD pipelines.
- **Reusable Test Architecture** – The same test cases can be executed across different browsers and environments without modifying the test logic.
- **Maintainable and Scalable** – Separates test execution, test data, browser configuration, reporting, and logging responsibilities to support future enhancements.

## Technologies Used
- Java 11
- Selenium WebDriver
- TestNG
- Apache Maven
- Maven Surefire Plugin
- OpenCSV
- Gson
- Apache POI
- Java Faker
- LambdaTest
- Extent Reports
- Log4j
- Git

**Clone the Repository:**
`bash
git clone https://github.com/harivenkateshsj/Test-Automation-Framework.git
cd Test-Automation-Framework`
**Running Tests on LambdaTest:**
`bash
mvn test
mvn test -X -Dbrowser=chrome -DisLamdaTest=true -DisHeadless=false`
**Running Tests on Chrome browser on Local Machine in Headless Mode:**
`bash
mvn test
mvn test -X -Dbrowser=chrome -DisLamdaTest=false -DisHeadless=false`

## Reports 
-Reports: After execution, a detailed HTML report will be generated at ./report.html.
The report contains information on test cases executed, passed, failed, and skipped, along with screenshots for failed tests.

## Logs
Logs are created during the test execution and stored in the ./logs/directory.

## Integrated the project Github Actions
This automation framework is integrated with github actions. The tests will be executed at 11:30PM IST every day.
The reports will be archieved in gh-pages branch You can view the html reports at :
https://harivenkateshsj.github.io/Test-Automation-Framework/report.html
