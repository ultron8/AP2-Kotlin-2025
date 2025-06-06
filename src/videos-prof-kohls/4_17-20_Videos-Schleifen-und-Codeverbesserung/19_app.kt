
// class Glas
class Glas9 ( inhalt_param : Int, val maxInhalt : Int = 200 ) {

    constructor (anteil: Double, maxi: Int = 200) : this((anteil * maxi).toInt(), maxi)


    // PROPERTIES
    var getraenk: String = "Wasser"
        set(value) {
            field = value.uppercase()

        }
        get() {
            println("Es wird der Inhalt vom Glas ausgelesen")
            return field
        }


    val voll: Boolean
        get() {
            return maxInhalt == inhalt
        }

    val vollText: String
        get() {
            if (voll) {
                return "Das jeweilige Glas ist voll und hat die maximale Kapazität von $maxInhalt ml ausgeschöpft"
            } else {
                return "Da ist noch etwas Platz im Glas"
            }
        }

    // VERÄNDERN
    // vorheriger Ausdruck
//    val leer: Boolean
//        get() {
//            return inhalt == 0
//        }

//    neuer Ausdruck
    val leer: Boolean
        get() = inhalt == 0

    // VERÄNDERN
    // vorheriger Ausdruck
//    val freierPlatz: Int
//        get() {
//            return this.maxInhalt - this.inhalt
//        }

    // neuer Ausdruck
    val freierPlatz: Int
        get() = this.maxInhalt - this.inhalt


    var inhalt = inhalt_param
        set(value) {

            if (value < 0) field = 0
            if (value > maxInhalt) field = maxInhalt
            if (value >= 0 && value <= maxInhalt) field = value
        }

    init {
        inhalt = inhalt_param
    }

    // METHODS
    fun liesVor() {
        println("Im Glas sind noch $inhalt ml $getraenk vorhanden")
        println("Maximal passen im Glas $maxInhalt ml")
    }

    // VERÄNDERN
    // vorheriger Ausdruck
//    fun verfuegbarerPlatz(): Int {
//        return this.maxInhalt - this.inhalt
//    }

    // einfacherer Ausdruck
    fun verfuegbarerPlatz(): Int = this.maxInhalt - this.inhalt


    fun einschenken(wunschMenge: Int) {
        var umfuellMenge = wunschMenge

        if (umfuellMenge > verfuegbarerPlatz()) {
            umfuellMenge = verfuegbarerPlatz()
        }

        this.inhalt = this.inhalt + umfuellMenge

    } // fun einschenken
} // class Glas

// class FLASCHE
class Flasche9 ( var inhalt: Int ) {

    fun umfuellen(glas: Glas8): Int {
        var umfuellMenge = glas.verfuegbarerPlatz()
        if (this.inhalt < umfuellMenge ) {
            umfuellMenge = this.inhalt
        }


        this.inhalt = this.inhalt - umfuellMenge
        glas.inhalt = glas.inhalt + umfuellMenge

        return glas.inhalt
    }

    // weitere Ausdrücke
//    var umfuellMenge2 = 0
//    if ( this.inhalt < glas.freierPlatz) {
//        umfuellMenge2 = this.inhalt
//    } else {
//        umfuellMenge2 = glas.freierPlatz
//
//        val umfuellMenge3 = if ( this.inhalt ‹ glas.freierPlatz) this.inhalt else glas. freierPlatz

} // class Flasche

class Tisch3(val glaeser: MutableList<Glas8>){

    val gesamtMenge : Int
        get() {
            var ergebnis = 0
            for (g in glaeser) {
                ergebnis = ergebnis + g.inhalt
            }
            return ergebnis
        }

}


fun main () {

    val bunteFlasche = Flasche8(800)

    val glaeser = mutableListOf<Glas8> ()

    while (bunteFlasche.inhalt > 0) {
        val neuesGlas = Glas8(0)
        bunteFlasche.umfuellen(neuesGlas)
        glaeser.add(neuesGlas)
    }

    // do while stellt sich das die Logik im Code-Rumpf mindestens einmal ausgeführt wird
    do {
        println("Soll noch ein Glas gefüllt werden ?")
        val eingabe = readLine()
        if (eingabe == "ja") {
            val neuesGlas = Glas8(100)
            glaeser.add(neuesGlas)
        } // if
    } while (eingabe != "nein")

    val festTisch = Tisch2(glaeser)

    println("Inhalt der Flasche: ${bunteFlasche.inhalt} ml")
    println("Inhalt der Gläser auf dem Tisch: ${festTisch.gesamtMenge}")


} //fun main


fun umfuellMengeBerechnen10 ( mengeFlasche : Int , mengeGlas : Int , maxMengeGlas : Int ) : Int {
    val umfuellMenge = maxMengeGlas - mengeGlas
    if (mengeFlasche >= umfuellMenge) {
        return umfuellMenge
    } else {
        return mengeFlasche
    }



} // umfuellMengeBerechnen10