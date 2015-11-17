# Pull base image
FROM daocloud.io/java:8u66-jre

MAINTAINER "Zongzhi Bai" <dolphineor@gmail.com>

# Add executable jar file to target directory
ADD spring-boot-examples.jar /opt/spring-boot-examples/

# Expose ports
EXPOSE 8081

WORKDIR /opt/spring-boot-examples/

CMD ["java", "-server", "-Dfile.encoding=UTF-8", "-Xms1g", "-Xmx1g", "-jar", "spring-boot-examples.jar"]