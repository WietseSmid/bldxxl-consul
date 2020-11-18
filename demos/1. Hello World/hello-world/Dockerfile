FROM java-base:local

COPY config/containerpilot.json5 /etc/containerpilot.json5
COPY build/libs/hello-world-0.0.1-SNAPSHOT.jar /usr/local/share/hello-world.jar

ENTRYPOINT ["/usr/local/bin/containerpilot"]