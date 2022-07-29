# Set Up Instruction
**Required softwares:**
      * JDK : http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html 
      * Maven : https://maven.apache.org/download.cgi
      * Eclipse : http://www.eclipse.org/downloads/packages/eclipse-ide-java-developers/neon2

# How to set up project
1. Clone this project - $repo
2. Import project in eclipse as Maven existing project
3. Make sure you have set JDK 1.8 in build path for this project.
4. Make sure you have given the path of feature folder in RunCukeTest.java file

## Run Project from eclipse
1. Open src/test/java 
2. Open runner package from it
3. Open CukeRunnerTest class
4. Change the tag name that we have given in feature file
5. Righ click and Select "Run As" and then select "JUnit Test"



## Run Project from command line
1. Open terminal(MAC) or CMD(windows) and go to project directory
2. Run command - mvn clean test -Dtest=runner.CukeRunnerTest -Dcucumber.options="Feature/ --tags @$tagname" --DfailIfNoTests=false

##SetUp for Web Browsers:
1. Download the respective browser driver and set property with the driver path in the configuration registry.
2. Setup properties of the respective browser example using ChromeOptions, FirefoxOptions etc if required.
3. Launch the browser.



# For mac to make chromedriver and geckodriver executable use below command
# chmod +x chromedriver
# chmod +x geckodriver


