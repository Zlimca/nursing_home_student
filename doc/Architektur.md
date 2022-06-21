# Architektur
![Architektur](Umsetzung%20des%20DAO-Pattern%20in%20NHPlus.jpg)
## Aufgaben
> Architektur: DAO-Pattern, MVP-Pattern, Singleton-Pattern, generische Klassen, JDBC 

Starte die Anwendung über den Run-Button rechts oben in der Symbolleiste von IntelliJ. Klicke dich durch die Anwendung und finde heraus, was die Anwendung alles kann!

1. Studiere das Klassendiagramm „Umsetzung des DAO-Pattern in NHPlus.jpg“ sowie die verlinkten Informationsblätter und beantworte in deiner Gruppe folgende Fragen:
	1. Erläutere das Zusammenspiel von DAOImp, PatientDAO und der Datenbanktabelle Patient, wenn die im Interface DAO definierte Methode void create(T t) throws SQLException aufgerufen wird, um einen neuen Patienten anzulegen.
	2. Stelle dir vor, du sollst die Anwendung um ein Modul erweitern, das Pflegekräfte verwaltet. Innerhalb dieses Modus können Pflegekräfte angezeigt, angelegt, geändert und gelöscht werden. Was müsstest du dafür in dieser Architektur tun? Welchen Vorteil bietet diese Architektur im Vergleich zu einer Architektur, in der es zu jeder Modelklasse eine konkrete DAO-Klasse gibt, also das DAO-Interface und die abstrakte Klasse DAOImp nicht existierten? Gehe bei deiner Antwort auch darauf ein, weswegen eine generische Klasse (<T>) verwendet wurde.

	3. Welche Aufgabe hat die Klasse ConnectionBuilder bzw. warum hält PatientDAO keine Datenbankverbindung?
	4. Welche Aufgabe hat die Klasse DAOFactory?
	5. Warum sind DAOFactory und ConnectionBuilder als Singleton implementiert?

2. Erkläre das Zusammenspiel der Klassen Patient, AllPatientController und AllPatientView.fxml im verwendeten MVP-Pattern im folgenden Anwendungsfall: Der Benutzer gibt im Bereich unter der Ansicht aller Patienten vollständig die Daten eines neuen Patienten ein und drückt den Button Hinzufügen. Erläutere, was genau in der View, im Model und im Presenter nacheinander abläuft. Der Ablauf zum Speichern des neuen Patienten muss nicht beschrieben werden (siehe Aufgabe 1b). Worin liegt der Unterschied zu einer MVC-Architektur?

## Lösungen
### 1.a. Zusammenspiel von `DAOImp`, `PatientDAO` und der Datenbanktabelle `Patient` in der Methode `void create(T t) throws SQLException`
`PatientDAO` erbt von `DAOImp`, wo die create Methode definiert wird. In der `create` Methode des `DAOImp` wird ein SQL-Statement über die konkrete Klasse `PatientDAO` bezogen. Die Methode zur Erstellung des SQL-Statements, wird durch eine abstrakte Methode aus `DAOImp` zwangsläufig in `PatientDAO` überschrieben. 
### 1.b. 
![DAO-Pattern](https://media.geeksforgeeks.org/wp-content/uploads/20211112084954/objectpattern.jpg)
Um diese Erweiterung vorzunehmen muss zum einen eine neue Klasse “Caregiver” (Pflegekraft) erstellt werden, die die Klasse “Person” erweitert. In dieser Klasse werden Variablen mit den Informationen zum Pfleger angelegt, z.B. Name, Geburtsdatum. Es wird zusätzlich eine neue Controller Klasse “AllCaregiverController” gebraucht, mit der die gespeicherten Daten zu den Pflegern in einer Tabelle angezeigt werden können. In der Klasse “MainWindowController” muss die Methode “handleShowAllCaregivers” ergänzt werden, damit auch auf die neuen Daten zugegriffen werden kann. Die dafür erforderliche fxml-Datei ist bereits vorhanden. Zuletzt wird eine neue Datastorage Klasse “CaregiverDAO” erstellt, die die DAOimp erweitert, um den Zugriff auf die Datenbank zu ermöglichen.

+model Klasse “Caregiver” extends “Person”

+controller “AllCaregiverController” 

+datastorage “CaregiverDAO” extends “DAOimp”

+Erweiterung von “MainWindowController”

Welchen Vorteil bietet diese Architektur im Vergleich zu einer Architektur, in der es zu jeder Model-Klasse eine konkrete DAO-Klasse gibt, also das DAO-Interface und die abstrakte Klasse DAOImp nicht existierten? 

Ohne die Verwendung des DAO-Pattern müssten die beiden Klassen PatientDAO und TreatmentDAO jeweils die in DAOimp ausgelagerten Methoden create, read, update usw. beinhalten. Das wäre eine Codedoppelung, die mit den DAO-Klassen vermeidbar ist. Zudem ermöglicht dieses Pattern eine Kapselung, sodass das Transfer-Objekt, in unserem Fall die Controller, nie direkt mit der Datenbank kommunizieren, sondern diese Kommunikation immer über das DAO-Pattern läuft.

Durch die Verwendung von generischen Klassen bleibt das DAO-Pattern universell verwendbar. Ohne die Verwendung von Generics müsste es für jede der beiden Klassen PatientDAO und TreatmentDAO eine eigene DAOImp gehen, da sie verschiedene Typen beinhalten.

### 1.c. Welche Aufgabe hat die Klasse `ConnectionBuilder` bzw. warum hält `PatientDAO` keine Datenbankverbindung?
Mit dem `ConnectionBuilder`, welcher als Singleton implementiert wurde, kann eine Verbindung zur Datenbank hergestellt werden. Damit es nur eine Instanz dieses Objekts geben kann wird das Singleton-Patter angewendet.
`PatientDAO` hält keine Verbindung zur Datenbank, da dies von der Super-Klasse `DAOImp` kontrolliert wird.
### 1.d. Welche Aufgabe hat die Klasse DAOFactory?
Über die Factory werden Informationen für `Treatment` und `Patient` Objekte geladen und das jeweilige neue Objekt wird erzeugt und zurückgegeben.
### 1.e.  Warum sind DAOFactory und ConnectionBuilder als Singleton implementiert?
Damit nur eine einzige Instanz des Objekts bestehen kann, wird das Singleton-Pattern angewendet. Es bietet den Vorteil, dass immer dasselbe Objekt zurückgegeben wird. 
Beispielsweise hat ein Unternehmen nur einen CEO, das heißt es wird immer nach demselben Objekt gefragt. Da bietet es sich an ein Singleton-Pattern zu verwenden.

### 2. Zusammenspiel der Klassen `Patient`, `AllPatientController` und `AllPatientView.fxml` im verwendeten MVP-Pattern
Nach dem MVP-Pattern ist die `Patient` Klasse das Model. In diesem wird die Logik verarbeitet und an den Presenter `AllPatientController` weitergegeben. Die Informationen werden über den Presenter an die View `AllPatientView.fxml` übergeben, welche die Eingaben und Events des Users verarbeitet und wieder an den Presenter zurückgibt, damit die Änderungen im Model verarbeitet werden.

#### MVP-Pattern Lifecycle
![MVP-Lifecycle](https://www.baeldung.com/wp-content/uploads/2021/08/mvp-300x227-1.png)