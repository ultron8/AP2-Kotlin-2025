import de.th_koeln.basicstage.Actor
import de.th_koeln.basicstage.Stage
import de.th_koeln.basicstage.coordinatesystem.WorldConstants
import de.th_koeln.imageprovider.Assets
import kotlin.random.Random



fun main() {
    // creates a stage
    val stage = Stage()

    // die ACTORS
//    val kodeeE = Actor(Assets.kodee.ELECTRIFIED)


    // Übergebe die Werte der stage() an Variablen
    val stage_w = WorldConstants.STAGE_WIDTH // 800 stage width
    val stage_h = WorldConstants.STAGE_HEIGHT // 600 stage height

//    println(stage_w)
//    println(stage_h)


    // SNACKS
    // Creates a list of Snacks
    val snackActorLists = listOf(
        Assets.snacks.DONUT1,
        Assets.snacks.CUPCAKE1,
        Assets.snacks.PIZZA,
        Assets.snacks.RAMEN
    )


    // counter for Snacks
    var ateSnacksCounter = 0

    // Creates an Actor() called display
    val display = Actor()
    // display is adjusted
    display.text.content = "Anzahl Snacks: ${ateSnacksCounter}"
    display.text.textBackground = Assets.textBackgrounds.GREEN_BANNER
    display.x = 250
    display.y = 10
    display.width = 200
    display.height = 60
    // the actor display will be displayed on stage()
    stage.addActor(display)


    // Iteration durch die Liste
    for (snackAsset in snackActorLists) {
        // Generate new random position for EACH snack
        var randomStageWidth = Random.nextInt(stage_w)
        var randomStageHeight = Random.nextInt(stage_h)

        val snackActor = Actor(snackAsset)
        // Optional: Setze eine Position, z.B. nebeneinander mit Abstand
        snackActor.x = randomStageWidth
        snackActor.y = randomStageHeight

        // Snack mit der Maus angeklickt (gefressen)
        snackActor.reactionForMousePressed = {
            snackActor.visible = false
            // PROBLEM: hier wird der neue Wert von ateSnackCounter, da es im Loop ist, nicht an der Variablen auserhalb des Loops angepasst
            ateSnacksCounter++
            display.text.content = "Anzahl Snacks: $ateSnacksCounter"
            if (ateSnacksCounter == 4) {
                display.text.content = "Anzahl Snacks: $ateSnacksCounter \nIch bin satt"
            }


        } // .reactionForMousePressed

        // snackActor will be displayed on stage()
        stage.addActor(snackActor)
    } // for loop


} // fun main


