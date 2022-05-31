# Datenschutzanalyse
> Du hast im Projekt die Aufgabe übernommen, dich mit den datenschutzrechtlichen Gegebenheiten für die erfolgreiche Umsetzung von NHPlus, auseinander zu setzen. Recherchiere im ersten Schritt die grundlegenden Bestimmungen laut DSGVO bezüglich der Speicherung von Kundendaten und der Daten der Mitarbeiter. 
 ## Aufgaben
Beantworte dabei mindestens folgende Fragen:

1) Was musst du bei der technischen Umsetzung der Speicherung von personenbezogenen Daten bedenken?

2) Welche Rechte haben die Patienten (Kunden) bezogen auf ihre persönlichen Daten?

3) Welche Rechte haben die Mitarbeiter/innen bezogen auf ihre persönlichen Daten?

Begründe deine Antworten jeweils mit kurzen Auszügen aus der DSGVO!

4) Welche Stellen bieten zertifizierte Fortbildungen für angehende Datenschutzbeauftragte an und welche Firmen sind verpflichtet einen eigenen Datenschutzbeauftragten zu stellen?

5) Recherchiere nun die Besonderheiten für die Aufbewahrung von Patientendaten. Wo finden sich diese Regelungen wieder?

6) Welche Grundsätze zur Arbeit mit Patientendaten stehen in Konflikt mit den Grundsätzen der DSGVO?

7) Gegen welche Bestimmungen des Datenschutzgesetzes verstößt NHPlus?

8) Erarbeite ein Konzept, welches die technischen Voraussetzungen für die korrekte Umsetzung aller Gesetze stellt. Benenne dabei die konkreten Änderungen oder Erweiterungen, die in der Anwendung NHPlus zu realisieren sind.

> Fasse deine Antworten zu einer schriftlichen Empfehlung für das Team zusammen, welche eine erfolgreiche, datenschutzkonforme Umsetzung der Software ermöglicht.
> _Hinweis:_ Nutze die anliegenden Informationen, insbesondere für die Krankenhaus/Pflegebezogenen Regelungen und Gesetze.

## Lösung
### 1.-3.
Personenbezogene Daten unterliegen der DSGVO und dem BDSG, das bedeutet sie müssen besonders verarbeitet und gespeichert werden. Art. 5 der DSGVO regelt die Grundsätze der Verarbeitung von personenbezogenen Daten. In den Grundsätzen werden die Schutzziele der IT-Sicherheit definiert, damit verdeutlicht wird, welche Anforderungen vorliegen. 

Schutzziel | Definition
---------- | ----------
Authentizität | Die Daten kommen von der Person für die sie gehalten wird.
Integrität | Korrektheit und Unversehrtheit der Daten.
Vertraulichkeit | Der Zugriff auf die Daten wird Dritten untersagt.
Verfügbarkeit | Die Daten sind immer abrufbar.
Verbindlichkeit | Der Informationsaustausch muss (recht-)verbindlich stattfinden.

Außerdem haben alle die folgenden Rechte bezüglich der Verarbeitung (und damit auch Speicherung) von personenbezogenen Daten: 
(Hier ist zu beachten, dass nur die uns wichtigsten als Beispiele genannt wurden. Es sind nicht alle Artikel gelistet!)

Artikel | Inhalt
------- | ------
13 | Informationspflicht bei Erhebung von personenbezogenen Daten bei der betroffenen Person
15 | Auskunftsrecht der betroffenen Person
16 | Recht auf Berichtigung
17 | Recht auch Löschung ("Recht auf Vergessenwerden")
18 | Recht auf Einschränkung der Verarbeitung
19 | Mitteilungspflicht im Zusammenhang mit der Berichtigung oder Löschung personenbezogener Daten oder der Einschränkung der Verarbeitung
20 | Recht auf Datenübertragbarkeit
21 | Widerspruchsrecht

Im Kontext von NHPlus werden auch personenbezogene Daten zur Gesundheit verarbeitet, diese fallen in eine Sonderkategorie im Datenschutz. Da Krankenakten nicht direkt gelöscht werden können. Da sich sowohl Patienten als auch Ärzte auf diese Berufen müssen, ob nun durch eine weitere Behandlung oder vor Gericht. Deshalb werden die Daten bis zu 30 Jahre aufbewahrt und danach erst gelöscht, dies geschieht im Rahmen der Dokumentationspflicht des §603f BGB. Die Einsicht der gespeicherten Daten, wie z.B. der Krankenakte kann eingeschränkt werden. Nach Art. 9 Abs. 4 DSGVO in Verbindung mit §630g GBG kann das Auskunftsrecht aus Art. 15 beschränkt werden, wenn der Patient dadurch Schaden erleiden könnte.
Für Arbeitnehmer existiert ein Sonderfall, falls er erkrankt und im selben Krankenhaus behandelt wird. Hier greift die Fürsorgepflicht des Arbeitgebers, da die Kollegen nicht vom Aufenthalt des erkrankten erfahren dürfen, außer sie haben unmittelbar mit der Behandlung zutun.

### 4.
Der TÜV bietet mehrtägige Seminare an, mit denen die Fortbildung zum Datenschutzbeauftragten abgeschlossen werden kann. In Artikel 37 der DSGVO wird festgelegt, wann ein solcher Datenschutzbeauftragter bestellt werden muss. Demnach müssen alle Unternehmen mit einer Haupttätigkeit in der Datenverarbeitung einen Datenschutzbeauftragten bestellen, besonders, wenn es sich um Personendaten handelt. Dazu gibt es weitere Spezifizierungen im §38 des BDSG, wodurch bereits Unternehmen in denen mindestens zehn Mitarbeiter mit der automatisierten Verarbeitung personenbezogener Daten arbeiten, einen Datenschutzbeauftragten einstellen müssen.

### 5.
Die Datenschutzrechte von Personen können je nach Bundesland in einem speziellen Krankenhausdatenschutzgesetz festgehalten sein. Das Bremische Krankenhausdatenschutzgesetz besagt beispielsweise, dass Patientendaten gelöscht werden müssen, sobald die Behandlung abgeschlossen ist und die Daten danach sicher nicht mehr benötigt werden. Patientendaten in Krankenakten werden lediglich gesperrt und nach 30 Jahren gelöscht (§6 (1) BremKHDSG). Eine solche Sperrung kann nur in bestimmten Fällen aufgehoben, wenn zum Beispiel die Daten für eine zusammenhängende Behandlung gebraucht werden und wenn der Patient der Verwendung einwilligt (§6 (4) BremKHDSG).

### 6.
>**Feedback**: *Bei dieser Aufgabe ist nicht ganz klar geworden welche "Grundsätze zur Arbeit mit Patientendaten" gemeint sind. Deshalb haben wir recherchiert und die Informationen aus Art. 5 der DSGVO und anderen Quellen für die Patienten Grundsätze genommen. Diese wollten wir gegenüberstellen, damit die Probleme erkenntlich werden.*

Grundsatz der DSGVO | Grundsatz zur Arbeit mit Patientendaten | Konflikt
------------------- | --------------------------------------- | --------
Rechtmäßige Verarbeitung | Die Daten werden nach den Kriterien der Schutzziele verarbeitet | Stellt keinen Konflikt dar
Treu und Glauben | Patienten erhalten das Wissen darüber, welche Daten gesammelt werden. | Stellt keinen Konflikt dar
Transparenz | Betroffene können ihre Daten einsehen | Unter bestimmten umständen wie Behandlung einer psychischen Erkrankung, kann die Einsicht in die Akten verweigert werden, wenn die betroffene Person dadurch Schaden erleiden würde.
Zweckbindung | Die Patientendaten werden zur Behandlung des Patienten aufbewahrt | Stellt keinen Konflikt dar
Datenminimierung | Speicherung von Daten über die Gesundheit z.B. Krankenakte | Stellt keinen Konflikt dar
Speicherbegrenzung | Patientendaten müssen zwischen 10 und 30 Jahren gespeichert werden | Stellt keinen Konflikt dar, da die Daten für unter anderem für die Rechenschaftspflicht relevant sind.
Integrität und Vertraulichkeit | Hier gilt die ärztliche Schweigepflicht | Stellt keinen Konflikt dar
Rechenschaftspflicht | Aufbewahren von Patientendaten im Falle von Rechtskonflikten | Stellt keinen Konflikt dar

### 7.
NHPlus verstößt gegen mehrere Grundsätze der DSGVO. Zum einen der Grundsatz der Vertraulichkeit, denn alle Patientendaten sind für jeden einsehbar, weil keine Identitätskontrolle in Form einer Anmeldung oder Ähnlichem stattfindet (Artikel 5 f). Des Weiteren dem Grundsatz der Datenminimierung, da auch Daten über den Vermögensstand gespeichert werden, obwohl diese für die Behandlung nicht notwendig sind (Artikel 5 c). NHPlus bietet momentan keine Möglichkeit zur Datensperrung bzw. Datenaufbewahrung, wie es in Artikel 17 Abs. 3 vorgeschrieben ist.

### 8.
>**Feedback**: *Da die Aufgabenstellung nicht ganz klar war (und wir nicht mehr dazu kamen es zu hinterfragen) erläutern wir dies nochmal. Wir verstanden die Aufgabe so, dass ein Konzept mit der technischen Umsetzung entworfen werden sollte, um die Datenschutzprobleme von NHPlus zu lösen. Außerdem soll dieses Konzept in eine schriftliche Empfehlung gefasst werden, damit deutlich ist warum und in Ansätzen wie es umgesetzt werden soll.*

Ziel | Lösung
---- | ------
Authentizität | NHPlus wird von einem Log-In-System unterstützt
Integrität | Die Daten können nur von autorisierten Personen verändert werden. Das geschieht über Personengruppen.
Datenminimierung | Reduzierung auf relevante Daten über Patienten und Mitarbeiter
Vertraulichkeit | Verschlüsselung durch AES (Advanced Encryption Standard) und Passwortaufbewahrung durch Hashtabelle
Verfügbarkeit | Die Datenbank wird durch ein RAID-5 System erreichbar gehalten
Verbindlichkeit | Logging-System 
Datensperrung | Damit Daten nicht verändert werden können wird ein neues Feld in der Tabelle angelegt, welches handhabt ob ein Datensatz bearbeitbar sein darf. 

##### Empfehlung
Damit keine Dritten in NHPlus Daten einsehen oder ändern können, muss ein Log-In-System eingerichtet werden. Außerdem braucht es unterschiedliche Autorisierungsstufen der Mitarbeiter, damit nicht jeder Mitarbeiter alle Daten, sondern nur einen Teil der Daten ändern oder einsehen kann. Außerdem wird ein Logging-System gebraucht, damit Änderungen der Daten mitgeschrieben werden und keine Informationen verloren gehen. 
Nicht alle Daten über Patienten oder Mitarbeiter sind relevant. Deswegen werden in Zukunft keine Informationen über den Vermögensstand gesammelt. Außerdem muss die Datenbank verschlüsselt werden und unabhängig von der Datenbank für das Log-In-System sein. Zur Verschlüsselung einer Datenbank eigner sich AES (Advanced Encryption Standard) sehr gut. 
Des Weiteren ist eine Backuplösung erfordert, wozu ein Raid-5 System geeignet ist. Raid-5 ist schnell und bietet eine sehr gute Ausfallsicherheit, da die daten in Paritäten auf den unterschiedlichen Platten gesichert werden und sie dadurch wiederhergestellt werden können. Die Anzahl der Platten die ausfallen können ist von der Gesamtanzahl an Platten abhängig.
Da ein Krankenhaus ein Sonderfall ist und Daten gesperrt werden können müssen, wird eine Möglichkeit benötigt Daten nicht ändern zu können. Dies kann über ein zusätzliches Feld auf dem Datensatz gemacht werden, welches angibt, ob ein Datensatz geändert werden darf. Wenn Informationen aus dem gesperrten Datensatz zum Bearbeiten oder Lesen abgerufen werden, müssen diese **immer** als nicht editierbare Felder eingebaut sein.

## Quellen
Itsleaning Ressourcen aus LF04, LF05, Politik
https://www.krankenhaus.de/aufenthalt/datenschutz-im-krankenhaus-worauf-kommt-es-an/ 
https://dsgvo-gesetz.de/art-90-dsgvo/ 
https://www.vzhh.de/themen/telefon-internet/datenschutz/dsgvo-ihre-daten-ihre-rechte 
https://www.hensche.de/datenschutz-im-arbeitsrecht.html 
[Fortbildung als Datenschutzbeauftragter I Datenschutz 2022](https://www.datenschutz.org/fortbildung-datenschutzbeauftragter/#:~:text=Angebote%20f%C3%BCr%20eine%20Fortbildung%20als,und%20Umfang%20diese%20Fortbildung%20an.) 
[Bestellung: Datenschutzbeauftragter | Datenschutz 2022](https://www.datenschutz.org/bestellung-datenschutzbeauftragter/) 
[Grundsätze der DSGVO](https://www.fokus-datenschutz.de/welche-grundsatze-fur-die-verarbeitung-personenbezogener-daten-mussen-beachtet-werden) 
https://www.datenschutz.org/patientendaten/ 
https://en.wikipedia.org/wiki/Standard_RAID_levels 
https://www.kryptowissen.de/schutzziele.php 
https://www.fokus-datenschutz.de/welche-grundsatze-fur-die-verarbeitung-personenbezogener-daten-mussen-beachtet-werden 