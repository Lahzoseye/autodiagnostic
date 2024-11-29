#utiliser une image de base
FROM openjdk:17-jdk

#repertoire de travail
WORKDIR /app

#COPIER LE JAR DANS L'IMAGE
COPY target/autodiagnostic-0.0.1-SNAPSHOT.jar app.jar

#EXPOSE LE PORT D'ECOUTE DE L'APPLICATION
EXPOSE 9001

#COMMANDE POUR EXPOSER L'APPLICATION
ENTRYPOINT ["java","-jar","app.jar"]