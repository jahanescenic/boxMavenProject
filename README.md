# What

This repository contains test code to run test on [box](https://box.com)

## Overview

In order to run the test we have to build the project with maven. All selenium and testng libraries are downloaded inside localrepository (~/.m2/repository).
Please Make sure the build is successful.

## Components

- Maven
- selenium-java
- testng

## Requirements

- [GIT](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)
- [Maven](https://maven.apache.org/) - Apache Maven 3.6.3
- [Java](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html) 
- [chromedriver](https://chromedriver.storage.googleapis.com/index.html?path=89.0.4389.23/)
- [Chrome Binary](https://www.google.com/chrome)

## Supported Versions

- Java : 1.8.0_251
- maven : Apache Maven 3.6.3
- Chrome : 89 (subject to change if you want to run with the latest, make sure your chromedriver is the same version as binary)
- chromedriver : 89 (chromedriver provided in the project only runs for MacOS, please replace it if you are running inside ubuntu env)

## Setup

- `git clone https://github.com/jahanescenic/boxMavenProject.git`
- `cd boxMavenProject/`
- `mvn clean install`

## Launch

- Before running the test, Take a look at `src/test/java/boxProject/Utility/Constants.java`, 
- Enter Useremail and Password
- Change(if needed) chromedriver location

### For MacOS (Big Sur)

- Run `mvn test`

### For Ubuntu 20.04

- Run following commands:        
- `mvn '-Dtest=boxProject.LoginTest' test`
- `mvn '-Dtest=boxProject.FolderTest' test`

##### Note: Please clean the test data after each run, or change the file (bear.jpg) and location references in Constants.java. 

Check Reports: `boxMavenProject/target/surefire-reports/index.html`


