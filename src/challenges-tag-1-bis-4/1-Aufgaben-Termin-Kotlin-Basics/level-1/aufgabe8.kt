import de.th_koeln.basicstage.Actor
import de.th_koeln.basicstage.Stage
import de.th_koeln.basicstage.coordinatesystem.Location
import de.th_koeln.basicstage.coordinatesystem.Size
import de.th_koeln.basicstage.coordinatesystem.WorldConstants
import de.th_koeln.imageprovider.Assets
import kotlin.random.Random



fun main() {
    val stage = Stage()

    // die ACTORS
    val kodeeE = Actor(Assets.kodee.ELECTRIFIED)


    // Konstanten der stage()
    val stage_w = WorldConstants.STAGE_WIDTH // 800 stage width
    val stage_h = WorldConstants.STAGE_HEIGHT // 600 stage height

    println(stage_w)
    println(stage_h)


    // SNACKS
    // Liste der Snack-Assets
    val snackActorLists = listOf(
        Assets.snacks.DONUT1,
        Assets.snacks.CUPCAKE1,
        Assets.snacks.PIZZA,
        Assets.snacks.RAMEN
    )

    var snacksCounter = 0

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
            if (snackActor.visible == true) {
                snacksCounter++
                // yourActor.text.content = "Textausgabe"
                // erstelle ein btn siehe Docu
                counterZeiger()
            }

        }

        stage.addActor(snackActor)
    } // for loop


} // fun main

// Anzeige vom Counter erstellen
fun counterZeiger() {
    // muss noch umgeändert werden...
    val btn = Actor ()
    btn.text.content = "Action"
    btn.text. textBackground = Assets.textBackgrounds.BLUE_BUTTON
    btn.location = Location(10,10)
    btn.size = Size(200,40)
}
