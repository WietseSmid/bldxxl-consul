FROM java-base:local

COPY config/containerpilot.json5 /etc/containerpilot.json5
COPY build/libs/key-value-0.0.1-SNAPSHOT.jar /usr/local/share/key-value.jar

ENTRYPOINT ["/usr/local/bin/containerpilot"]