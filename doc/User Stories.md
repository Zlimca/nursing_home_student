# NHPlus User Stories

> ## Aufgabenstellung
> Plane innerhalb deiner Gruppe die noch ausstehenden Module, indem du
>
> a) User-Stories formulierst
>
> b) über die Formulierung von Akzeptanzkriterien definierst, wann eine User-Story fertig implementiert ist
>
> c) aus der User-Story und ihren Akzeptanzkriterien Tasks ableitest. Die Tasks sollen genau festlegen, welche Klassen
> neu zu implementieren und welche Klassen an welcher Stelle um welches Element anzupassen sind.
>
> d) abschließend aus den Akzeptanzkriterien für die Testphase Testfälle ableitest.

## Lösung

### Aufgabe 1

<table>
	<td>Die Navigationsleiste am linken Rand der Anwendung soll einen weiteren Button bekommen, über den zu einer Ansicht gewechselt wird, die alle Pfleger/Pflegerinnen mit ihrer ID, ihrem Nach- und Vornamen sowie ihrer Telefonnummer angezeigt werden. (Diese Ansicht wurde bereits im letzten Sprint in der Datei AllCaregiverView.fxml fertiggestellt und wurde vom Auftraggeber so abgenommen).</td>
	<tr>
		<th>User Story 1</th>
	</tr>
	<tr>
			<td>Als Pfleger/Pflegerin möchte ich die relevanten Daten aller Pflegerinnen und Pfleger einsehen können, um jeden Pflegenden gegebenenfalls über das Telefon erreichen zu können.</td>
	</tr>
	<tr>
		<th>Akzeptanzkriterien</th>
	</tr>
	<tr>
			<td>
				<p>A_1: Die Navigationsleiste in der Übersicht wird um einen weiteren Button erweitert.</p>
				<p>A_2: Die Pfleger/Pflegerinnen-Daten bestehen aus ihrer ID, Nach- und Vorname und der Telefonnummer.</p>
				<p>A_3: Beim Klicken des Buttons öffnet sich eine neue Tabelle, in der die Pfleger/Pflegerinnen-Daten angezeigt werden können.</p>
				<p>A_4: Die Daten werden vollständig angezeigt.</p>
			</td>
	</tr>
	<tr>
		<th>Task</th>
	</tr>
	<tr>
			<td>
				<p>T_1: Modelklasse Pfleger/Pflegerin erstellen: abgeleitet von Person</p>
				<p>T_2: CaregiverDAO erstellen</p>
				<p>T_3: In der Datenbank eine neue Tabelle „Caregiver“ mit den benötigten Daten anlegen</p>
				<p>T_4: Erstellung des Caregiver Controllers für die Anzeige der Tabelle</p>
				<p>T_5: Erweiterung des MainWindowControllers um die bereits erstellte AllCaregiverView.fxml</p> </td>
		</tr>
	<tr>
		<th>Testfall</th>
	</tr>
	<tr>
			<td>
				<p><b>TF_1: Alle Pfleger und Pflegerinnen anzeigen </b></p>
				<p><b>Vorbedingung: Der User hat im Hauptmenü Pfleger/Pflegerinnen ausgewählt.</b></p>
				<div>
					<p><b>auszuführende Testschritte: -</b></p>
				</div>
				<div>
					<b>erwartetes Ergebnis:</b>
					<ol>
						<li>In einer Anzeige/Tabelle werden alle Daten zu den Pflegern/Pflegerinnen (ID, Nachname, Name, Telefon…) angezeigt, die in der Datenbank gespeichert sind.</li>
					</ol>
				</div>
			</td>
	</tr>
	<tr>
		<th>User Story 2</th>
	</tr>
	<tr>
		<td>Als Mitarbeiter der Personalabteilung möchte ich die relevanten Daten aller Pflegerinnen und Pfleger verwalten und gegebenenfalls bearbeiten können.</td>
	</tr>
	<tr>
		<th>Akzeptanzkriterien</th>
	</tr>
	<tr>
		<td>
			<p>A_1: Die Informationen können aus der Übersicht heraus geändert werden.</p>
			<p>A_2: Es können neue Pfleger/Pflegerinnen angelegt werden.</p>
			<p>A_3: Ein ausgewählter Pfleger/Pflegerin kann gelöscht werden.</p>
			<p>A_4: Bei unvollständiger Ausfüllung der Daten erscheint eine Fehlermeldung.</p>
			<p>A_5:  Informationen werden in der Pfleger Tabelle gespeichert.</p>
		</td>
	</tr>
	<tr>
		<th>Task</th>
	</tr>
		<tr>
			<td>
				<p>T_1: Erweiterung des Caregiver Controllers um die Methoden: ändern, löschen, anlegen.</p>
				<p>T_2: CaregiverDAO um die Methoden zum Schreiben und Löschen erweitern.</p>
				<p>(Die Buttons sind bereits in der AllCaregiveView.fxml vorhanden)</p> 
			</td>
		</tr>
	<tr>
		<th>Testfall</th>
	</tr>
	<tr>
			<td>
				<p><b>TF_1: Es können neue Pfleger angelegt werden</b></p>
				<p><b>Vorbedingung: Der User hat im Hauptmenü Pfleger/Pflegerinnen ausgewählt.</b></p>
				<div>
					<p><b>auszuführende Testschritte:</b></p>
				</div>
					<ol>
						<li> Die in der Anzeige vorliegenden Datenfelder des zu erstellenden Pflegers/Pflegerin sind vollständig ausgefüllt</li>
						<li>Der User klickt den Button „hinzufügen“</li>
					</ol>
				<div>
					<b>erwartetes Ergebnis:</b>
					<ol>
						<li> Der neu erstellte Eintrag zum Pfleger/Pflegerin wir in der Liste darüber eingetragen/aufgelistet.</li>
						<li> In der Datenbank wird ein neuer Eintrag in der Pfleger/Pflegerin-Tabelle mit allen eingetragenen Daten erstellt. </li>
					</ol>
				</div>

				<p><b>TF_2: Es können bestehende Pfleger/Pflegerinnen bearbeitet werden</b></p>
				<p><b>Vorbedingung: Der User hat im Hauptmenü Pfleger/Pflegerinnen ausgewählt.</b></p>
				<div>
					<p><b>auszuführende Testschritte:</b></p>
				</div>
					<ol>
						<li> Der User macht in der Tabelle einen Doppelklick auf den Eintrag und das Feld, welches geändert werden soll.</li>
						<li> Die neuen Daten werden eingegeben und mit der Enter-Taste bestätigt.</li>
					</ol>
				<div>
					<b>erwartetes Ergebnis:</b>
					<ol>
						<li> Die gemachten Änderungen werden nun in der Tabelle angezeigt.</li>
						<li> In der Datenbank wurden diese Änderungen auch übernommen.</li>
					</ol>
				</div>
				<p><b>TF_3: Es können nur gültige Daten gespeichert werden.</b></p>
				<p><b>Vorbedingung: Der User hat im Hauptmenü Pfleger/Pflegerinnen ausgewählt.</b></p>
				<div>
					<p><b>auszuführende Testschritte:</b></p>
				</div>
					<ol>
						<li> Die in der Anzeige vorliegenden Datenfelder des zu erstellenden Pflegers/Pflegerin sind nicht vollständig ausgefüllt</li>
						<li>Der User klickt den Button „hinzufügen“ für einen neuen Eintrag oder die Enter-Taste bei einer Datenänderung</li>
						</ol>
				<div>
					<b>erwartetes Ergebnis:</b>
					<ol>
						<li> Der neu erstellt Eintrag zum Pfleger/Pflegerin wird nicht in der Liste darüber eingetragen/aufgelistet.</li>
						<li> In der Datenbank wird kein neuer Eintrag in der Pfleger/Pflegerin-Tabelle mit allen eingetragenen Daten erstellt. </li>
						<li> Dem User wird eine Fehlermeldung gezeigt und darauf hingewiesen, wo sich der Fehler in den Daten befindet.</li>
					</ol>
				</div>
			</td>
	</tr>

</table>

### Aufgabe 2

<table>
<td>Die Anzeige einer einzelnen Behandlung soll um die Daten des Pflegers/in (der Name im Format Nachname, Vorname sowie Telefon in einem eigenem Label) ergänzt werden, der/die die Behandlung durchgeführt hat.</td>
	<tr>
		<th>User Story</th>
	</tr>
	<tr>
			<td>Als Pfleger möchte ich immer einen Überblick haben, welcher Kollege welche Behandlung bei welchem Patienten durchgeführt hat, um bei Rückfragen zu wissen, an wen ich mich wenden muss und zusätzlich um einen Überblick über meine eigenen Behandlungen zu haben.</td>
	</tr>
	<tr>
		<th>Akzeptanzkriterien</th>
	</tr>
	<tr>
			<td>
				<p>A_1: In der Übersicht der Behandlungen werden vier neue Spalten in die Tabelle eingefügt : ID, Nachname, Vorname und Telefon des Pflegers/ der Pflegerin.</p>
				<p>A_3: Diese Daten müssen bei jedem neuen Eintrag mit ausgefüllt werden, sonst erscheint eine Fehlermeldung.</p>
				<p>A_4: Die zusätzlich gefüllten Felder werden in der Datenbank in der Behandlungs-Tabelle bei jeder Änderung gespeichert.</p>
				<p>A_5: Die Detail-Anzeige der Behandlungen wird um die Informationen der Pfleger/Pflegerin erweitert.</p>
				<p>A_6: Die Informationen des angegebenen Pflegers können geändert werden.</p>
			</td>
	</tr>
	<tr>
		<th>Task</th>
	</tr>
	<tr>
			<td>
				<p>T_1:  Die Datenbanktabelle „Behandlungen“ um den Primärschlüssel der Pfleger Tabelle, als Fremdschlüssel erweitern.</p>
				<p>T_2: Erweitere TreatmentDAO um den Foreign Key: Caregiver_ID.</p>
				<p>T_3: TreatmentDAO muss die Informationen der Pflegekraft über den Foreign Key ermitteln.</p>
				<p>T_4: Der Treatment Controller muss um die neuen Felder erweitert werden.</p>
				<p>T_5: Die Modelklasse Treatment muss um die Caregiver_ID erweitert werden.</p>
				<p>T_6: Der NewTreatment Controller muss um die Caregiver_ID erweitert werden. (Es muss eine Eingabe möglich sein)</p>
				<p>T_7: Überprüfung auf Gültigkeit der eingegebenen Daten des Pflegers.</p>
			</td>
		</tr>
	<tr>
		<th>Testfall</th>
	</tr>
	<tr>
			<td> 
				<p><b>TF_1: Neue Behandlung anlegen</b></p>
				<p><b>Vorbedingung: </b>Im Hauptmenü "Behandlungen" auswählen</p>
				<div>
					<p><b>auszuführende Testschritte: </b></p>
					<ol>
						<li> Der User sucht über das Drop-Down Menü einen Patienten für die Behandlung aus und klickt dann auf „neue Behandlung anlegen“ </li>
						<li> In dem neuen Fenster werden alle zusätzlichen Informationen ausgefüllt, darunter auch die Pfleger Informationen </li>
						<li> Der User klickt „Hinzufügen“</li>
					</ol>
				</div>
				<div>
					<b>erwartetes Ergebnis:</b>
					<ol>
						<li> Bei vollständigen Daten wird ein neuer Eintrag in der Pflegekraft Tabelle erstellt und die Daten werden in der Liste angezeigt.</li>
						<li> Sollten die Informationen zu den Pflegern fehlen, wird eine entsprechende Fehlermeldung ausgegeben.</li>
					</ol>
				</div>
			</td>
		</tr>
</table>

### Aufgabe 3

<table>
<td>Beim Anlegen einer neuen Behandlung soll die entsprechende Pflegekraft mit Hilfe einer Combobox ausgewählt werden können.</td>
	<tr>
		<th>User Story</th>
	</tr>
	<tr>
			<td>Als Pflegekraft möchte ich für eine neue Behandlung eines Patienten, die Pflegekraft aus einem Dropdown-Menü auswählen können.</td>
	</tr>
	<tr>
		<th>Akzeptanzkriterien</th>
	</tr>
	<tr>
		<td>
			<p>A_1: Combo Box mit allen aktiven Pflegekräften</p>
			<p>A_2: Combo Box mit allen aktiven Patienten</p>
			<p>A_3: In der Combo Box werden nicht die Keys angezeigt sondern die Kombination aus ID, Name und Vorname.</p>
			<p>A_4: Eine Verknüpfungstabelle für Behandlungen, Pflegekräften und Patienten</p>
			<p>A_5: Primary Key dieser Tabelle ist die Kombination aller Attribute</p>
			<p>A_6: In der Verknüpfungstabelle werden nur die Primary Keys der anderen Tabellen als Foreign Key gespeichert</p>
			<p>A_7: Alle Felder sind nicht Nullable und müssen einen Wert != ' ' enthalten</p>
			<p>A_8: Die Behandlung wird mit der Pflegekraft verknüpft</p>
			</td>
	</tr>
	<tr>
		<th>Task</th>
	</tr>
	<tr>
			<td>
				<p>T_1: Erstellung der Verknüpfungstabelle für Behandlung, Pflegekraft, Patient</p>
				<p>T_2: Setzen der Primary Keys und Foreign Keys in den betroffenen Tabellen</p>
				<p>T_3: Weitere Feldattribute einfügen wie Datentyp, Not Null, etc.</p>
			</td>
		</tr>
	<tr>
		<th>Testfall</th>
	</tr>
	<tr>
			<td>
				<p><b>TF_1: Anzeigen der Patienten im Dropdown</b>
				<p><b>Vorbedingung:</b> Der Nutzer ist auf der Patienten Liste.</p>
				<div>
					<p><b>auszuführende Testschritte:</b></p>
					<ol>
						<li>Dropdown für Patienten anklicken</li>
						<li>Dropdown für Pflegekräfte anklicken</li>
					</ol>
				</div>
				<div>
					<b>erwartetes Ergebnis:</b>
					<ol>
						<li>Es werden alle aktiven Patienten im Dropdown angezeigt</li>
						<li>Es werden alle aktiven Pflegekräfte im Dropdown angezeigt</li>
					</ol>
				</div>
				<p><b>TF_2: Verknüpfungstabelle wird gepflegt</b></p><p><b>Vorbedingung:</b> Der Nutzer ist auf der Seite auf der die Patienten gelistet sind.</p>
				<div>
					<p><b>auszuführende Testschritte:</b></p>
					<ol>
						<li>Dropdown für Patienten öffnen und auswählen</li>
						<li>Dropdown für Pflegekräfte öffnen und auswählen</li>
					</ol>
				</div>
				<div>
					<b>erwartetes Ergebnis:</b>
					<ol>
						<li>Wenn ein Patient aus dem Dropdown ausgewählt wird, werden die dazugehörigen Informationen über den Patienten automatisch eingetragen.</li>
						<li>Wenn eine Pflegekraft ausgewählt wird, werden die dazugehörigen Daten automatisch eingetragen.</li>
						<li>Die Verknüpfungstabelle wird mit den Primary Keys der Tabellen für Patienten und Pflegekräfte gepflegt.</li>
					</ol>
				</div>
			</td>
	</tr>

</table>

### Aufgabe 4

<table>
	<td>Beim Löschen einer Pflegekraft muss ebenfalls die 10 Jahresregelung berücksichtigt werden, d.h. nicht mehr aktive Pfleger werden auf Wunsch gesperrt, sofern sie noch Behandlungen durchgeführt haben, die jünger als 10 Jahre sind. Sind nur noch Behandlungen, die 10 Jahre zurückliegen, wird die Pflegekraft gelöscht. Die durchgeführten Behandlungen sollen weiter angezeigt werden.</td>
	<tr>
		<th>User Story 1</th>
	<tr>
	<tr>
		<td>Als Verwaltungsmitarbeiter:in möchte ich Pfleger auf Wunsch als inaktiv kennzeichnen können. Da Pflegekräfte, die gelöscht werden sollen und Behandlungen durchgeführt haben, die jünger als 10 Jahre sind zwar nicht mehr behandeln, aber die Informationen dokumentiert sein müssen.</td>
	</tr>
	<tr>
		<th>Akzeptanzkriterien</th>
	</tr>
	<tr>
			<td>
				<p>A_1: Inaktive Pflegekräfte werden nirgends gelistet außer in der dafür vorgesehenen Liste</p>
				<p>A_2: Inaktive Pflegekräfte können nicht als pflegende Kraft eingetragen werden</p>
				<p>A_3: Daten über inaktive Pflegekräfte können nicht editiert werden</p>
				</td>
		</tr>
	<tr>
		<th>Task</th>
	</tr>
	<tr>
			<td>
				<p>T_1: Felderweiterung der Pflegekräfte Tabelle zum Inaktivieren einer Pflegekraft</p>
				<p>T_2: Erstellen eines Filters für die Pflegekräfte nach aktiv und inaktiv</p>
				<p>T_3: Im inaktiv Filter können Daten nicht editiert werden</p>
				<p>T_4: Überall wo aktive Pflegekräfte eingetragen werden können, muss ein Filter gesetzt werden.</p>
				<p></p>
			</td>
		</tr>
	<tr>
		<th>Testfall</th>
	</tr>
	<tr>
			<td>
				<p><b>TF_1: Änderung von aktiv auf inaktiv</b></p>
				<p><b>Vorbedingung:</b> der Nutzer muss auf der Seite der Pflegekraftliste sein.</p>
				<div>
					<p><b>auszuführende Testschritte:</b></p>
					<ol>
						<li>Ändern von Aktiv in Inaktiv</li>
						<li>Ändern von Inaktiv in Aktiv</li>
					</ol>
				</div>
				<div>
					<b>erwartetes Ergebnis:</b>
					<ol>
						<li>Aktiv -> Inaktiv = Alle dazugehörigen Informationen können nicht mehr angepasst werden.</li>
						<li>Inaktiv -> Aktiv = Alle dazugehörigen Informationen können angepasst werden.</li>
					</ol>
				</div>
				</td>
		</tr>
	<tr>
		<th>User Story 2</th>
	</tr>
	<tr>
			<td>Als Verwaltungsmitarbeiter:in wünsche ich mir, dass inaktive Pfleger, die Behandlungen durchgeführt haben, die älter als 10 Jahre sind automatisch gelöscht werden.</td>
	</tr>
	<tr>
		<th>Akzeptanzkriterien</th>
	</tr>
	<tr>
			<td>
				<p>A_1: Eine Aufgabenwarteschlange prüft regelmäßig, ob es Behandlungen gibt die älter als 10 Jahre sind und prüft ob der dazugehörige Pfleger inaktiv ist.</p>
				<p>A_2: Aufgabenwarteschlange löscht alle dazugehörigen Informationen.</p>
				<p>A_3: Berechtigte können manuell eine Prüfung starten, welche alle Behandlungen überprüft und die ausgewählten Daten bei Bestätigung löscht</p>
			</td>
		</tr>
	<tr>
		<th>Task</th>
	</tr>
	<tr>
			<td>
				<p><b>Kommentar:</b> Es wird davon ausgegangen, dass bereits ein System für eine Aufgabenwarteschlange existiert!</p>
				<p>T_1: Aufgabenwarteschlange erweitern, damit die Prüfung und Löschung durchgeführt werden kann.</p> 
				<p>T_2: Ein Knopf auf der Liste der Behandlungen soll einen Prüflauf starten.</p>
				<p>T_3: Bei einem manuellen Prüflauf muss eine Bestätigung erfolgen, damit die Daten tatsächlich gelöscht werden. Bei Abbruch bleiben alle Daten bestehen.</p>
			</td>
		</tr>
	<tr>
		<th>Testfall</th>
	</tr>
	<tr>
			<td>
				<p><b>TF_1: Ausführen der Aufgabenwarteschlange</b></p>
				<p><b>Vorbedingung:</b> Starten der Aufgabenwarteschlange</p>
				<div>
					<p><b>auszuführende Testschritte: </b>-</p>
				</div>
				<div>
					<b>erwartetes Ergebnis:</b>
					<ol>
						<li>Die Aufgabenwarteschlange überprüft die Behandlungen</li>
						<li>Wenn Behandlungen gefunden werden, die in die Kriterien passen, werden diese gelöscht</li>
					</ol>
				</div>
				<p><b>TF_2: Manuelle Überprüfung</b></p>
				<p><b>Vorbedingung:</b> Der Nutzer ist auf der Seite wo die Behandlungen gelistet sind.</p>
				<div>
					<p><b>auszuführende Testschritte:</b></p>
					<ol>
						<li>Knopf zur manuellen Überprüfung drücken</li>
					</ol>
				</div>
				<div>
					<b>erwartetes Ergebnis:</b>
					<ol>
						<li>Wenn Behandlungen gefunden werden, die in die Kriterien passen, dann wird eine Meldung angezeigt mit der Auswahl zwischen "Löschen" und "Abbrechen".</li>
						<li>Beim Löschen sollen alle Behandlungen gelöscht werden.</li>
						<li>Beim Abbruch passiert nichts.</li>
					</ol>
				</div>
			</td>
	</tr>
	<tr>
		<th>User Story 3</th>
	</tr>
	<tr>
		<td>Als Datenschutzbeauftragte:r, muss ich mitteilen, dass die Informationen über die Behandlungen intakt bleiben müssen, auch wenn die Informationen zu den Pflegekräften gelöscht wurden.</td>
	</tr>
	<tr>
		<th>Akzeptanzkriterien</th>
	</tr>
	<tr>
			<td>
				<p>A_1: Nur die Pflegekräfte werden aus den Behandlungen und ähnlichen Daten gelöscht.</p>
				<p>A_2: Behandlungen bleiben intakt</p>
				<p>A_3: Behandlungen bleiben unsichtbar</p>
			</td>
		</tr>
	<tr>
		<th>Task</th>
	</tr>
	<tr>
			<td>
				<p>T_1: Funktionen zum Löschen aus User Story 2 muss angepasst werden. Die Behandlung selbst darf nicht gelöscht werden.</p> 
			</td>
		</tr>
	<tr>
		<th>Testfall</th>
	</tr>
	<tr>
		<td>
			<p><b>TF: </b> Ist identisch zu den Testfällen aus User Story 2</p>
			</td>
	</tr>
	<tr>
		<th>User Story 4</th>
	</tr>
	<tr>
			<td>Als Datenschutzbeauftragte:r brauche ich eine Übersicht über die alten Behandlungen und ihre Veränderungen, die nicht mehr in der normalen Behandlungsübersicht angezeigt werden.</td>
	</tr>
	<tr>
		<th>Akzeptanzkriterien</th>
	</tr>
	<tr>
			<td>
				<p>A_1: Behandlungen werden nicht gelöscht sondern in eine separate Log-Tabelle verschoben.</p>
				<p>A_2: Bei Änderungen wird der alte und neue Zustand des Datensatzes in die Log-Tabelle geschrieben.</p>
				<p>A_3: Die Log-Tabelle kann grundsätzlich nicht von Nutzern editiert werden.</p>
				<p>A_4: Diese Log-Tabelle ist speziell für "gelöschte" Behandlungen und ihre Änderungen.</p>
				<p>A_5: Auf der Übersicht für Behandlungen kann nach laufenden und "gelöschten" Behandlungen gefiltert werden.</p>
				<p>A_6: Es gibt eine extra Liste für die Log-Tabelle.</p>
			</td>
		</tr>
	<tr>
		<th>Task</th>
	</tr>
	<tr>
			<td>
				<p>T_1: Anpassen der Aufgabenwarteschlange aus User Story 2</p>
				<p>T_2: Daten zur Behandlung werden in die Log-Tabelle verschoben.</p>
				<p>T_3: Es gibt einen Filter, der die "gelöschten" Behandlungen anzeigt, indem auf die Log-Tabelle zugegriffen wird.</p>
				<p>T_4: Filter für "gelöschte" Behandlungen ist nur für bestimmte Personalgruppen verfügbar. Sowie die Liste für die Log-Tabelle</p>
			</td>
		</tr>
	<tr>
		<th>Testfall</th>
	</tr>
	<tr>
			<td>
				<p><b>TF_1: Löschen einer Behandlung und Pfleger</b></p>
				<p><b>Vorbedingung:</b> Der Nutzer muss in der Übersicht für Behandlungen oder Pflegekräften sein. Und es muss Behandlungen und inaktive Pflegekräfte entsprechend der Kriterien geben. Außerdem muss die Aufgabenwarteschlange aktiv sein.</p>
				<div>
					<p><b>auszuführende Testschritte:</b></p>
					<ol>
						<li>Aufgabenwarteschlange durchlaufen lassen</li>
						<li>Knopf für manuelle Prüfung drücken</li>
						<li>Löschen der Daten bestätigen</li>
						<li>Löschen der Daten abbrechen</li>
						<li>Log-Filter auf der Übersicht der Behandlungen überprüfen.</li>
					</ol>
				</div>
				<div>
					<b>erwartetes Ergebnis:</b>
					<ol>
						<li>Die Aufgabenwarteschlange löscht die Pflegekraft und versetzt die Behandlung in die Log-Tabelle.</li>
						<li>Beim manuellen Löschen werden die Pflegekräfte gelöscht und die Behandlungen in die Log-Tabelle verschoben.</li>
						<li>Beim Abbrechen passiert nichts.</li>
					</ol>
				</div>
				<p><b>TF_2: Ändern einer Behandlung und Pfleger</b></p>
				<p><b>Vorbedingung:</b> Der Nutzer muss in der Übersicht für Behandlungen oder Pflegekräften sein.</p>
				<div>
					<p><b>auszuführende Testschritte:</b></p>
					<ol>
						<li>Ändern aller Werte eines Datensatzes</li>
					</ol>
				</div>
				<div>
					<b>erwartetes Ergebnis:</b>
					<ol>
						<li>Der Datensatz wird geändert und ein neuer Datensatz wird in der Log-Tabelle angelegt.</li>
					</ol>
				</div>
			</td>
		</tr>
	<tr>

</table>

### Vermögensstand entfernen

<table>
	<td>Der Vermögensstand ist für die Behandlung eines Patienten nicht von Relevanz. Deshalb soll er aus der Applikation vollständig entfernt werden.</td>
	<tr>
		<th>User Story</th>
	</tr>
	<tr>
			<td>Als Datenschutzbeauftragter muss ich darauf aufmerksam machen, dass der Vermögensstand unserer Patienten nicht relevant für ihre Behandlung ist. Aus diesem Grund muss diese Information aus NHPlus entfernt werden.</td>
	</tr>
	<tr>
		<th>Akzeptanzkriterien</th>
	</tr>
	<tr>
			<td>
				<p>A_1: Der Vermögensstand wird nirgends gespeichert</p>
				<p>A_2: Der Vermögensstand wird nirgends angezeigt</p>
				<p>A_3: Der Vermögensstand wird nirgends berechnet</p>
			</td>
	</tr>
	<tr>
		<th>Task</th>
	</tr>
	<tr>
			<td>
				<p>T_1: Entfernen des "Vermögensstand" Attributs in der Patienten-Tabelle.</p>
				<p>T_2: Entfernen des "Vermögensstand" Felds in der Anzeige von Patienten.</p>
				<p>T_3: Attribut aus dem Patient Objekt entfernen.</p>
				<p>T_4: Der Vermögensstand wird nicht durch das PatientDAO Objekt ausgelesen.</p>
			</td>
		</tr>
	<tr>
		<th>Testfall</th>
	</tr>
	<tr>
			<td>
				<p><b>TF_1: Alle Pfleger und Pflegerinnen anzeigen </b></p>
				<p><b>Vorbedingung: </b>Der Nutzer muss auf der Startseite von NHPlus sein.</p>
				<div>
					<p><b>auszuführende Testschritte: </b></p>
					<ol>
						<li>Öffnen der Patientenübersicht</li>
						<li>Es wird kein Vermögensstand angezeigt</li>
					</ol>
				</div>
				<div>
					<p><b>erwartetes Ergebnis:</b></p>
					<ol>
						<li>Der Vermögensstand wird nicht angezeigt</li>
						<li>Der Vermögensstand wird nicht gespeichert</li>
					</ol>
				</div>
			</td>
	</tr>
</table>

### Login

<table>
	<td>Damit nicht alle Personen auf NHPlus zugreifen können und es Berechtigungsstufen geben kann brauchen wir ein Login System.</td>
	<tr>
		<th>User Story 1</th>
	</tr>
	<tr>
			<td>Als Pfleger/Pflegerin  möchte ich, dass alle Daten nur von den dafür berechtigten Personen eingesehen werden können, um die Daten der Patienten zu schützen.</td>
	</tr>
	<tr>
		<th>Akzeptanzkriterien</th>
	</tr>
	<tr>
			<td>
				<p>A_1: Es wird ein neues Fenster erstellt, welches sich vor allen anderen öffnet.</p>
				<p>A_2: In diesem Fenster werden zwei Eingabefelder erstellt, in denen ein Benutzername und ein Passwort abgefragt werden.</p>
				<p>A_3: Es gibt einen Button zum Einloggen</p>
				<p>A_4: Bei inkorrekten Daten erscheint eine Fehlermeldung</p>
				<p>A_5: Es gibt eine neue Tabelle in der Datenbank für die Berechtigungsstufen erstellt, mit einer ID und einem Text, der die jeweilige Berechtigungsstufe näher beschreibt.</p>
				<p>A_6: Es gibt eine neue Tabelle in der Datenbank in der sowohl ID, Benutzername, Passwort als auch eine Berechtigungsstufe(Zahl).</p>
				<p>A_7: Erweiterung der Caregiver-Tabelle um den Fremdschlüssel der Logging-Tabelle</p>
				<p>A_8: Bei Anlage eines neuen Benutzers wird automatisch auch ein neuer Eintrag in der LogIn Tabelle gemacht, mit einem Benutzernamen (frei wählbar) und einem vorübergehenden Passwort.</p>
				<p>A_9: Passwortkriterien: min. 8 Zeichen, davon min. 1 Großbuchstabe, min. 1 Kleinbuchstabe, min. 1 Sonderzeichen, min. 1 Zahl</p>
			</td>
	</tr>
	<tr>
		<th>Task</th>
	</tr>
	<tr>
			<td>
				<p>T_1: Erstellung eines neuen LogInWindowControllers.</p>
				<p>T_2: Erstellung einer neuen LogInWindowView.fxml, mit zwei Eingabefeldern und einem Button.</p>
				<p>T_3: Erstellung einer neuen LogInDAO und AuthorizationDAO</p>
				<p>T_4: Erstellung der Modelklasse LogIn</p>
				<p>T_5: Erweiterung der Caregiver-Tabelle um den Fremdschlüssel der LogIn-Tabelle</p>
				<p>T_6: Erweiterung des CaregiverWindows um zwei neue Pflichtfelder: Benutzername und Passwort, welche bei Füllung in der LogIn-Tabelle gespeichert werden</p>
				<p>T_7: Überprüfung der eingegebenen Daten auf Gültigkeit durch Abgleich mit den Daten in der Datenbanktabelle LogIn</p>
				<p>T_8: Bei ungültigen Daten wird eine Fehlermeldung ausgegeben</p>
			</td>
		</tr>
	<tr>
		<th>Testfall</th>
	</tr>
	<tr>
			<td>
				<p><b>TF_1: Erfolgreich einloggen</b></p>
				<p><b>Vorbedingung: </b>-</p>
				<div>
					<p><b>auszuführende Testschritte: </b></p>
					<ol>
						<li>Der User gibt Benutzernamen und Passwort ein, welche auch in der Datenbanktabelle Login vorhanden sind.</li>
						<li>Der User drückt den Einloggen-Button</li>
					</ol>
				</div>
				<div>
					<p><b>erwartetes Ergebnis:</b></p>
					<ol>
						<li>Das Hauptmenü-Fenster öffnet sich</li>
					</ol>
				</div>
				<p><b>TF_2: Nicht erfolgreich einloggen</b></p>
				<p><b>Vorbedingung: </b>-</p>
				<div>
					<p><b>auszuführende Testschritte: </b></p>
					<ol>
						<li>Der User gibt Benutzernamen und Passwort ein, welches nicht in der Datenbanktabelle Login vorhanden sind.</li>
						<li>Der User drückt den Einloggen-Button</li>
					</ol>
				</div>
				<div>
					<p><b>erwartetes Ergebnis:</b></p>
					<ol>
						<li>Das Hauptmenü-Fenster öffnet sich nicht</li>
						<li>Es erscheint eine Fehlermeldung</li>
					</ol>
				</div>
				<p><b>TF_3: Anlage eines neuen Pflegers</b></p>
				<p><b>Vorbedingung: </b>Der User hat im Hauptmenü Pfleger/Pflegerinnen ausgewählt.</p>
				<div>
					<p><b>auszuführende Testschritte: </b></p>
					<ol>
						<li>Der User gibt alle relevanten Daten inklusive Benutzernamen und Passwort ein</li>
						<li>Der User drückt den Hinzufügen-Button</li>
						<li>Der neu angelegte User gibt im Log-In Fenster Benutzername und Passwort ein</li>
						<li>Der User klickt auf Einloggen</li>
					</ol>
				</div>
				<div>
					<p><b>erwartetes Ergebnis:</b></p>
					<ol>
						<li>Das Hauptmenü-Fenster öffnet sich</li>
					</ol>
				</div>
			</td>
	</tr>
	<tr>
		<th>User Story 2</th>
	</tr>
	<tr>
			<td>Als Personalabteilung Mitarbeiter möchte ich für das Personal verschiedene Stufen von Berechtigungen verteilen können, damit nicht jede Person auf alle Daten Zugriff hat.</td>
	</tr>
	<tr>
		<th>Akzeptanzkriterien</th>
	</tr>
	<tr>
			<td>
				<p>A_1: Den Pflegern können verschiedene Berechtigungsstufen zugeteilt werden.</p>
				<p>A_2: Es wird eine neue Tabelle in der Datenbank für die Berechtigungsstufen erstellt, mit einer ID und einem Text, der die jeweilige Berechtigungsstufe näher beschreibt.</p>
				<p>A_3: Die Berechtigungen werden mit Texten in einer Tabelle dargestellt</p>
				<p>A_4: Nur Nutzer mit der entsprechenden Berechtigungsstufe dürfen auf die Daten zugreifen</p>
				<p>A_5: Die vergebene Berechtigungsstufe soll von bestimmten Personengruppen angepasst werden können (die dafür die erforderliche Berechtigungsstufe haben)</p>
				<p>A_6: Beim Einloggen wird geprüft welche Berechtigungen ein User hat und daraufhin bestimmte Fenster (z.B die Berechtigungstabelle) nicht angezeigt.</p>
				<p>A_7: Anlage, Ändern, Löschen von Berechtigungsstufen bei passender Berechtigung</p>
				<p>A_8: Ändern von Berechtigungsstufen bei bereits vorhanden Pflegern, bei passender Berechtigungsstufe</p>
			</td>
	</tr>
	<tr>
		<th>Task</th>
	</tr>
	<tr>
			<td>
				<p>T_1: Erstellung der Modelklasse Authorization</p>
				<p>T_2: Erstellung der AuthorizationDAO</p>
				<p>T_3: Erstellung eines neuen AuthorizationWIndowController </p>
				<p>T_4: Erstellung der AuthorizationView.fxml mit einer Tabelle zur Übersicht aller Berechtigungen, einem Hinzufügen und Löschen Button, sowie einem Eingabefeld für den Berechtigungstext</p>
				<p>T_5: Erstellung einer neuen Datenbank Tabelle: Authorization</p>
				<p>T_6: Speichern der Daten in der Datenbank</p>
				<p>T_7: Vollständiges Anzeigen der Daten aus der Datenbank</p>
				<p>T_8: Die Login-Tabelle wird um den Fremdschlüssel der Berechtigungstabelle erweitert.</p>
				<p>T_9: Erweiterung des MainWIndowControllers um die AuthorizationView.fxml</p>
				<p>T_10: Erweiterung des Anlage-Pflegenden-Windows um die Eingabe der  Berechtigungsstufe</p>
				<p>T_11: Prüfung des Berechtigungsstandes vor Anzeige des MainWindows</p>
				<p>T_12: Anzeigeunterdrückung von Buttons im Mainwindow bei fehlender Berechtigung</p>
				<p>T_13: Automatische Hochzählen der ID bei Erstellung eines neuen Eintrags</p>
			</td>
		</tr>
	<tr>
		<th>Testfall</th>
	</tr>
	<tr>
			<td>
				<p><b>TF_1: Neue Berechtigungsstufe erstellen</b></p>
				<p><b>Vorbedingung: </b>Der User muss mit Admin-Rechten eingeloggt sein</p>
				<div>
					<p><b>auszuführende Testschritte: </b></p>
					<ol>
						<li>Der User Klickt auf den Button “Berechtigungen”</li>
						<li>Es wird das Berechtigungs Textfeld gefüllt</li>
						<li>Der User drückt hinzufügen</li>
					</ol>
				</div>
				<div>
					<p><b>erwartetes Ergebnis:</b></p>
					<ol>
						<li>Der Eintrag wird in der Datenbank gespeichert und in der obigen Tabelle angezeigt.</li>
					</ol>
				</div>
				<p><b>TF_2: Berechtigungsstufe löschen</b></p>
				<p><b>Vorbedingung: </b>Der User muss mit Admin-Rechten eingeloggt sein</p>
				<div>
					<p><b>auszuführende Testschritte: </b></p>
					<ol>
						<li>Der User Klickt auf den Button “Berechtigungen”</li>
						<li>Es wird eine Berechtigung ausgewählt und auf Löschen gedrückt</li>
					</ol>
				</div>
				<div>
					<p><b>erwartetes Ergebnis:</b></p>
					<ol>
						<li>Der Eintrag wird aus Datenbank gelöscht und in der obigen Tabelle nicht mehr angezeigt.</li>
					</ol>
				</div>
				<p><b>TF_3: Berechtigungsstufe bearbeiten</b></p>
				<p><b>Vorbedingung: </b>Der User muss mit Admin-Rechten eingeloggt sein</p>
				<div>
					<p><b>auszuführende Testschritte: </b></p>
					<ol>
						<li>Der User Klickt auf den Button “Berechtigungen”</li>
						<li>Es wird eine Doppelklick auf die Berechtigung gemacht</li>
						<li>Eine neuer Text wird eingegeben</li>
						<li>Der User bestätigt die Eingabe</li>
					</ol>
				</div>
				<div>
					<p><b>erwartetes Ergebnis:</b></p>
					<ol>
						<li>Der Eintrag wird aus Datenbank geändert und in der obigen Tabelle aktualisiert.</li>
					</ol>
				</div>
				<p><b>TF_4: Ändern einer Berechtigungsstufe eines Pflegers</b></p>
				<p><b>Vorbedingung: </b>Der User muss mit Admin-Rechten eingeloggt sein</p>
				<div>
					<p><b>auszuführende Testschritte: </b></p>
					<ol>
						<li>Der User Klickt auf den Button “Pfleger/innen”</li>
						<li>Der User macht einen Doppelklick auf den zu ändernden Datensatz und das Feld Berechtigungsstufe</li>
						<li>Der User gibt eine neue Stufe ein und drückt die Enter-Taste</li>
					</ol>
				</div>
				<div>
					<p><b>erwartetes Ergebnis:</b></p>
					<ol>
						<li>Der Eintrag wird in der Datenbank gespeichert und in der obigen Tabelle verändert angezeigt.</li>
						<li>Der geänderte Pfleger hat nun neue Berechtigungen entsprechend seiner neuen Stufe.</li>
					</ol>
				</div>
			</td>
	</tr>
	<tr>
		<th>User Story 3</th>
	</tr>
	<tr>
			<td>Als Personalabteilung Mitarbeiter möchte, dass sich neu angelegte User beim ersten einloggen ein neues, eigenes Passwort auswählen müssen, um das temporäre Passwort nicht mehr zu verwenden.</td>
	</tr>
	<tr>
		<th>Akzeptanzkriterien</th>
	</tr>
	<tr>
			<td>
				<p>A_1: Ein neuer Pfleger bekommt nach dem ersten Einloggen eine extra Fenster mit zwei Eingabefeldern : neues Passwort und Passwort bestätigen</p>
				<p>A_2: Es wird ein neues Feld in der LogIn-Tabelle hinzugefügt, welches angibt, ob es der erste Login ist.</p>
				<p>A_3: Die Eingabe in beiden Feldern muss gleich sein, sonst kommt eine Fehlermeldung</p>
			</td>
	</tr>
	<tr>
		<th>Task</th>
	</tr>
	<tr>
			<td>
				<p>T_1: Es wird ein neuer Controller ChangePasswordController erstellt</p>
				<p>T_2: Es wird eine neue ChangePasswordView.fxml mit zwei Eingabefeldern erstellt und eine bestätigen Button</p>
				<p>T_3: Erweiterung der LogIn-Tabelle um ein boolean Feld : FirstLogIn</p>
				<p>T_4: Überprüfe ob die Eingabe in beiden Felder gleich ist, sonst erscheint eine Fehlermeldung</p>
				<p>T_5: Nach dem ersten Log-In FirstLogIn auf false setzen</p>
			</td>
		</tr>
	<tr>
		<th>Testfall</th>
	</tr>
	<tr>
			<td>
				<p><b>TF_1: Ein neuer User meldet sich zum ersten Mal an mit gültigen Passwort</b></p>
				<p><b>Vorbedingung: </b>Der User loggt sich mit vorgegebenen Benutzername und Passwort ein und das neue Fenster erscheint</p>
				<div>
					<p><b>auszuführende Testschritte: </b></p>
					<ol>
						<li>Der User gibt ein neues gültiges Passwort zweimal ein</li>
						<li>Der User Klickt auf den Button “Bestätigen”</li>
					</ol>
				</div>
				<div>
					<p><b>erwartetes Ergebnis:</b></p>
					<ol>
						<li>Der Eintrag wird in der Datenbank gespeichert</li>
						<li>FirstLogIn ist auf false gesetzt</li>
						<li>Der User gelangt ins Hauptmenü</li>
					</ol>
				</div>
				<p><b>TF_2: Ein neuer User meldet sich zum ersten Mal an mit ungültigen Passwort</b></p>
				<p><b>Vorbedingung: </b>Der User loggt sich mit vorgegebenen Benutzername und Passwort ein und das neue Fenster erscheint</p>
				<div>
					<p><b>auszuführende Testschritte: </b></p>
					<ol>
						<li>Der User gibt ein neues ungültiges Passwort zweimal ein</li>
						<li>Der User Klickt auf den Button “Bestätigen”</li>
					</ol>
				</div>
				<div>
					<p><b>erwartetes Ergebnis:</b></p>
					<ol>
						<li>Der Eintrag wird nicht in der Datenbank gespeichert</li>
						<li>Der User gelangt nicht ins Hauptmenü</li>
						<li>Es erscheint eine Fehlermeldung</li>
					</ol>
				</div>
			</td>
	</tr>

</table>
