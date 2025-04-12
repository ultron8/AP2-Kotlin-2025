// Call by Value Parameter

/*  vorheriges If-Statement in Funktionen abbilden

            // umfuellmenge 1

            // Wie viel ml passt noch in das Glas?
            var umfuellmenge = maxInhaltGlas - inhaltGlas

            // Wenn inhaltFlasche >= umfuellmenge dann
            if (inhaltFlasche >= umfuellmenge) {
                // soll das Glas mit der umfuellmenge erweitert werden
                inhaltGlas = inhaltGlas + umfuellmenge
                // und die Flasche mit der umfuellmenge reduziert werden
                inhaltFlasche = inhaltFlasche - umfuellmenge
            // Sonst (wenn inhaltFlasche < umfuellmenge) ist dann
            } else {
                // soll das Glas mit dem Rest vom Inhalt der Flasche erweitert werden
                inhaltGlas = inhaltGlas + inhaltFlasche
                // und logischerweise muss der Rest des Flaschen inhalts auf 0 gesetzt werden
                // da in der Flasche nichts mehr vorhanden ist...
                inhaltFlasche = 0
            } // if

            // Wie viel ml passt noch in das Glas2 ?
            var umfuellmenge2 = maxInhaltGlas2 - inhaltGlas2

            // umfuellmenge 2
            if (inhaltFlasche >= umfuellmenge2) {
                // das Glas wird mehr
                inhaltGlas2 = inhaltGlas + umfuellmenge2
                // die Flasche wird weniger
                inhaltFlasche = inhaltFlasche - umfuellmenge2
            } else {
                inhaltGlas2 = inhaltGlas + inhaltFlasche
                inhaltFlasche = 0
            } // if */

fun main() {
    // Flasche
    var inhaltFlasche : Int = 800

    // Glas 1
    var inhaltGlas1 = 40
    val maxInhaltGlas1 = 150

    // Glas 2
    var inhaltGlas2 = 90
    val maxInhaltGlas2 = 200



    umfuellen(inhaltFlasche, inhaltGlas1, maxInhaltGlas1)
    umfuellen(inhaltFlasche, inhaltGlas2, maxInhaltGlas2)

    println("In der Flasche sind noch $inhaltFlasche ml vorhanden.")
    println("Im Glas sind $inhaltGlas1 ml vorhanden.")

} // fun main


// Funktion umfuellMenge
fun umfuellMengeBerechnen(mengeFlasche: Int, mengeGlas: Int, maxMengeGlas: Int): Int {

    var umfuellMenge = maxMengeGlas - mengeGlas

    if (mengeFlasche >= umfuellMenge) {
        return umfuellMenge
    } else {
        return mengeFlasche
    }

} // fun umfuellMenge


// Funktion umfuellen hat kein Rückgabewert daher -> : Unit

fun umfuellen(mengeFlasche: Int, mengeGlas: Int, maxMengeGlas: Int) {

    var umfuellMenge = umfuellMengeBerechnen(mengeFlasche, mengeGlas, maxMengeGlas)

    // Parameter kann man nicht mehr umändern
    // Problem das wird die neuen (lokalen) Variablen nicht verwenden...
    val neueMengeGlas = mengeGlas + umfuellMenge
    val neueMengeFlasche = mengeFlasche - umfuellMenge

    // Lösung: erstellen von Klassen...


}
