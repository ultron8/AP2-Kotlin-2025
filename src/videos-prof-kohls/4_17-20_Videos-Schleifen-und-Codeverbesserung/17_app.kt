
// class Glas
class Glas7 ( inhalt_param : Int, val maxInhalt : Int = 200 ) {

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

    val leer: Boolean
        get() {
            return inhalt == 0
        }

    val freierPlatz: Int
        get() {
            return this.maxInhalt - this.inhalt
        }


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

    fun verfuegbarerPlatz(): Int {
        return this.maxInhalt - this.inhalt
    }

    fun einschenken(wunschMenge: Int) {
        var umfuellMenge = wunschMenge

        if (umfuellMenge > verfuegbarerPlatz()) {
            umfuellMenge = verfuegbarerPlatz()
        }

        this.inhalt = this.inhalt + umfuellMenge

    } // fun einschenken
} // class Glas

// class FLASCHE
class Flasche7 ( var inhalt: Int ) {

    fun umfuellen(glas: Glas6): Int {
        var umfuellMenge = glas.verfuegbarerPlatz()
        if (this.inhalt < umfuellMenge ) {
            umfuellMenge = this.inhalt
        }


        this.inhalt = this.inhalt - umfuellMenge
        glas.inhalt = glas.inhalt + umfuellMenge

        return glas.inhalt
    }
} // class Flasche

class Tisch(val glaeser: MutableList<Glas7>){

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

    for ( i in 1.. 100 step 5) {
        println(i)
    }


    val bunteFlasche = Flasche(800)
    val glas1 = Glas7(40, 150)
    val glas2 = Glas7(90, 200)
    val glas3 = Glas7(0.3, 300)
    val glas4 = Glas7(0.4)
    val glas5 = Glas7(90, 200)




    // veränderliche Listen
    // wichtig die Variable glasListe3 kann auf KEINE andere Liste zeigen wegen val
    val glasListe3 = mutableListOf(glas1, glas2, glas3)
    println ("In der Liste sind ${glasListe3.size} Gläser")
    glasListe3.add(glas4)
    println ("In der Liste sind ${glasListe3.size} Gläser")

    for (g in glasListe3) {
        g.liesVor()
    }


    val ikeaTisch = Tisch(glasListe3)
    println("Gesamtmenge: ${ikeaTisch.gesamtMenge}")



} //fun main


fun umfuellMengeBerechnen8 ( mengeFlasche : Int , mengeGlas : Int , maxMengeGlas : Int ) : Int {
    val umfuellMenge = maxMengeGlas - mengeGlas
    if (mengeFlasche >= umfuellMenge) {
        return umfuellMenge
    } else {
        return mengeFlasche
    }
}