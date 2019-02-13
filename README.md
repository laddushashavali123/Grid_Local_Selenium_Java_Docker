Introduction: 
---------------
This automation framework is developed for my learning purpose, it supports for automating web application only.
The automation framework is written with Java, Selenium and TestNG and it can:
* Write TDD test
* Write BDD test with Cucumber
* Use the Page Object pattern
* Run tests in parallel
* Run tests remotely (Selenium Grid or a cloud testing provider)
* Execute from Jenkins or any other CI tool
* Capture and separate the test execution logs with logback 
* Work with SikuliX
* Run jMetter test
* Capture screen shoot after test or anytime to screenshoot folder
* Automatically download browser driver (update resources/driver/RepositoryMap.xml for latest version)


Prerequisites:
---------------
* Java jdk-1.8 or higher
* Apache Maven 3 or higher


Execution:
---------------
* Clone the repository.
* Import to your favorite IDE.
* Modify test environment in suite folder
* Run with command: mvn clean install -Dsuite=[suite_name]

