# backend-tech-assessment

Skeleton project for Backend Technical Assessment.

Includes
--------
- Maven - [pom.xml](pom.xml)
- Application properties - [application.yml](src/main/resources/application.properties)
- Runnable Spring Boot Application - [BackendTechAssessmentApplication](src/main/java/com/intuit/cg/backendtechassessment/BackendTechAssessmentApplication.java)
- REST endpoints - [RequestMappings.java](src/main/java/com/intuit/cg/backendtechassessment/controller/requestmappings/RequestMappings.java)

Requirements
------------
See Backend Technical Assessment document for detailed requirements.

running this application need to change mysql url name password in application.properties file also need mysql installed


this project can be separate into two parts;
1. add seller, buyer, project, bid
2. calculate the win price for project

the first part of this project is easy to implement using post method to add records to mysql database
the second part need more discussion
at first I have two thoughts
1. display after the whole bid finish 
2. display temporarily lowest bid, then based on the auto bid rule, only lowest bid will win, then i can block buyers to bid if they give no less bid price
the first solution needs to store all the bids and check all the project which should terminate then find the min bid for each project it needs more space and needs about M*N where M is the number
of projects N is the number of bids. 
the second solution is cache the temp min and for each new bid check if it less than temp min if so replace if not ignore the bid. this time no need to store bids and also running time is
N, N is the number of bids. it save both space and time.
however, I still choose the first solution, reasons below:
1. store the raw meta data can tolerant human fault
2. solution 1 is much closer to realistic 
3. sulution 1 is extensible for software since current we are using lowest bid win algorithm but what if we also need to consider buyers credit then solution 1 is easier to modify the code than 
solution 2. 

so in order to make it efficient, I have two controllers one for clients query, another one for batch job running. the batch job will trigger at 1am for each day check if there is any projects 
bid terminated. then update these projects. 

the reason why I'm using mysql is there are many relations inside so if some other service need to implement for example, for each project show a specific buyers bid history. 



Exercise Difficulty: Easy, Moderate, Difficult, Very Difficult   Moderate 
How did you feel about the exercise itself? (1 lowest, 10 highest—awesome way to assess coding ability)     7
How do you feel about coding an exercise as a step in the interview process?  (1 lowest, 10 highest—awesome way to assess coding ability)  9
What would you change in the exercise and/or process? see below:


