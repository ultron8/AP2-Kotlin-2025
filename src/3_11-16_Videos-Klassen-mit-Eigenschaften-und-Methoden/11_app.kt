// Methoden für Klassen festlegen

class Glas ( var inhalt : Int, val maxInhalt : Int ) {
    var getraenk = "Wasser"

    fun liesVor() {
        println("Im Glas sind noch $inhalt ml $getraenk vorhanden")
        println("Maximal passen im Glas $maxInhalt ml")
    }

    fun availableSpace(): Int {
        return this.maxInhalt - this.inhalt
    }

} // class Glas

// theoretisch eigene Funktion auch möglich gewesen zu der Methode in der class Glass
/*fun liesVor ( glas : Glas ) {
    println("Im Glas sind noch ${glas.inhalt} ml. ${glas.getraenk} vorhanden.")
    println("Maximal passen ins Glas ${glas.maxInhalt} ml.")
} */

// fun verfuegbarerPlatz (emptySpace hört sich besser an)
/*fun emptySpace(x: Glas): Int {
    return x.maxInhalt - x.inhalt
} */


class Flasche ( var inhalt: Int ) {

} // class Flasche


fun main(){
    val flasche = Flasche ( 800 )
    val glas1 = Glas ( 40 , 150)
    val glas2 = Glas ( 90 , 200 )

    refill2( flasche, glas1 )
    refill2( flasche , glas2 )

    // glas 1
    glas1.liesVor()

    // glas 2
    // glas2 Getränk ändern
    glas2.getraenk = "Orangensaft"
    glas2.liesVor()

    // Methode availableSpace() nutzen
    println("Im ersten Glas sind noch ${glas1.availableSpace()} ml vorhanden")

    // theoretischer Aufruf der liesVor() Funktion wo das Objekt glas1 oder glas2 übergeben wird
    // liesVor(glas1)


} // fun main


fun calculateFillAmount2(mengeFlasche : Int , mengeGlas : Int , maxMengeGlas : Int): Int {

    val umfuellMenge = maxMengeGlas - mengeGlas
    if (mengeFlasche >= umfuellMenge) {
        return umfuellMenge
    } else {
        return mengeFlasche
    }
} // fun umfuellMenge


// Funktion umfuellen hat kein Rückgabewert daher -> : Unit

fun refill2(flasche: Flasche, glas: Glas) {

    val umfuellMenge = calculateFillAmount2(
        flasche.inhalt,
        glas.inhalt,
        glas.maxInhalt
    )

    // Parameter kann man nicht mehr umändern
    // Problem das wird die neuen (lokalen) Variablen nicht verwenden...
    glas.inhalt += umfuellMenge
    flasche.inhalt -= umfuellMenge
    // Lösung: erstellen von Klassen...

} // fun refill