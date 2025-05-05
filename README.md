# Bibliothèque Universitaire - Système Hybride REST/SOAP

## Description
Système de gestion de bibliothèque universitaire offrant:
- Une API REST pour les utilisateurs (étudiants/professeurs)
- Une API SOAP pour les bibliothécaires

## Technologies
- Java 21
- Spring Boot 3.2.1
- H2 Database
- Spring WS (SOAP)
- SpringDoc OpenAPI (Swagger)

## Installation

### Prérequis
- JDK 21
- Maven 3.8+

### Étapes d'installation
1. Cloner le repository
```bash
git clone https://github.com/votre-repo/demo-ws.git
cd demo-ws
```

2. Compiler le projet
```bash
mvn clean install
```

3. Lancer l'application
```bash
mvn spring-boot:run
```

## Documentation API

### API REST
La documentation Swagger est disponible à:
- http://localhost:8080/swagger-ui.html

Endpoints principaux:
- GET api/livres : Liste tous les livres
- GET api/livres/{id} : Détails d'un livre
- GET api/livres/disponibles : Liste les livres disponibles
- POST /reservations : Créer une réservation
- GET /reservations/{id} : Consulter une réservation

### API SOAP

Opérations disponibles:
- ajouterLivre
- modifierLivre
- supprimerLivre
- preterLivre
- retournerLivre

## Base de données

L'application utilise H2 (base de données en mémoire):
- Console H2: http://localhost:8080/h2-console
- JDBC URL: jdbc:h2:mem:bibliotheque
- Username: sa
- Password: (vide)

## Guide d'utilisation

### Pour les utilisateurs (API REST)

1. Consulter les livres disponibles:
```bash
curl http://localhost:8080/livres/disponibles
```

2. Réserver un livre:
```bash
curl -X POST http://localhost:8080/reservations \
  -H "Content-Type: application/json" \
  -d '{"userId": 1, "livreId": 1, "dateDebut": "2025-05-01", "dateFin": "2025-05-15"}'
```

### Pour les bibliothécaires (API SOAP)

Exemples de requêtes SOAP (utiliser SoapUI):

1. Ajouter un livre:
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:bib="http://courwebservice.sn/demo-ws">
   <soapenv:Header/>
   <soapenv:Body>
      <bib:ajouterLivreRequest>
         <bib:livre>
            <bib:titre>Nouveau Livre</bib:titre>
            <bib:auteur>Auteur Test</bib:auteur>
            <bib:isbn>123-456-789</bib:isbn>
         </bib:livre>
      </bib:ajouterLivreRequest>
   </soapenv:Body>
</soapenv:Envelope>
```

## Support

Pour toute question ou problème:
- Ouvrir une issue sur GitHub
- Contacter l'équipe de support : https://github.com/AhmedGueye221
https://github.com/Estherdevdiop
