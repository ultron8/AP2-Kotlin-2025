// if-Anweisung
fun main(){

    // edge case: wenn in der Flasche nicht mehr 500 ml Verfügbarkeit wäre
    var inhaltFlasche : Int = 80
    var inhaltGlas = 40

    val maxInhaltGlas = 150

    // Mit Wie viel ml kann das Glas noch aufgefüllt werden?
    val umfuellMenge = maxInhaltGlas - inhaltGlas
    println("Das Glas kann noch mit $umfuellMenge ml aufgefüllt werden")

    // 1. Fall: umfuellMenge wird eingeschüttet
    // 2. Fall: Rest der inhaltFlasche einschütten
    if (inhaltFlasche >= umfuellMenge) {
        // entnimm den Anteil für das Glas aus der Flasche
        inhaltFlasche = inhaltFlasche - umfuellMenge
        println("Aus der inhaltFlasche wurden: $inhaltFlasche ml entnommen")
        // füg es dem aktuellen Glasanteil hinzu
        inhaltGlas = inhaltGlas + umfuellMenge
        println("Dem inhaltGlas wurden: $inhaltGlas ml zugeführt")
    } else {
        // inhaltFlasche ist < umfuellmenge
        // daher kann der inhaltFlasche direkt dem inhaltGlas hinzugeführt werden
        // einfach die Flasche leer machen
        inhaltGlas = inhaltGlas + inhaltFlasche
        inhaltFlasche = 0
        println("Es ist noch inhaltFlasche: $inhaltFlasche ml vorhanden")
        println("inhaltGlas ist nun: $inhaltGlas ml und um $umfuellMenge ml aufgefüllt worden")
    }// if

} // fun main()
