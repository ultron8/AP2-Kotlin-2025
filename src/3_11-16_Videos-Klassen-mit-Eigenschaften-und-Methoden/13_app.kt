// Kontrollierter Zugriff auf Eigenschaftsfelder

// inhalt_param wird zu einem Parameter ohne Eigenschaft
class Glas3 ( inhalt_param : Int, val maxInhalt : Int ) {

    // KONTROLLIERTER ZUGRIFF DER EIGENSCHAFT (PROPERTY)
    // festlegen das die Zeichenkette bspw. nur aus Uppercase besteht
    var getraenk : String = "Wasser"
        // Was soll der Wert sein der gesetzt werden soll?
            // das wird mit value definiert
        set(value) {
            // jetzt auf das eigentliche Datenfeld zurückzugreifen mit -> field
                // das eigentliche Datenfeld soll den vorgebenen Wert entsprechen
                    // idF soll der vorgebenene Wert immer in uppercase stehen
            field = value.uppercase()

        } // setter

        // hierbei auch das setzen des Datenfeldes kontrollieren
            // Zusatz: falls var private inhalt dann -> kann sie fun main nicht mehr gesetzt werden nur in der class
            // Vorteil: kontrollierter Zugriff auf die Eigenschaft, da sie nur eingeschränkt verändert werden kann
        var inhalt = inhalt_param
            set (value) {
                // 3 Fälle
                // wenn das Umschütten dazu führt das der value (eigentliche Datenfeld) < 0 wird dann
                    // soll der Wert grdtzl auf 0 gesetzt werden
                if (value < 0) field = 0
                // wenn das Umschütten dazu führt das der value > maxInhalt (bzw kein Platz mehr im Glas ist) dann
                    // soll der Wert auf maxInhalt gesetzt werden
                if (value > maxInhalt) field = maxInhalt
                // wenn das Umschütten dazu führt das der value zwischen 0 && maxInhalt liegt dann
                    // soll der Wert auf field = value gesetzt werden
                if (value >= 0 && value <= maxInhalt) field = value
            }



    fun liesVor() {
        println("Im Glas sind noch $inhalt ml $getraenk vorhanden")
        println("Maximal passen im Glas $maxInhalt ml")
    }

    fun verfuegbarerPlatz(): Int {
        return this.maxInhalt - this.inhalt
    }

    fun einschenken(wunschMenge: Int) {
        var umfuellMenge = wunschMenge

        if (umfuellMenge > verfuegbarerPlatz()) {
            umfuellMenge = verfuegbarerPlatz()
        }

        this.inhalt = this.inhalt + umfuellMenge

    }

} // class Glas


class Flasche3 ( var inhalt: Int ) {


    // fun umfuellen()
    fun umfuellen(glas: Glas2): Int {
        var umfuellMenge = glas.availableSpace()
        if (this.inhalt < umfuellMenge ) {
            umfuellMenge = this.inhalt
        }

        // umfuellen durchführen
        this.inhalt = this.inhalt - umfuellMenge
        // im Glas dann die umfuellMenge hinzufügen
        glas.inhalt = glas.inhalt + umfuellMenge

        return glas.inhalt
    }
} // class Flasche


fun main ( args : Array <String> ) {

        // Eigenschaft -> private vs public


        val bunteFlasche = Flasche3 ( 800 )
        val glas1 = Glas3 ( 40 , 150)
        val glas2 = Glas3 ( 90 , 200 )

        val glasTest = Glas3(10, 100)

        glasTest.getraenk = "Club Mate"

        val clubMate = glasTest
        println("Das Getränk ${clubMate.getraenk} hat noch ${clubMate.inhalt} ml")

        glas2.getraenk = "Cola"

        glas1.liesVor()
        glas2.liesVor()

        val komischesGlas = Glas3 (100, 200)
        komischesGlas.inhalt = 120
        println("Im komischen Glas sind ${komischesGlas.inhalt} ml. vorhanden.")
        komischesGlas.inhalt = 500
        println("Im komischen Glas sind ${komischesGlas.inhalt} ml. vorhanden.")
        komischesGlas.inhalt = -90
        println("Im komischen Glas sind ${komischesGlas.inhalt} ml. vorhanden.")

        // println("Im ersten Glas sind noch ${glas1.verfuegbarPlatz()}")

        //bunteFlasche.umfuellen(glas1)
        //bunteFlasche.umfuellen(glas2)

} // end of main function


fun calculateFillAmount4(mengeFlasche : Int, mengeGlas : Int, maxMengeGlas : Int): Int {

    val umfuellMenge = maxMengeGlas - mengeGlas
    if (mengeFlasche >= umfuellMenge) {
        return umfuellMenge
    } else {
        return mengeFlasche
    }

} // fun umfuellMenge