# IoT platform prototype 
IoT platform prototype based on microservice architecture. 

# Architecture

![image](https://github.com/DaniloVeljovic/master-rad/blob/main/app/architecture.png?raw=true)

The architecture consists of 4 services: 
1. _Ingestion service_ - Persists the data that arrived from the sensors in InfluxDB. 
2. _Query service_ - Persists the data that arrived from the sensors in InfluxDB and is responsible to respond to customer queries.  
3. _Analytics service_ - Uses machine learning to analyze incoming measurements and decides on actuation based on the result of the analysis.
4. _Device service_ - Runs an actuation job which triggers device actuation.


Services were written in Java/Spring Boot. Frontend was written in React. 

# Starting the application
1. Run the containerized databases: `$/docker> docker-compose up`
2. Run the backend services on by one
3. Run the frontend application by running
```
$\master-rad\app\FE\fe-app> npm install
$\master-rad\app\FE\fe-app> npm start
```
4. Run the _sensorImitation_ service

## Clean up
1. Stop the _sensorImitation_ service
2. Stop the front end application (Ctrl+C in the terminal where it is running)
3. Stop all the backend services
4. Run 
```
$/docker> docker-compose down
$/docker> docker rm -f $(docker ps -a -q)
$/docker> docker volume rm $(docker volume ls -q)
```
