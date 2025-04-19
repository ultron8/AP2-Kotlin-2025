// Data Hiding: Eigenschaften und Eigenschaftsfelder
    // public -> überall sichtbar
    // private -> nur in der Klasse sichtbar
    // internal -> nur im Modul sichtbar

class Glas4 ( inhalt_param : Int, val maxInhalt : Int ) {


    // PROPERTIES
    var getraenk : String = "Wasser"

        set(value) {
            field = value.uppercase()

        } // setter
    // get method kommt immer unter die set methode
        // kein Parameter
    get () {
        println("Es wird der Inhalt vom Glas ausgelesen")
        return field
    }

    // ist das Glas voll oder leer?
        // Eigenschaft ist wenn maxInhalt ereicht ist dann ist das Glas voll
    val voll : Boolean
        get () {
            return maxInhalt == inhalt
        }

    val vollText : String
        get() {
            if (voll) {
                return "Das jeweilige Glas ist voll und hat die maximale Kapazität von $maxInhalt ml ausgeschöpft"
            } else {
                return "Da ist noch etwas Platz im Glas"
            }
        }

    val leer : Boolean
        get () {
            return inhalt == 0
        }

    val freierPlatz : Int
        get() {
            return this.maxInhalt - this.inhalt
        }


    var inhalt = inhalt_param
        set (value) {

            if (value < 0) field = 0
            if (value > maxInhalt) field = maxInhalt
            if (value >= 0 && value <= maxInhalt) field = value
        }

    // METHODS

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


class Flasche4 ( var inhalt: Int ) {

    fun umfuellen(glas: Glas2): Int {
        var umfuellMenge = glas.availableSpace()
        if (this.inhalt < umfuellMenge ) {
            umfuellMenge = this.inhalt
        }


        this.inhalt = this.inhalt - umfuellMenge
        glas.inhalt = glas.inhalt + umfuellMenge

        return glas.inhalt
    }
} // class Flasche


fun main ( args : Array <String> ) {

    val bunteFlasche = Flasche3 ( 800 )
    val glas1 = Glas4 ( 40 , 150)
    val glas2 = Glas4 ( 90 , 200 )

    val glasTest = Glas4(10, 100)

    glasTest.getraenk = "Club Mate"

    val clubMate = glasTest
    println("Das Getränk ${clubMate.getraenk} hat ${clubMate.inhalt} ml und passt insgesamt noch ${clubMate.maxInhalt - clubMate.inhalt} ml rein.")
    clubMate.inhalt = 100
    println("Das Getränk ${clubMate.getraenk} hat ${clubMate.inhalt} ml und passt insgesamt noch ${clubMate.maxInhalt - clubMate.inhalt} ml rein.")
    println("Glas Status: ${clubMate.voll}-> ${clubMate.vollText}")
    // property voll verwenden



    glas2.getraenk = "Cola"

    glas1.liesVor()
    glas2.liesVor()

    val komischesGlas = Glas4 (100, 200)
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


fun calculateFillAmount5(mengeFlasche : Int, mengeGlas : Int, maxMengeGlas : Int): Int {

    val umfuellMenge = maxMengeGlas - mengeGlas
    if (mengeFlasche >= umfuellMenge) {
        return umfuellMenge
    } else {
        return mengeFlasche
    }

} // fun umfuellMenge