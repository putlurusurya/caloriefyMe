FROM eclipse-temurin

RUN mkdir -p /app

ENV FLASK_ENV_URL http://localhost:5000

WORKDIR /app

COPY target/CaloriefyMe.jar /app/CaloriefyMe.jar

EXPOSE 8080

CMD [ "java","-jar","CaloriefyMe.jar","--caloriefyme.dl.api.url=${FLASK_ENV_URL}"]

