FROM java-base:local

COPY config/containerpilot.json5 /etc/containerpilot.json5
COPY build/libs/main-dns-0.0.1-SNAPSHOT.jar /usr/local/share/main-dns.jar

ENTRYPOINT ["/usr/local/bin/containerpilot"]