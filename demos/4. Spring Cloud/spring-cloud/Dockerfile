FROM java-base:local

COPY config/containerpilot.json5 /etc/containerpilot.json5
COPY build/libs/spring-cloud-0.0.1-SNAPSHOT.jar /usr/local/share/spring-cloud.jar

ENTRYPOINT ["/usr/local/bin/containerpilot"]