# Pull base image
FROM ubuntu:14.04

MAINTAINER Zongzhi Bai "dolphineor@gmail.com"

# Update source
RUN echo "deb http://archive.ubuntu.com/ubuntu trusty main universe"> /etc/apt/sources.list
RUN apt-get update

# Install curl & vim
RUN apt-get -y install curl
RUN apt-get -y install vim

# Install Oracle-JDK8
RUN cd /tmp && curl -L 'http://download.oracle.com/otn-pub/java/jdk/8u60-b27/jdk-8u60-linux-x64.tar.gz' -H 'Cookie: oraclelicense=accept-securebackup-cookie; gpw_e24=Dockerfile' | tar -xz
RUN mkdir -p /usr/lib/jvm
RUN mv /tmp/jdk1.8.0_60/ /usr/lib/jvm/oracle-java-8/

# Set Oracle JDK 8 as default Java
RUN update-alternatives --install /usr/bin/java java /usr/lib/jvm/oracle-java-8/bin/java 300
RUN update-alternatives --install /usr/bin/javac javac /usr/lib/jvm/oracle-java-8/bin/javac 300
RUN update-alternatives --install /usr/bin/javap javap /usr/lib/jvm/oracle-java-8/bin/javap 300
RUN update-alternatives --install /usr/bin/jar jar /usr/lib/jvm/oracle-java-8/bin/jar 300
RUN update-alternatives --install /usr/bin/jps jps /usr/lib/jvm/oracle-java-8/bin/jps 300
RUN update-alternatives --install /usr/bin/jhat jhat /usr/lib/jvm/oracle-java-8/bin/jhat 300
RUN update-alternatives --install /usr/bin/jmap jmap /usr/lib/jvm/oracle-java-8/bin/jmap 300
RUN update-alternatives --install /usr/bin/jstack jstack /usr/lib/jvm/oracle-java-8/bin/jstack 300
RUN update-alternatives --install /usr/bin/jstat jstat /usr/lib/jvm/oracle-java-8/bin/jstat 300
RUN update-alternatives --install /usr/bin/jstatd jstatd /usr/lib/jvm/oracle-java-8/bin/jstatd 300

# Set JDK environment variable
ENV JAVA_HOME /usr/lib/jvm/oracle-java-8/
ENV JRE_HOME $JAVA_HOME/jre
ENV CLASSPATH .:$JAVA_HOME/lib:$JRE_HOME/lib

ENV PATH $PATH:$JAVA_HOME/bin:$JRE_HOME/bin

# Add executable jar file to target directory
ADD spring-boot-examples.jar /opt/spring-boot-examples/

# Expose ports
EXPOSE 8081

WORKDIR /opt/spring-boot-examples/

CMD ["java", "-Xms1g", "-Xmx1g", "-jar", "spring-boot-examples.jar"]