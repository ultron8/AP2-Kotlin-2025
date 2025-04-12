// Einfache Klassen

// Aus diesen If-Statements Klassen erstellen...
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

    // obj von der class Flasche
    val flasche = Flasche(800)

    // Flasche
    // var inhaltFlasche : Int = 800
//    flasche.inhalt = 500


    // obj von der class Glas
    val glas1 = Glas(40, 150)
    // Glas 1
//    var inhaltGlas1 = 40
    //val maxInhaltGlas1 = 150

    val glas2 = Glas(90, 200)
    // Glas 2
    //var inhaltGlas2 = 90
    //val maxInhaltGlas2 = 200

    // später: warum geht das nicht das ich Variablen als Parameter zu übergebe?
    //val glas = Glas(inhaltGlas1, maxInhaltGlas1)


    println("In der Flasche sind noch ${flasche.inhalt} ml vorhanden.")
    println("Im Glas sind ${glas1.inhalt} ml vorhanden.")

} // fun main

// class Glas
class Glas(var inhalt: Int, val maxInhalt: Int)
class Flasche(var inhalt: Int)
