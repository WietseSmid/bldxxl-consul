FROM oraclelinux:8.2

USER root

RUN yum -y install unzip tar

ENV CONSUL_VERSION 1.8.5
RUN export checksum=94ab38e6221d3da393d0bbdf19cc524051253a75db078c31e249dad2c497ad46 \
    && curl -Lso /tmp/consul.zip \
         "https://releases.hashicorp.com/consul/${CONSUL_VERSION}/consul_${CONSUL_VERSION}_linux_amd64.zip" \
    && echo "${checksum}  /tmp/consul.zip" | sha256sum -c \
    && unzip /tmp/consul.zip -d /usr/local/bin \
    && rm /tmp/consul.zip

ENV CONTAINERPILOT_VERSION 3.8.0
RUN export checksum=84642c13683ddae6ccb63386e6160e8cb2439c26 \
    && curl -Lso /tmp/containerpilot.tar.gz \
         "https://github.com/joyent/containerpilot/releases/download/${CONTAINERPILOT_VERSION}/containerpilot-${CONTAINERPILOT_VERSION}.tar.gz" \
    && echo "${checksum}  /tmp/containerpilot.tar.gz" | sha1sum -c \
    && tar zxf /tmp/containerpilot.tar.gz -C /usr/local/bin \
    && rm /tmp/containerpilot.tar.gz

	
COPY config/consul.json /etc/consul.d/00_default.json
COPY config/containerpilot.json5 /etc/containerpilot.json5
ENV CONTAINERPILOT=/etc/containerpilot.json5

COPY bin/ /usr/local/bin
RUN chmod -R 755 /usr/local/bin

ENTRYPOINT ["/usr/local/bin/containerpilot"]