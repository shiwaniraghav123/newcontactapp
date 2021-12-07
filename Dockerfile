FROM openjdk:11
ADD target/contact-application-spring-0.0.1-SNAPSHOT.jar contact-application-spring-0.0.1-SNAPSHOT.jar
EXPOSE 9000
ENTRYPOINT ["java","-jar", "contact-application-spring-0.0.1-SNAPSHOT.jar"]