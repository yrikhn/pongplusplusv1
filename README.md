# PongPlusPlus

PongPlusPlus (Pong++) handelt sich um ein Player VS PC Pong spiel mit Fähigkeiten. Das Ziel des Spiels ist, den Ball out-of-Bounds zu setzen, indem man den Ball vom eigenen Balken weg prallen lässt, sodass der gegnerischen Balken den Ball nicht stoppen kann. Das Spielfenster wird durch einen Balken getrennt. Den eigenen Punktstand sieht man immer im eigen Spielfeld-hälfte. Ausser den gewöhnlichen Regeln gibt es noch Fähigkeiten. Man kann mit der Fähigkeit die Ball Geschwindigkeit im gegnerischen Spielfeld beschleunigen und im eigenen verlangsamen für 10 Sekunden. Ein Sieg gilt, wen ein Spieler 10 Punkte erreicht hat.


## GUI:

### Originales Mockup:
![PongPlusPlus Mockup](GUI%20Screenshots/pongplusplus_design.png?raw=true)


### Info:
![PongPlusPlus Info Scene](GUI%20Screenshots/InfoScene.png?raw=true)

### GamemodeSelection:
![PongPlusPlus GamemodeSelection Scene](GUI%20Screenshots/gamemodeselection.png?raw=true)

### DifficultySelection:
![PongPlusPlus DifficultySelectionnfo Scene](GUI%20Screenshots/difficulty_selection.png?raw=true)

### Ingame:
![PongPlusPlus Ingame Scene](GUI%20Screenshots/Ingame.png?raw=true)

### Gameover:
![PongPlusPlus Gameover Scene](GUI%20Screenshots/gameover.png?raw=true)

## Klassendiagramm:
![PongPlusPlus UML](GUI%20Screenshots/UML.png?raw=true)

###Gameobject: Alle auf dem Screen zusehende Objekt erbben von dieser Klasse. Enthalteten(X/Y) Variablen, abstrakte update Methoden etc.
Ball: Enthaltet die Logik vom Ball und erbt von Gameobject.
PlateObject: Eine Erweiterung der Klasse Gameobject, enthält spezielle Methoden.
BaseScene: Alle Szenen erben von dieser Klasse, enthält die Gemeinsamkeit aller Szenen.
GodLikeAnimationTimer: Enthält den Timer welchen wir im Spiel brauchen.
BallSppedManipulator: Enthält die Fähigkeit, die Ball Geschwindigkeit manipuliert.
PongPlusPlusApp: In dieser Klasse werden alle Szenen registriert.
Board: Zeichnet alle In-game Elemente und Enthält alle in-game Logik.
GameSetting: Enthält alle Game Einstellungen

# Fazit

Mit dem Endergebnis sind wir beide sehr zufrieden. Das was entstanden ist, entspricht unsere Vorstellung von unserem Produkt und ist sogar besser rausgekommen als wir uns vorstellten. Es gibt in diesem Projekt fast nichts Schlechtes zu erwähnen. Wir waren immer gut unterwegs und waren uns einig. Daher sparten wir viel Zeit beim Entscheidungen treffen. Beim Programmieren lief alles wunderbar.
Bei der Entwicklung des Ball Movement und KI-Movement brauchten wir externe Unterstützung. Wir haben Code vom Internet implementiert, welche wir verstanden haben. Grundsätzlich ist dies kein komplizierter Code, man muss jedoch ein bisschen nachdenken um darauf zu kommen. 
Durch dieses Projekt wurde uns Space-Invaders verständlicher, da wir diese zuvor unverständliche Logik angewandt haben. Der Umgang mit Git (GitLab) gehört auch zu den Sachen, die wir gelernt haben.
Wir haben schon in vorherigen Projekten zusammengearbeitet. Von Anfang an, waren wir uns einig was wir machen wollten und was unser Ziel war. Wir haben uns ständig ausgetauscht, teilweise auch im Teams Call miteinander programmiert und uns gegenseitig ausgeholfen, wenn wir nicht weiterwussten. Wenn wir mal eine Zeit nicht in einem Call waren, sind wir ständig in Kontakt über Teams gewesen und wir wussten immer woran der Andere arbeitet (anhand von Issues auf GitLab). 
Wir konnten nicht nur unsere «MUSS» Ziele umsetzen, sondern auch unsere «KANN» Ziele. Eins unserer zuerst Drei geplanten «Features/Abilities» haben wir dann nicht implementiert, da es dann ein bisschen zu viele gewesen wären.
Wir sind im Ganzen sehr zufrieden und haben nichts Spezifisches das wir nächstes Mal anders machen würden.


## Authors

Youri Kuhn, Oliver Achermann
