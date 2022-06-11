# Sandwich Architectural Kata

Er was eens een broodjeszaak, zeg "Broodje BEP". Deze zaak heeft nu 3 fysieke vestigingen ergens in de stad
en een tweetal foodtruck die op verschillende locaties ingezet wordt (meestal volgens een vast rooster, maar soms flexibel).

Naast de eigenaar, mevrouw Bep (denk aan een grote moederlijke versie van Jos van Reenen), werken bij het bedrijf nu zo'n
15 mensen.

Bij "BEP" is het 'nieuwe' concept dat men via de website eenvoudig een broodje kan bestellen, en dat de klant binnen een paar minuten
een berichtje ontvangt waar en hoe laat hij z'n bestelling op kan halen.
Bij de voorspelling in dit bericht moet rekening worden gehouden met de huidige locatie van de klant, de situatie in de winkel(s),
de huidige verkeersdrukte, en het klantgedrag in het verleden. Het onderscheidende vermogen moet liggen in het gemak en de precisie:
de eigenaar wil absoluut geen rijen wachtende mensen in zijn winkel.

Het is de planning om nauw samen te werken met lokale gemeentes en ondernemers en nauw betrokken te zijn bij evenementen in de stad door middel
van kortingsacties en tijdelijke speciale broodjes.

De ontwikkeling van de ondersteunende software loopt parallel aan de aankoop van meerdere filliaal-locaties, maar daarnaast start de 
eigenaar een franchise-programma.

Thuisbezorging staat met klem *niet* op de planning. Men wil zich richten op stadsbezoekers.

## Context

Als architect werk jij voor een full-service IT-bedrijf, en voor deze opdracht zijn er twee teams van C#-developers beschikbaar om
het geheel op te leveren. Team A is een team met gemixte ervaring (1 senior, 2 mediors en 2 net-van-school). Team B bestaat uit 5 juniors
met gemiddeld een jaar ervaring.

De licentie van het kassa-systeem van "Broodje BEP" is net voor een fors bedrag verlengd.

De huidige website van "Broodje Bep" is een Java-Spring applicatie. Bijzonder fraai vormgegeven. 
Vanuit de klant is het vooral een lijst beschikbare broodjes, met een mooie foto en hun prijs. Vanuit de admin-kant kan
personeel vrij gemakkelijk nieuwe broodjes toevoegen en verwijderen, en een prijsaanpassing doorvoeren. Er is helaas geen
ondersteuning voor tijdelijke aanbiedingen, maar het personeel vindt de broodjes-maker wel erg prettig werken.

## Drivers

1. Ok, dit is natuurlijk incompleet. 
   Verzin 2 vragen die je de opdrachtgever (of juist je eigen werkgever) zou willen stellen om je Design Purpose te kunnen invullen.
   Leg kort (ong. 2-3 zinnen) uit waarom je die vragen hebt gekozen.
   Voor de rest van de vragen zul je het antwoord nu even moeten verzinnen.
2. Laten we eens de Quality Attributes uit ISO 25010 erbij pakken. ![ISO](iso25010.png) Kies (in jouw optiek) de belangrijkste 2 Quality Attributes waarvan je gelooft dat ze een significante invloed op de architectuur gaan hebben. Leg per attribute kort (ong. 2-3 zinnen) uit waarom je die hebt gekozen en leg ook weer kort uit welke kant die de architectuur op ‘driven’ (dus zeg een alinea totaal). Kies hier vooral de hoofdlijn (kopje) niet een los onderdeel binnen zo’n box. (er zijn hier meerdere antwoorden mogelijk, dus het is niet zo dat er exact 2 verstopt zitten die je moet vinden, maar er zijn wel een paar oninteressante die je hier dus niet moet kiezen)
3. Kun je een Architectural Concern benoemen, en kort (ong. 2-3 zinnen) uitleggen wat voor invloed dit op de architectuur zou kunnen hebben?
4. Wat voor Constraints zie je in deze beschrijving?

## Diagrammen

1. Nu dan, gegeven de Primary Functionality, in wat voor modules zou je dit systeem willen onderverdelen? (meer dan 1, niet meer dan 5)?
   Geef in 1 of 2 zinnen per module aan wat je de hoofdverantwoordelijkheid van die module vindt.
   Geef in je diagram ook de meest belangrijke externe systemen aan.
   (je kan hier een UML Component Diagram voor gebruiken, of een C4 Component Diagram, maar minder formele 'boxes & lines' is hier ook prima)
2. Hoe zou je die modules over applicaties verdelen?
   En stel we verplichten je om er minstens 3 applicaties van te maken?
   (je kan hier een UML Deployment Diagram voor gebruiken, of een paar extra lijntjes in je eerdere C4 Component-Diagram, maar maar minder formele 'boxes & lines' is hier ook prima)
3. Wat voor berichten lopen er tussen de verschillende onderdelen voor de primaire usecase?
   (een UML sequence Diagram is hier prima geschikt voor, als je zelf graag een andere notatie gebruikt is dit het moment om die te testen voor de echte inleveropdracht)
4. Wat voor OO-classes kun je gebruiken om er voor te zorgen dat zowel de ontvangende, als de verzendende partij begrijpt wat er 
   in die messages zit? Kortom, hoe ziet je domein-model er in iets meer detail uit?
   (bijv. in de vorm van een UML Class Diagram, of een stukje voorbeeldcode)
