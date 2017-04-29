/***************************/
*  Building & executing 
/**************************/
1. Pom.xml is configured with mainClassPath defined.
2. In order to build the project using command line
	* Open command line
	* Go to directory where project is located
	* Run command to "mvn package" build the project
	* A new folder will be formed in project folder called "target"
	* Direct path to the target folder
	* Run command 
		"java -jar (path to jar file located in newly created target folder) {path to dictionary.txt} {path to inputfile.txt}"
3. The project can also be imported in any IDE.
	* The dictionary and inputfile can also be placed in src\main\java\com\trading\inputfiles
	* The paths for above location is hard coded in main class
	
	
/************************/
*	Implementation
/************************/

- Encoder.java class contains a constant integer NUM_MAX_LEN, which is currently set to 18. This constant is length of phone number read from input file containing only digits.

- In the description of task there exisit an example. Current implmentation shows two extra results of the example provided in task description
4824: 4 Ort
10/783--5: neu 8 da
As per rules described in task description these results should be part of the example. 
*** Otherwise my apologies for not understanding the task description correctly. :-) ***
	
	
/************************/
*	Flow Diagram
/***********************/
For better understanding the flow of the program a pdf file can be found in main project folder called "Flow Diagram.pdf". The flow chart is not very detailed but highlights the main components of the program.