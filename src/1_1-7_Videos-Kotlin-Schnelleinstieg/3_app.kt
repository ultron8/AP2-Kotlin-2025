// Variablen und Konstante Werte
fun main() {


    // int Typ
    var inhaltFalsche = 500
    var inhaltGlas = 40

    val maxInhaltGlas = 100 // soll sich nicht ändern

    // inhaltGlas zeigt bzw referenziert nun auf 120 anstatt 40
    // in Kotlin immer Referenzen auf Objekte
    inhaltGlas = 120

    // inhaltGlas soll nun auf 150 oder
    // auf den Inhalt von maxInhaltGlas refenzieren
    inhaltGlas = maxInhaltGlas



} // fun main()