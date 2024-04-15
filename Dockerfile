FROM openjdk:17
WORKDIR /app
COPY  ./target/first-springboot-jenkins-0.0.1-SNAPSHOT.jar /app/
EXPOSE 8080 
CMD ["java","-jar","first-springboot-jenkins-0.0.1-SNAPSHOT.jar"]