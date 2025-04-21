import de.th_koeln.basicstage.Actor
import de.th_koeln.basicstage.Stage
import de.th_koeln.imageprovider.Assets

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

    snackActorLists.forEach {snackAssets ->
        // die einzelnen Elemente werden bei jedem Schleifen Durchgegang in snackActor gespeichert
        // und dann in stage.addActor(snackActor) auf die stage() gebracht (ausgegeben)
        val snackActor = Actor(snackAssets)
        stage.addActor(snackActor)
    }


} // fun main
