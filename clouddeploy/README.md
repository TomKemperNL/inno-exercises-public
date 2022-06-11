# Azure opties

Wat zijn er veel opties, en zelf ken ik ze ook niet in detail. Wel heb ik ze allemaal even geprobeerd, dus het leek me 
handig de eerste indruk te delen.

## PAAS
Platform as a Service. Azure biedt jou een mogelijkheid een JAR file te uploaden (via een maven plugin, een github action, 
of iets van dien aard). Oftewel Azure regelt de web-server, de NAT-translaties etc: je platform. Wat een service...

### Webapps

De oudste versie van Azure PaaS (Platform as a Service) zijn de zogeheten Azure App Service Web Apps. Een hele mond vol.

Om een Webapp te hosten heb je een zogeheten App-Service Plan nodig.
Stiekem is dit gewoon de VM (Virtual Machine) waar je applicaties op gaan draaien.

Meerdere Web Apps kunnen op 1 Service Plan draaien, met elk hun eigen url.

Het goedkoopste plan is 12 euro per maand, dat gaat prima in de 50,- per maand passen die je vanuit de HU krijgt.

### Springapps

Spring apps zijn een nieuwer Azure PaaS aanbod. In theorie zouden deze apps (omdat het allemaal Spring applicaties zijn)
mooiere monitoring en andere admin-zaken hebben.

Helaas is op het moment van schrijven de 'development experience' niet helemaal af...
(als je niet in regio US-east werkt detecteert de plugin je apps bijvoorbeeld niet).
Een ander nadeel is dat je alleen het basic plan (200 euro per maand...) kan kiezen via de CI/CD plugin,
en niet de 'pay-as-you-go' (wat een paar euro per maand zou zijn voor een schoolproject).

Kortom, leuk idee, en als je er extra tijd en moeite in wilt stoppen waarschijnlijk prima aan de praat te krijgen met
extra config-file-tweaks en azure-cli commando's. Maar ik heb het daar laten liggen.


## CAAS

Containers as a Service. Je zou er ook voor kunnen kiezen om de applicatie als container te deployen. 
Dit is iets meer gedoe, maar dan is het makkelijker om de omgeving na te bouwen in Development, en er later extra services
bij te zetten.

Uiteraard zijn hier ook weer (te veel) opties.

### Azure Container AppService

Basically zoals de eerste optie, alleen in plaats van dat je een plugin aanroept (of via Github automatisch deployt) kun je nu een container aanwijzen.

Deze container draait dan op de VM zoals je die eerder gedefinieerd hebt. Qua kosten wel prima, omdat je puur voor die VM betaalt.

Gotchas:

1. Bij de PaaS deployment wordt automatisch de poort van 8080 -> 80 geswitched. Hier niet. Dus je zult of een container moeten bouwen die op port 80 serveert, of een environment variable (SERVER.PORT) op 80 moeten zetten met de hand.

2. De opmaak van je container tag (bij gebruik van een Docker-Hub registry) is:
   `{username}/{reponaam}:{tag}`


### Azure Container Instance

Rauwe container op een Azure-managed container-platform. Verrassend duur (voor schooldoeleinden), dus zorg dat je ze snel weer stop zet!

Puur om ons te narren mag je bij dit smaakje geen '.' in je environment variables gebruiken, dus dan moeten we SERVER_PORT op 80 zetten.

Een laatstje dingetje is dat je een `image-registry-login-server` moet aangeven. Dat is kennelijk (random google) `index.docker.io` voor Docker Hub.
(handig dat ze daar bij de webapp versie een dropdown voor hadden! Ze zouden bij Microsoft eens tussen afdelingen moeten overleggen!)

Tot slot krijg je hier ook geen HTTPS out-of-the-box.

### Azure Container App

Lijkt qua naam heel erg op de App Service, maar is toch weer iets anders (**zucht**).
Ook hier moet je een `image-registry-login-server` aangeven. Dat is kennelijk (random google) `index.docker.io` voor Docker Hub.
Ingress is de naam voor 'binnenkomend verkeer', die heb je inderdaad nodig als je gebruikers bij je applicatie wilt laten.

Eerlijk gezegd (voorzichtig optimistisch) lijkt dit me het prettigste compromis voor de latere opdrachten in het vak.

### Azure Managed Kubernetes

... Dit kunnen we niet betalen op ons abonnement.
