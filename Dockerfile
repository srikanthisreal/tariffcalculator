FROM maven:3.6-openjdk-8-slim

MAINTAINER Srikanth

WORKDIR /home/apps 

COPY . /home/apps/tariffcalculator

RUN ls -al /home/apps/

RUN mvn -f /home/apps/tariffcalculator/pom.xml clean package

EXPOSE 8080

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /home/apps/tariffcalculator/target/tariffcalculator*.jar" ]