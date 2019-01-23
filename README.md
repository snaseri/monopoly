# Assessment-1-Starter-Monopoly

This is the starter project for Assessment 1 in 2018/2019.

## Instructions

### Setup

Fork this project to your own Gitlab account

Then, clone the project to your laptop.

### Structure

The project is setup in a standard structure with src/main and src/test folders.

You should write your code under these folders.

The game code should go under src/main and your automated tests under src/test.

Use packages.  I have provided a starting structure.

Do not touch the control files that are provided.  These are

* build.gradle
* gitlab-ci.yml
* /config/*
* /gradle/*
* gradlew
* gradlew.bat
* .gitignore
* settings.gradle
* 
### Process

Every push to the master branch will start an automated process.  
This will checkout your code to a virtual machine, and run a build process.
This will check your source code for good standards, then compile the code, 
then run the automated tests.  It will also check the code coverage of the
automated tests.

You can check the success of these builds on the CI/CD menu under Pipelines.

You should make every effort to avoid a failing build on Gitlab by running the 
same build process on your laptop before pushing.  To run the same build process, 
use the Gradle pane in IntelliJ (right-hand side).  Select "BuildAndReport" from the 
"Other" category.