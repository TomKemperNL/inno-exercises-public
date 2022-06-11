# Tennis-Kata
*Een opdracht die probeert zoveel mogelijk 2dejaars kennis weer op te frissen.*

## Inleiding

Hopelijk is iedereen een beetje bijgekomen van de zomervakantie, dus het is tijd om weer even de programmeervingers wakker te maken.

Als warming-up doen we een zogeheten [Code Kata](https://en.wikipedia.org/wiki/Kata#Outside_martial_arts), een programmeeropdracht
niet zozeer omdat we het eindresultaat nodig hebben, maar omdat het een boel onderdelen van onze kennis raakt.

In deze *Kata* gaan we via een RESTful webservice een potje [Tennis](https://en.wikipedia.org/wiki/Tennis_scoring_system) spelen. 
Tennis is waarschijnlijk redelijk bekend bij iedereen, maar heeft net genoeg rariteiten om 'een beetje irritant' te zijn om
uit te programmeren.

Het is de bedoeling dat je deze opdracht individueel maakt. Uiteraard mag je met medestudenten overleggen, maar we willen vooral dat 
je zelf even die programmeerskills weer wakker schudt. Je kunt iemand anders ook niet voor je laten warm-lopen!

*LET OP: Een helemaal prachtige, feature-complete Tennis-API bouwen is daaaagen werk. Dat is **niet** de bedoeling bij deze opdracht*

## Gegeven

Er is al een beetje code gegeven, genoeg om een Game tussen twee spelers te starten. We hebben geprobeerd zoveel mogelijk
verschillende onderwerpen van BEP2, D&P en CISQ langs te laten komen. Een kleine greep:

* REST, in de TennisController
* Allerhande tests-zaken (Unit-tests, Integratie-tests en mocks)
* Persistency & Cascades in de @Entity Classes

De gebruikte (relationele) database is H2, dat is een in-memory broertje van Postgres. Deze is toegankelijk via
je browser in een omgeving die veel op PGAdmin lijkt. Probeer aub. deze gewoon te gebruiken (want minder gedoe),
maar als je echt niet wilt staat het je vrij een PostGres docker-containertje te hanteren natuurlijk.

## Opdracht

Implementeer genoeg code om 1 Game te kunnen spelen. Idealiter met de juiste regels voor *Deuce*.
Per gemaakt punt stuurt "de client" (dus vanuit Postman) een request naar de server. 
Het is mogelijk ergens een huidig score-overzicht te GET'en. Verder accepteert de server geen verdere punten
als de Game al afgelopen is.

Hoofddoelen (focus hierop):
* (her-)oefenen met OO-programmeren, door op een nette manier de score bij te houden, en die gekke Deuce regels te 
representeren zonder al te hacky kunstgrepen
* (her-)oefenen van het ontwerpen van een RESTful web-service

Zijdoelen (handig, tof als het lukt, maar niet het hoofddoel):
* Nette unit~ en integratietests bijhouden
* Performance, security en dat soort zaken

Uiteraard is het ICT, dus het kan altijd dat je 1.5 uur je scheef staart op een komma. Dat hoort erbij en kan ook een
prima kata zijn.
