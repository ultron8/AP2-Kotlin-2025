import `8-10_Videos-Klassen-erstellen`.Flasche
import `8-10_Videos-Klassen-erstellen`.Glas

// Call by Value für referenzierte Objekte



fun main() {

    // obj von der class Flasche
    val flasche = Flasche(800)



    // obj von der class Glas
    val glas1 = Glas(40, 150)
    val glas2 = Glas(90, 200)

    refill(flasche, glas1)
    refill(flasche, glas2)



    println("In der Flasche sind noch ${flasche.inhalt} ml vorhanden.")
    println("Im Glas sind ${glas1.inhalt} ml vorhanden.")

} // fun main





// Funktion umfuellMenge
fun calculateFillAmount(mengeFlasche : Int , mengeGlas : Int , maxMengeGlas : Int): Int {

    val umfuellMenge = maxMengeGlas - mengeGlas
    if (mengeFlasche >= umfuellMenge) {
        return umfuellMenge
    } else {
        return mengeFlasche
    }
} // fun umfuellMenge


// Funktion umfuellen hat kein Rückgabewert daher -> : Unit

fun refill(flasche: Flasche, glas: Glas) {

    val umfuellMenge = calculateFillAmount(flasche.inhalt, glas.inhalt, glas.maxInhalt)

    // Parameter kann man nicht mehr umändern
    // Problem das wird die neuen (lokalen) Variablen nicht verwenden...
    glas.inhalt += umfuellMenge
    flasche.inhalt -= umfuellMenge
    // Lösung: erstellen von Klassen...

} // fun refill