# IoT platform prototype 
IoT platform prototype based on microservice architecture. 

# Architecture

![image](https://github.com/DaniloVeljovic/master-rad/blob/main/app/architecture.png?raw=true)

The architecture consists of 4 services: 
1. Ingestion service - Persists the data that arrived from the sensors in InfluxDB. 
2. Query service - Persists the data that arrived from the sensors in InfluxDB and is responsible to respond to customer queries.  
3. Analytics service - Uses machine learning to analyze incoming measurements and decides on actuation based on the result of the analysis.
4. Device service - Runs an actuation job which triggers device actuation.


Services were written in Java/Spring Boot.
