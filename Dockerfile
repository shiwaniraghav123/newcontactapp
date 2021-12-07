FROM openjdk:11
ADD target/contact-application-spring-0.0.1-SNAPSHOT.war contact-application-spring-0.0.1-SNAPSHOT.war
EXPOSE 9000
ENTRYPOINT ["java","-war", "contact-application-spring-0.0.1-SNAPSHOT.war"]
