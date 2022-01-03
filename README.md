**Prerequisite**
- JDK 1.8
- Maven
- Docker

**Development mode**
- Open the project in your favourite IDE (Ex. IntelliJ IDEA).
- If the required Presetup already available then just run below commands. 

**Maven Commands**
- mvn clean install 
- mvn spring-boot:run 
 
Application resources available:
 - Host URL: [http://localhost:8080](http://localhost:8080)
 - Swagger API Docs:  [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
 - http://localhost:8080/api/v1/tariff/3500/compare
 - http://localhost:8080/api/v1/tariff/4500/compare
 - http://localhost:8080/api/v1/tariff/6000/compare
 
 
**Production mode**
 - Create application JAR by running
 
 - mvn clean install 
 
**Docker Commands** 

 - docker-compose -f ./docker/docker-compose-prod.yml up --build -d
 - find the host with below command in my case it results in 192.168.99.100
 - docker-machine ip 

Application resources available:
  - Host URL: [http://192.168.99.100:9001/](http://192.168.99.100:9001/)
  - Swagger API Docs:  [http://192.168.99.100:9001/swagger-ui.html](http://192.168.99.100:9001/swagger-ui.html)
  - http://192.168.99.100:9001/api/v1/tariff/3500/compare
  - http://192.168.99.100:9001/api/v1/tariff/4500/compare
  - http://192.168.99.100:9001/api/v1/tariff/6000/compare