// Methoden als Nachrichten zwischen Objekten


class Glas2 ( var inhalt : Int, val maxInhalt : Int ) {
    var getraenk = "Wasser"

    fun liesVor() {
        println("Im Glas sind noch $inhalt ml $getraenk vorhanden")
        println("Maximal passen im Glas $maxInhalt ml")
    }

    fun availableSpace(): Int {
        return this.maxInhalt - this.inhalt
    }

    fun einschenken(wunschMenge: Int) {
        var umfuellMenge = wunschMenge

        if (umfuellMenge > availableSpace()) {
            umfuellMenge = availableSpace()
        }

        this.inhalt = this.inhalt + umfuellMenge

    }

} // class Glas

class Flasche2 ( var inhalt: Int ) {


    // fun umfuellen()
    fun refill(glas: Glas2) {
        var umfuellMenge = glas.availableSpace()
        if (this.inhalt < umfuellMenge ) {
            umfuellMenge = this.inhalt
        }

        // umfuellen durchführen
        this.inhalt = this.inhalt - umfuellMenge
        // im Glas dann die umfuellMenge hinzufügen
        glas.inhalt = glas.inhalt + umfuellMenge


    }
} // class Flasche


fun main(){
    val niceFlasche = Flasche2 ( 800 )
    val glas1 = Glas2 ( 40 , 150)
    val glas2 = Glas2 ( 90 , 200 )


    niceFlasche.refill(glas1)
    niceFlasche.refill(glas2)






} // fun main


fun calculateFillAmount3(mengeFlasche : Int , mengeGlas : Int , maxMengeGlas : Int): Int {

    val umfuellMenge = maxMengeGlas - mengeGlas
    if (mengeFlasche >= umfuellMenge) {
        return umfuellMenge
    } else {
        return mengeFlasche
    }
} // fun umfuellMenge


// Funktion umfuellen hat kein Rückgabewert daher -> : Unit


// umfuell Funktion also das refill wird nun als Methode in die class Flasche verlegt
    // Logik: da die Flüssigkeit die umgeschenkt werden soll erst von der Flasche ausgeht
    // werden wir diese Funktion in die class Flasche einsetzen
/*fun refill3(flasche: Flasche, glas: Glas) {

    val umfuellMenge = calculateFillAmount3(
        flasche.inhalt,
        glas.inhalt,
        glas.maxInhalt
    )

    // Parameter kann man nicht mehr umändern
    // Problem das wird die neuen (lokalen) Variablen nicht verwenden...
    glas.inhalt += umfuellMenge
    flasche.inhalt -= umfuellMenge
    // Lösung: erstellen von Klassen...

} // fun refill */