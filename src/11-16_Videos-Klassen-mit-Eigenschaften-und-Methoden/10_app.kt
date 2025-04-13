package `11-16_Videos-Klassen-mit-Eigenschaften-und-Methoden`

// Array Lists

class Glas ( var inhalt : Int, val maxInhalt : Int )
class Flasche ( var inhalt: Int )

fun main(){

    val flasche = Flasche ( 800 )
    val glas1 = Glas ( 40 , 150)
    val glas2 = Glas ( 90 , 200 )

//    refill( flasche, glas1 )
//    refill( flasche , glas2 )

    // arrayListOf vom type Glas (ausschließlich)
    val tablettMitGlaesern = arrayListOf<Glas>(glas1, glas2, Glas(40, 900))

    // weiteres Glas hinzufügen -> add
    tablettMitGlaesern.add(Glas(50, 200))

    // Ausgeben wie viele Gläser auf dem Tablett stehen
    // method .size
    println("Auf dem Tabelett stehen ${tablettMitGlaesern.size} Gläser")

    // auf eines der Elemente im array zurückgreifen
        // zB das erste Element im array
    // das hier printed die ID des Glases am Index 0
        // das ist nur die Referenz vom array gespeichert
    println("${tablettMitGlaesern[0]} ml")
    // hier interessiert uns der Inhalt daher
        // tablettMitGlaesern.inhalt
        // Gebe den Inhalt vom Element im index 0 im array aus
    println("${tablettMitGlaesern[0].inhalt} ml")

    // Exception: wenn versucht wird auf das das 4te Element zurückzugreifen
        // wir greifen außerhalb des Gültigkeitsbereich zu...
        // wird eine exception geworfen, da diese out-of-range ist im array
        //tablettMitGlaesern[4]
        // IndexOutOfBoundsException:
            /*Exception in thread "main" java.lang.IndexOutOfBoundsException: Index 4 out of bounds for length 4
                at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
                at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
                at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
                at java.base/java.util.Objects.checkIndex(Objects.java:385)
                at java.base/java.util.ArrayList.get(ArrayList.java:427)
                at 11-16_Videos-Klassen-mit-Eigenschaften-und-Methoden._10_appKt.main(10_app.kt:33)
                at 11-16_Videos-Klassen-mit-Eigenschaften-und-Methoden._10_appKt.main(10_app.kt)*/

    // placeholder
    println(" ")

    // alle Element im array ausgeben
    println("for loop - alle Element im array:")
    for (i in tablettMitGlaesern) {
        println("${i.inhalt} ml")
    }

    // placeholder
    println(" ")

    // anpassen des for-loops
    for (i in 0..3) {
        println("Im $i-ten Glas sind ${tablettMitGlaesern[i].inhalt} ml")
    }

    // placeholder
    println(" ")

    // weitere Anpassung des for-loops
        // ${i+1}
    for (i in 0..3) {
        println("Im ${i+1}-ten Glas sind ${tablettMitGlaesern[i].inhalt} ml")
    }

    var sum = 0
    // Wie viel ml sind in allen Gläsern zusammen drin?
    for (i in 0..3) {
        val x = tablettMitGlaesern[i].inhalt
        sum = sum + x
    }
    println("Es sind insgesamt $sum ml in den 3 Gläsern vorhanden")

    // Doz Lösung
    var gesamtInhalt = 0
    for ( glas in tablettMitGlaesern) {
        gesamtInhalt += glas.inhalt
    }

    println("Der gesamte Inhalt $gesamtInhalt ml.")

    // Vorschau auf Lambda Expressions
    // das bildet auf die Summe der Inhalte in den Gläsern
        // nur in viel effizenterem Code
    val nochmalInhalt = tablettMitGlaesern.sumBy { it.inhalt }

} // fun main

// Funktionen
fun calculateFillAmount(mengeFlasche : Int , mengeGlas : Int , maxMengeGlas : Int): Int {

    val umfuellMenge = maxMengeGlas - mengeGlas
    if (mengeFlasche >= umfuellMenge) {
        return umfuellMenge
    } else {
        return mengeFlasche
    }
} // fun umfuellMenge


// Funktion umfuellen hat kein Rückgabewert daher -> : Unit

fun refill(flasche: `8-10_Videos-Klassen-erstellen`.Flasche, glas: `8-10_Videos-Klassen-erstellen`.Glas) {

    val umfuellMenge = calculateFillAmount(flasche.inhalt, glas.inhalt, glas.maxInhalt)

    // Parameter kann man nicht mehr umändern
    // Problem das wird die neuen (lokalen) Variablen nicht verwenden...
    glas.inhalt += umfuellMenge
    flasche.inhalt -= umfuellMenge
    // Lösung: erstellen von Klassen...

} // fun refill