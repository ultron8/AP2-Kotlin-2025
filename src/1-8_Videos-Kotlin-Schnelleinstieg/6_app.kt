// Einfache Funktionen

// wiederholenden Code vermeiden durch Funktionen
            /*  // umfuellmenge 1

            // Wie viel ml passt noch in das Glas?
            var umfuellmenge = maxInhaltGlas - inhaltGlas

            if (inhaltFlasche >= umfuellmenge) {
                // das Glas wird mehr
                inhaltGlas = inhaltGlas + umfuellmenge
                // die Flasche wird weniger
                inhaltFlasche = inhaltFlasche - umfuellmenge
            } else {
                inhaltGlas = inhaltGlas + inhaltFlasche
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


    // Funktion
    // Glas 1
    var umfuellMenge1 = umfuellMengeCalc(inhaltFlasche, inhaltGlas1, maxInhaltGlas1)

    // hierbei muss der inhaltFlasche um erste umfuellMenge reduziert werden
    inhaltFlasche -= umfuellMenge1
    // und beim inhaltGlas1 muss die erste umfuelleMenge hinzugefügt werden
    inhaltGlas1 += umfuellMenge1

    // damit sich korreckte Angaben bei der umfuellMenge2 ergeben...

    // Glas 2
    var umfuellMenge2 = umfuellMengeCalc(inhaltFlasche, inhaltGlas2, maxInhaltGlas2)

    // das gleiche für Glas2
    inhaltFlasche -= umfuellMenge2
    inhaltGlas2 += umfuellMenge2

    println("In der Flasche sind noch $inhaltFlasche ml vorhanden.")
    println("Im Glas sind $inhaltGlas1 ml vorhanden.")

} // fun main


// Funktion umfuellMenge
    // brauchen drei Parameter:
        // Wie viel ist in der Flasche drin?
        // Wie viel im Glas?
        // Was ist der maximale Inhalt des Glases?
fun umfuellMengeCalc(mengeFlasche: Int, mengeGlas: Int, maxMengeGlas: Int): Int {

    var umfuellMenge = maxMengeGlas - mengeGlas

    if (mengeFlasche >= umfuellMenge) {
        return umfuellMenge
    } else {
        return mengeFlasche
    }



} // fun umfuellMenge