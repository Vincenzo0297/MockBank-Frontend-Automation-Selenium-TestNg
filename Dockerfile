FROM selenium/standalone-chrome:latest

WORKDIR /app

COPY . .

USER root

RUN apt-get update && apt-get install -y maven

CMD ["mvn", "clean", "test"]