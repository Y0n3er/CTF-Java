FROM debian:11-slim

RUN groupadd -r ctf && \
    useradd -m -r -g ctf ctf && \
    mkdir /app/ && \
    chown -R ctf:ctf /app/

COPY --chmod=755 ./files/docker-entrypoint.sh /docker-entrypoint.sh
COPY ./files/EspressoCoffee.jar /app/

ADD https://gds.oracle.com/download/espresso/archive/espresso-java21-24.1.1-linux-amd64.tar.gz /app/

RUN tar -xzvf /app/espresso-java21-24.1.1-linux-amd64.tar.gz -C /app/ && \
    rm /app/espresso-java21-24.1.1-linux-amd64.tar.gz

EXPOSE 8000

ENTRYPOINT [ "/docker-entrypoint.sh" ]
