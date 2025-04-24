import de.th_koeln.basicstage.Actor
import de.th_koeln.basicstage.Stage
import de.th_koeln.basicstage.coordinatesystem.Location
import de.th_koeln.basicstage.coordinatesystem.Size
import de.th_koeln.basicstage.coordinatesystem.WorldConstants
import de.th_koeln.imageprovider.ActorAppearance
import de.th_koeln.imageprovider.Assets
import kotlin.random.Random


// I HAD SOME STRUGGLES HERE TOO


// Track which snack was last eaten
data class EatenSnack(val actor: Actor, val filename: String)

fun main() {

    val stage = Stage()

    val kodeeE = Actor(Assets.kodee.ELECTRIFIED)
    kodeeE.x = 50
    kodeeE.y = 50
    stage.addActor(kodeeE)

    val btn = Actor()
    btn.text.content = "Random Position"
    btn.text.textBackground = Assets.textBackgrounds.BLUE_BUTTON
    btn.location = Location(10,10)
    btn.size = Size(200,40)
    stage.addActor(btn)

    var ateSnacksCounter = 0

    val display = Actor()
    display.text.content = "Anzahl Snacks: ${ateSnacksCounter}"
    display.text.textBackground = Assets.textBackgrounds.GREEN_BANNER
    display.x = 250
    display.y = 10
    // need to change this with dynamic sizing
    display.width = 300
    display.height = 80
    stage.addActor(display)

    val stage_w = WorldConstants.STAGE_WIDTH
    val stage_h = WorldConstants.STAGE_HEIGHT

    // Order the snacks must be eaten in:
    val expectedSnackOrder = listOf(
        Assets.snacks.DONUT1,
        Assets.snacks.CUPCAKE1,
        Assets.snacks.PIZZA,
        Assets.snacks.RAMEN
    )

    var expectedSnackIndex = 0
    var lastEatenSnack: EatenSnack? = null

    val snackActorLists = mutableListOf(
        Assets.snacks.DONUT1,
        Assets.snacks.CUPCAKE1,
        Assets.snacks.PIZZA,
        Assets.snacks.RAMEN
    )

    val allSnackActors = mutableListOf<Actor>()

    for (snackAsset in snackActorLists) {

        val snackActor = Actor(snackAsset)

        snackActor.x = Random.nextInt(stage_w)
        snackActor.y = Random.nextInt(stage_h)
        snackActor.width = Random.nextInt(60, 150)
        snackActor.height = Random.nextInt(60, 150)

        allSnackActors.add(snackActor)

        snackActor.reactionForMousePressed = label@ {

            // Do nothing if already eaten
            if (!snackActor.visible) return@label

            if (snackAsset == expectedSnackOrder[expectedSnackIndex]) {
                // ✅ Correct snack!

                val myAnimation = PropertyAnimationValueChange (
                    _start = 100,
                    _end = 0,
                    numberOfSteps = 25,
                    actor = snackActor,
                    propertyName = AnimatableProperties.OPACITY
                )
                snackActor.animation.queue.addPropertyAnimation(myAnimation)

                snackActor.visible = false
                ateSnacksCounter++
                expectedSnackIndex++

                display.text.content = "Anzahl Snacks: $ateSnacksCounter"

                lastEatenSnack = EatenSnack(snackActor, snackAsset)

                if (expectedSnackIndex >= expectedSnackOrder.size) {
                    display.text.content += "\nAlles in der richtigen Reihenfolge gegessen! 😋"
                }

            } else {
                // ❌ Wrong snack
                kodeeE.appearance = ActorAppearance(Assets.kodee.BROKEN_HEARTED)
            }
        }

        stage.addActor(snackActor)
    }

    btn.reactionForMousePressed = {
        // Shuffle positions
        for (actor in allSnackActors) {
            actor.x = Random.nextInt(stage_w)
            actor.y = Random.nextInt(stage_h)
        }

        // Optional: reset if all are invisible (not required by you yet)
    }

}
