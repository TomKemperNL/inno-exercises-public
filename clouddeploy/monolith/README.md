# Monoliet Deployment

Deze oefening is om een simpele CRUD-applicatie te deployen naar Azure.
De code is relatief rechttoe rechtaan, dus het gaat er om hoe je dit in Azure deployt op een handige manier.

Voor het grootste gedeelte gaat dit hetzelfde werken als de [Hello World](./../hellospring/README.md), 
maar er is één extra onderdeel: de database. Daar moet je wat mee.

Opties:
1) (PaaS) Azure SQL database (kost ~4-6 euro per maand). Paar keer klikken, en voor het Basic DTU plan gaan.
2) (PaaS) Azure PostGres database (kost ~20 euro per maand). Ook relatief eenvoudig op te zetten, 5x zo duur vanwege *wie-weet??*
3) (CaaS) Je eigen PostGres container (kosten variabel afhankelijk welke container-hosting je gebruikt)
4) (IaaS) Je eigen PostGres Virtual Machine 

Aangezien je deze exercise toch elk moment weer kan verwijderen zijn bijna alle opties wel eventjes betaalbaar.

De moeilijkheid is hier dat je moet aangeven waar je database woont. Hiervoor zul je extra zaken in moeten stellen.
Dit kan op een aantal manieren (CISQ2):

1. Configuratie-files (verschillende Profiles)
2. Environment Variables
3. Configuratie-servers 

Voor nu is een combinatie tussen 1. & 2. de meest voor de hand-liggende optie. Losse 
files voor alles behalve secrets, en environment variables voor de secrets. (want die
wil je [-echt niet-](https://www.comparitech.com/blog/information-security/github-honeypot/) in versiebeheer hebben).



