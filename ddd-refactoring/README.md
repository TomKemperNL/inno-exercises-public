# DDD Refactoring
*Language Matters. Comma's ook. Lets eat, grandma.*

## Inleiding
In deze oefening gaan we een aantal kleine gevalletjes behandelen waarin we Domain Driven Design kunnen
toepassen.

In de meegeleverde code hebben we expres geen enkel DDD principe toegepast.
Elke property is een String, alles is Setbaar. Gewoon alles door IntelliJ laten genereren, en zo min mogelijk nadenken.

Dat hebben we allemaal vaker gedaan.

## Exercise 1: Contact (Value Objects)

Dit betekent dat de 'ruimte' van mogelijke Contact-objecten gigantisch is.
En het grootste deel van die ruimte is onzinnig (een contact met "34dsasdf" als TelNr, of met wel een Straat, maar geen Stad?).

Domain-Driven design wil ons helpen, door de ruimte van mogelijke contacts duidelijker te maken. Dit is misschien minder
relevant voor iets als een ContactPersoon, waar we als mens een vrij duidelijk beeld van hebben, maar kan snel belangrijker
worden als we minder expertise in het domein hebben.

Herimplementeer de Contact class (in code of UML) zodanig dat de publieke API meer domein-gedreven is.
Denk hierbij aan:
  * Het correct encapsuleren van de velden
  * Het aanmaken, en afschermen van nieuwe types (classes, zogeheten Value Objects)
  * Het kiezen van methodenamen uit de Ubiquitous Language

## Exercise 2: Survey (Aggregates)

Hier zie je een klein voorbeeld van een Vraag met een aantal Antwoorden.  
In dit geval hebben we besloten de relatie vraag/antwoord bidirectioneel OneToMany te maken. 
Dus 1 antwoord hoort bij 1 vraag. Omdat we bijv. ergens rapporteren over een lijst van antwoorden, en dan is het antwoord
"Ja" op "Wil je nog een koekje?" natuurlijk een heel andere "Ja" dan een "Ja" op "Heb je afgelopen week nog autos gestolen?".

Als je de andere tests uitcomment, dan zul je zien dat er wat dingen mis gaan op het moment dat we een antwoord van 
vraag willen verplaatsen. Als we Domein-gedreven hadden ontworpen, dan hadden we de eisen van het model beter in code
gevangen, en zouden deze bugs niet kunnen optreden.

* Hoe ernstig zou dit probleem nog zijn als de relatie niet meer Bidirectioneel zou zijn?
* Hoe ernstig zou dit probleem nog zijn als we de relatie toch Many-To-Many maken? (zodat je die "Ja" wel kan hergebruiken)
* En stel we moeten het echt zoals gespecificeerd oplossen (dus oneToMany EN bidirectioneel), hoe zou je dat dan doen?
