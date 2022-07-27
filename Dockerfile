FROM openjdk:8

ADD target/docker_jenkins_springboot.jar docker_jenkins_springboot.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","docker_jenkins_springboot.jar"]