####CO2 Emission Calculator

###Task
Your task is to create a program that returns the amount of CO2-equivalent that will be caused when traveling a given distance using a given transportation method.

##Organizational
This task has a number of functional and non-functional requirements that are listed below. You should not work longer than 4 hours on this task. 
Make sure you prioritize the most important requirements first. Please submit your solution even if you were not able to finish everything within 4 hours.
You are free to choose the programming language, libraries and tools for this task. Make sure to upload all required files to our submission system (see e-mail for details). 
Avoid uploading unnecessary files like binaries or dependencies, but please do include a README.md that describes how to install dependencies, compile and execute the solution.
If you have questions regarding this task, feel free to send an email and we will get back to you as soon as possible.

##CO2 data
For the calculation, please use the following average values.
Transportation methods in CO2e per passenger per km:
Small cars: small-diesel-car : 142g small-petrol-car : 154g small-plugin-hybrid-car : 73g small-electric-car : 50g Medium cars: medium-diesel-car : 171g medium-petrol-car : 192g medium-plugin-hybrid-car : 110g medium-electric-car : 58g Large cars: large-diesel-car : 209g large-petrol-car : 282g large-plugin-hybrid-car : 126g large-electric-car : 73g bus : 27g train : 6g
Source: BEIS/Defra Greenhouse Gas Conversion Factors 2019

##Acceptance Criteria
#Functional requirements:
The tool can be called with a numeric distance , a unit-of-distance (kilometer km or meter m ) and a transportationmethod
$ ./co2-calculator --transportation-method medium-diesel-car --distance 15 --unit-of-distance km Your trip caused 2.6kg of CO2-equivalent.
The default value for unit is kilometer km.
 
$ ./co2-calculator --distance 1800.5 --transportation-method large-petrol-car Your trip caused 507.7kg of CO2-equivalent.
The output shows the amount of CO2-equivalent in kilogram kg or gram g .
$ ./co2-calculator --transportation-method train --distance 14500 --unit-of-distance m Your trip caused 87g of CO2-equivalent.
$ ./co2-calculator --transportation-method train --distance 14500 --unit-of-distance m --output kg Your trip caused 0.1kg of CO2-equivalent.
Named parameters can be put in any order and either use a space ( ) or equal sign ( = ) between key and value.
$ ./co2-calculator --unit-of-distance=km --distance 15 --transportation-method=medium-diesel-car  Your trip caused 2.6kg of CO2-equivalent.

#Non-Functional requirements:
The implemented features are unit tested The implementation uses a dependency management tool which allows easy compilation and test execution (e.g. in an CI/CD environment) The README.md file contains clear instructions on how to compile, test and execute the tool Best practices regarding architecture and code style are considered

#Hints
Consider using a library that handles parsing command line arguments (e.g. yargs if you use JavaScript) Split printing the output from the logic to make testing easier

####Prerequisites:
1. Installed Java, minimum 8 version.
2. If not using Intellij IDEA, install Maven, latest version.
3. Environmental Variables for Java are being correctly set.

####Test and Build Project:
To test and build the project create a Maven Run Configuration with Command line parameters: clean package

Find the generated **CO2 Emission Calculator.jar** in target folder.

####Run:
To run the application open terminal/command line within the jar file and execute the following
command example:

java -jar "CO2 Emission Calculator.jar" --transportation-method medium-diesel-car --distance 15 --unit-of-distance km
