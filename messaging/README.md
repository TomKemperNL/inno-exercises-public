# RabbitMQ & Spring Demo

Deze demo laat even de minimale setup zien die je nodig hebt om -iets- met messages te doen.

### Opstartchecklist:
- Docker-compose omgeving ge-up'd? Dan kun je naar http://localhost:15672 om RabbitMQ te bewonderen. 
 
### Opdrachten:

#### Warming-up

- Ga in je browser naar http://localhost:15672, en log in met guest/guest. Maak in de GUI een queue, en post daar een bericht naartoe.
- In hello-spring-rabbitmq staat al een beginnetje klaar, vul de rest in zodat je een bericht naar jezelf kan sturen. (bijv. een Class "Boodschap", met daarin een String "content", of zoiets)

Blijf er dus aan denken, dat als het lastig wordt, je altijd zelf een berichtje in je queues kan plaatsen om dingen te debuggen.

Verder kun je vaak zo'n simpele hello-world structuur zoals je in hello-spring-rabbitmq langzaam ingewikkelder maken, totdat je
ineens dezelfde foutmelding als 'in het echt' krijgt. Meestal kom je dan en-passant ook de oplossing van je echte probleem tegen.

#### Messaging patterns

Messaging-exercise bestaat uit 3 losse modules, 2 daarvan gaan met elkaar praten via messaging.

* Oefening 1: Er is een start gemaakt om een bericht te sturen via een Direct Exchange. Maak dit af.
* Oefening 2: Maak Queues en Bindings zodat elk bericht dat je verzend in de Producer in 2 verschillende listeners terecht komt (elke listener krijgt een kopie van het bericht)
  Dit is een vorm van Publish/Subscribe, wat superhandig is om Events naar meerdere delen van je systeem te verdelen
* Oefening 3: Maak Queues en Bindings zodat elk bericht dat je verzend in één van 2 verschillende listeners terecht komt (dus elk bericht wordt maar 1x verwerkt)
  Dit is het *Competing Consumers* pattern. Dit kun je gebruiken om in sommige gevallen de performance te verbeteren. In dat
  geval start je op verschillende machines dezelfde (applicatie met) listeners op, zodat ze met z'n allen samenwerken om die 
  queue zo leeg mogelijk te houden.
