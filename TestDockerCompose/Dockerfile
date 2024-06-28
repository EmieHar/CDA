# Utiliser une image de base avec Java 11
FROM openjdk:11-jre-slim

# Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Copier le fichier JAR généré par Maven dans le conteneur
COPY target/TestDockerCompose.jar app.jar

# Exposer le port sur lequel l'application Spring Boot écoute
EXPOSE 8080

# Commande à exécuter au démarrage du conteneur
CMD ["java", "-jar", "app.jar"]
