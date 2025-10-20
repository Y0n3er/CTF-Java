FROM maven:3.9.9-eclipse-temurin-17

WORKDIR /build

RUN apt-get update && apt-get install -y git && \
    git clone https://github.com/yamcs/quickstart.git

WORKDIR /build/quickstart

RUN chmod +x mvnw
RUN ./mvnw compile

RUN apt-get update && \
    apt-get install -y python3 python3-pip && \
    apt-get clean

RUN ./mvnw dependency:go-offline

RUN echo FLAG>/flag
EXPOSE 8090

CMD bash -c '\
  nohup python3 simulator.py >/dev/null 2>&1 & \
  ./mvnw yamcs:run'

