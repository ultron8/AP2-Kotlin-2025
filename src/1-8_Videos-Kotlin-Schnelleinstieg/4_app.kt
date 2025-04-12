// Ausdrücke
fun main(){

    var inhaltFlasche : Int = 500
    var inhaltGlas = 40

    val maxInhaltGlas = 150

    // Wie viel passt in das Glas noch rein?
    // Ausdruck -> maxInhaltGlas - inhaltGlas
        // Ausdruck -> auswerten, berechnen
    // restInhaltGlas = verfuegbarerPlatz
    var verfuegbarerPlatz = maxInhaltGlas - inhaltGlas
    println("der verfügbare Platz im Glas ist: $verfuegbarerPlatz ml")

    // Wie viel müssen wir aus der Flasche ausschenken um
    // das Glas vollständig zu füllen
    inhaltFlasche = inhaltFlasche - verfuegbarerPlatz
    // inhaltFlasche -= verfuegbarerPlatz
    println("inhaltFlasche enthält noch: $inhaltFlasche ml")

    // Wie kann aufgezeigt werden, dass das Glas gefüllt wurde
    inhaltGlas = inhaltGlas + verfuegbarerPlatz
    // inhaltGlas += verfuegbarerPlatz
    println("inhaltGlas ist genau: $inhaltGlas ml")
    println("also genau so groß wie maxInhaltGlas: $maxInhaltGlas ml")

    // test
    println((99).inc()) // Ausgabe sollte 100 sein
    // inc() inkrementiere den Wert genau um +1
    println(("Hallo").length)
    println(("Hallo").toUpperCase())


} // fun main()