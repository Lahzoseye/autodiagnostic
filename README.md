# Nom du Projet
Auto diagnostic

## Description
Ce projet est une application qui permet de renvoyer sur quel service le patient d'index de santé x doit entre envoyé."

## Fonctionnalités
- API qui permet de trouver l'orientation du patient

## Prérequis
Docker

## Execution
Pour demarrer le projet merci de faire les instructions suivant
-> mvn clean package -DskipTests
-> docker build -t monapplication .
-> docker run -p 9001:9001 monapplication .

## Requete pour tester l'application
curl --request GET \
  --url 'http://localhost:9001/api/capteur?=&index=33' \
  --header 'User-Agent: insomnia/10.1.1'
