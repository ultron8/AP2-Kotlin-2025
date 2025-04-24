import de.th_koeln.basicstage.Actor
import de.th_koeln.basicstage.Stage
import de.th_koeln.basicstage.coordinatesystem.WorldConstants
import de.th_koeln.imageprovider.Assets
import kotlin.random.Random

// hinzufügen von Snacks

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


    for (snackAsset in snackActorLists) {

        // Generate new random position for EACH snack
        var randomStageWidth = Random.nextInt(stage_w)
        var randomStageHeight = Random.nextInt(stage_h)

        val snackActor = Actor(snackAsset)

        // Optional: Setze eine Position, z.B. nebeneinander mit Abstand
        snackActor.x = randomStageWidth
        snackActor.y = randomStageHeight

        stage.addActor(snackActor)

    } // for loop


    //









//    kodeeE.x = randomStageWidth
//    kodeeE.y = randomStageHeight
//    stage.addActor(kodeeE)
} // fun main
