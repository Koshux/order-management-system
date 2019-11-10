FROM openjdk:8
ADD target/docker-dogbox-oms.jar docker-dogbox-oms
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "docker-dogbox-oms.jar"]