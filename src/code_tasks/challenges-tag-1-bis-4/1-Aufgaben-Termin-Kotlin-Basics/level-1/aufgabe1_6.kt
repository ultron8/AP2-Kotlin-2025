import de.th_koeln.basicstage.Actor
import de.th_koeln.basicstage.Stage
import de.th_koeln.basicstage.coordinatesystem.Location
import de.th_koeln.basicstage.coordinatesystem.WorldConstants
import de.th_koeln.imageprovider.Assets
import kotlin.random.Random

// hinzufügen von Snacks

fun main() {
    val stage = Stage()


    // Liste der Snack-Assets
    val snackActorLists = listOf(
        Assets.snacks.DONUT1,
        Assets.snacks.CUPCAKE1,
        Assets.snacks.PIZZA,
        Assets.snacks.RAMEN
    )


    // beide LOOPS funktionieren
//    for (i in snackActorLists) {
//        val snackActor = Actor(i)
//        val stage_w = WorldConstants.STAGE_WIDTH
//        val stage_h = WorldConstants.STAGE_HEIGHT
//        var x = Random.nextInt(stage_w)
//        var y =Random.nextInt(stage_h)
//        snackActor.location = Location(x, y)
//
//        stage.addActor(snackActor)
//    }


    snackActorLists.forEach {snackAssets ->
        // die einzelnen Elemente werden bei jedem Schleifen Durchgegang in snackActor gespeichert
        // und dann in stage.addActor(snackActor) auf die stage() gebracht (ausgegeben)
        val snackActor = Actor(snackAssets)
        // get the stage numbers
        // generate random nums from 0 - stage numbers
//        val stage_w = WorldConstants.STAGE_WIDTH
//        val stage_h = WorldConstants.STAGE_HEIGHT
//        var x = Random.nextInt(stage_w)
//        var y =Random.nextInt(stage_h)
//        snackActor.location = Location(x, y)
        stage.addActor(snackActor)
    }


} // fun main
