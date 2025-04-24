
// class Glas
class Glas6 ( inhalt_param : Int, val maxInhalt : Int = 200 ) {

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
class Flasche6 ( var inhalt: Int ) {

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




fun main () {


    val bunteFlasche = Flasche(800)
    val glas1 = Glas6(40, 150)
    val glas2 = Glas6(90, 200)
    val glas3 = Glas6(0.3, 300)
    val glas4 = Glas6(0.4)
    val glas5 = Glas6(90, 200)

    // unveränderliche Listen
        // neue Zuweisung nicht möglich
    val glasListe1 = listOf<Glas6>(glas1, glas2, glas3, Glas6(99))
    println("Das ist das erste Glas in der glasListe mit: ${glasListe1[0].inhalt} ml und maxInhalt von: ${glasListe1[0].maxInhalt}")
    var glasListe2 = listOf<Glas6>(glas1, glas2, glas3, Glas6(99))
    println("Das ist das zweite Glas in der glasListe mit: ${glasListe2[1].inhalt} ml und maxInhalt von: ${glasListe2[1].maxInhalt}")
    // weitere Liste
    val weitereListe = glasListe2 // die Liste änder sich niemals
    // neue Zuweisung möglich
    glasListe2 = listOf(Glas6(300))
    println("neue Zuweisung hat ein Element mit: ${glasListe2[0].inhalt} ml")



    // veränderliche Listen
        // wichtig die Variable glasListe3 kann auf KEINE andere Liste zeigen wegen val
    val glasListe3 = mutableListOf(glas1)
    println ("In der Liste sind ${glasListe3.size} Gläser")

    // das geht nicht
    // glasListe3 = mutableListOf<Glas> (glas3, glas4)

    // weiteres Glas der glasListe3 hinzufügen
    glasListe3.add(glas2)
    println ("In der Liste sind ${glasListe3.size} Gläser")

    // konkrete Element aus der Liste enfernen
    glasListe3.removeAt (0)
    glasListe3.remove (glas1)



} //fun main


fun umfuellMengeBerechnen7 ( mengeFlasche : Int , mengeGlas : Int , maxMengeGlas : Int ) : Int {
    val umfuellMenge = maxMengeGlas - mengeGlas
    if (mengeFlasche >= umfuellMenge) {
        return umfuellMenge
    } else {
        return mengeFlasche
    }
}