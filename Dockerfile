FROM java:8-jdk-alpine
COPY ./target/CryptosCastle-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
ENTRYPOINT ["java","-jar","CryptosCastle-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080