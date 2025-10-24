From openjdk:8u171-slim


RUN echo "deb http://mirrors.ustc.edu.cn/debian/ stretch main non-free contrib" > /etc/apt/sources.list && \
    echo "deb http://mirrors.ustc.edu.cn/debian/ stretch-updates main non-free contrib" >> /etc/apt/sources.list  && \
    echo "deb http://mirrors.ustc.edu.cn/debian/ stretch-backports main non-free contrib" >> /etc/apt/sources.list && \
    echo "deb-src http://mirrors.ustc.edu.cn/debian/ stretch main non-free contrib" >> /etc/apt/sources.list && \
    echo "deb-src http://mirrors.ustc.edu.cn/debian/ stretch-updates main non-free contrib" >> /etc/apt/sources.list && \
    echo "deb-src http://mirrors.ustc.edu.cn/debian/ stretch-backports main non-free contrib" >> /etc/apt/sources.list && \
    echo "deb http://mirrors.ustc.edu.cn/debian-security/ stretch/updates main non-free contrib" >> /etc/apt/sources.list && \
    echo "deb-src http://mirrors.ustc.edu.cn/debian-security/ stretch/updates main non-free contrib" >> /etc/apt/sources.list && \
    apt-get update -y \
    && apt-get install curl -y \
    && useradd ctf \
    && mkdir /opt/app

COPY ezjava.jar /root
COPY flag       /root/flag
WORKDIR /root


EXPOSE 8080

CMD ["java", "-jar", "/root/ezjava.jar"]
 



