# FLIGHT SEARCH

## About

This is a project which produces a REST API(SpringBoot/Maven/Mysql) that allow the users to search for flight based on specific time.
To search a flight you simply enter the time of the departure. The flight search algorithm will only display flights at a distance (plus or minus) of 5 hours from the time you select for your departure. 

For example if you search for a 6AM flight, you will see both the 7:30AM and the 10:30AM flights in the results.

## How To Run

1) Import the project in IDE (Eclipse/Intellij)
2) Connect to database:

         a) Change the bean configuration if needed and connect to your mysql server by changing 'url'
		    , 'username' and 'password' in /flight/src/main/resources/application.properties
        
		  b) Run DML and DDL scripts given in your mysql server:
		     /flight/src/main/resources/sql/import-mysql.sql


3) Build project using maven "mvn clean install"
4) Launch spring boot application by FlightSearchApplication.class 
4) Go to web browsers and visit : http://localhost:8080/browser/index.html#/

    and use API end point in Explorer : /api/rest/flight/{time} where time = 12PM  or 3:30PM
    
    ![Alt text](/src/main/resources/img/img.png?raw=true "Flight Search")
    
## Explaination
### 1) Assumptions :
        a) Flight search currently searches on time : I have a taken date as current date but
                time is initialized based on the dummy data provide in assignment   
        b) For now , Data is initialized with below flights:
						{  
						   "flights":[  
							  {  
								 "flight":"Air Canada 8099",
								 "departure":"7:30AM"
							  },
							  {  
								 "flight":"United Airline 6115",
								 "departure":"10:30AM"
							  },
							  {  
								 "flight":"WestJet 6456",
								 "departure":"12:30PM"
							  },
							  {  
								 "flight":"Delta 3833",
								 "departure":"3:00PM"
							  }
						   ]
						}

        c)  Input parameters: Current search works on below input types
                             examples: 12PM,6:00AM,6:00PM,3:30PM etc.
                             
                             Note (FAILURE): Invalid input passed will return error message:
                             
                                                [{"errorMessage":"Please check you input"}]   
                                 

### 2) To search for flight :
       a) Go to web browsers and visit : http://localhost:8080/browser/index.html#/
       b) use API end point in Explorer 
       
       example : api/rest/flight/12PM
        
        {SUCCESS}
        
        Response: [  
				   {  
				      "flightCode":"3833",
				      "flightOperator":"Delta",
				      "departureTime":"15:00 PM"
				   },
				   {  
				      "flightCode":"6115",
				      "flightOperator":"United Airlines",
				      "departureTime":"10:30 AM"
				   },
				   {  
				      "flightCode":"6456",
				      "flightOperator":"WestJet",
				      "departureTime":"12:30 PM"
				   }
				]

### 3) Improvements :
       a) Search can be done on other parameters as well.
       b) Instead of current date ,we can improve solution to consider different dates.
       c) Improve exception handling.
