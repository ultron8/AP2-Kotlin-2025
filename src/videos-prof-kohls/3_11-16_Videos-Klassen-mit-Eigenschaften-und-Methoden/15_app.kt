// Konstruktoren und Initialisierung



// var maxInhalt erhält einen default-Wert von 200
    // wenn in fun main beim Objekt von class Glass kein Wert für maxInhalt festgelegt wird dann
    // wird der default-Wert 200 genommen
    // ODER man löst es mit einem sekundären constructor
class Glas5 ( inhalt_param : Int, val maxInhalt : Int = 200 ) {

    // wenn ein sekundärer constructor erstellt wird in der Klasse
        // muss auch immer der primäre constructor aufgerufen werden
            // WIE?
            // hierbei wird der Typ vom sekundären constructor vom Typ des primären constructors gesetzt durch this()
                // default-Werte werden auch noch mal festgelegt
                    // anteil * maxi -> unten in fun main steht 0.3 -> somit 0.3 * 200 maxInhalt = 60
    constructor ( anteil : Double, maxi: Int = 200 ) : this((anteil * maxi).toInt(), maxi )


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

    // init immer unter der jeweiligen Variable stehen idF -> var inhalt
    // dieser Programmcodeblock wird
        // beim Konstruieren des Objektes
        // wenn die einzelnen Datenfelder angelegt werden, aufgerufen
            // Tipp: man kann mehere init Blöcke haben...
    init {
        // hiermit sagen wir dem Programm bitte die set-Methode in inhalt bei der Initialisierung auch durchführen!
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

    }

} // class Glas


// eigentlich steht vor jeder runden Klammer idF der Konstruktor -> constructor
    // ein class Flasch5 constructor() {...}
class Flasche5 ( var inhalt: Int ) {

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
    val glas1 = Glas5 ( 40 , 150)
    val glas2 = Glas5 ( 90)
    // die Variablen um das Bsp für constructor zu zeigen
        // in der class Glass wird einfach ein default Wert für maxInhalt = 200 definiert
    val glas3 = Glas5 (180)
    val glas4 = Glas5 (70)
    val glas5 = Glas5(0.3,500)
    println("OHNE PARAMETER mit Default-Werten: Glas 5 inhalt: ${glas5.inhalt} ml und maxInhalt: ${glas5.maxInhalt} ml")

    val glasTest = Glas5(10, 100)

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

    val komischesGlas = Glas5 (-90, 200)
    println("Im komischen Glas sind zu Beginn ${komischesGlas.inhalt} ml. vorhanden.")
        // die erste Ausgabe in inhalt wird den Wert -90 enthalten und ausgeben
        // obwohl sein setter festgelegt worden ist in der internen variable von class Glas
            // welches im bei Eingabe eines Wertes überprüft, falls der < 0 ist dann setzt er diesen eigentlich auf 0
            // 1. in der class Glas wird aber bei der ersten Kompilierung der maxInhalt überprüft und festgelegt
            // 2. dann getraenk und dann vieles andere und dann erst var inhalt
                // dann wird erst der inhalt_param welcher auf inhalt refernziert verwendet
                // der eingegebene Wert wird erstmal bei der Initialisierung gesetzt
                // somit wird die set-Methode im späteren Programmcode aufgerufen aber nicht bei der Initialisierung!
                    // es gibt aber ein Verfahren welches die Überprüfung bei der Initialisierung realisieren lässt
                        // siehe class Glass -> Implementierung von init{}
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


fun calculateFillAmount6(mengeFlasche : Int, mengeGlas : Int, maxMengeGlas : Int): Int {

    val umfuellMenge = maxMengeGlas - mengeGlas
    if (mengeFlasche >= umfuellMenge) {
        return umfuellMenge
    } else {
        return mengeFlasche
    }

} // fun umfuellMenge