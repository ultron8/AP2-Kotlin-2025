import de.th_koeln.basicstage.Actor
import de.th_koeln.basicstage.Stage
import de.th_koeln.basicstage.coordinatesystem.Location
import de.th_koeln.basicstage.coordinatesystem.Size
import de.th_koeln.basicstage.coordinatesystem.WorldConstants
import de.th_koeln.imageprovider.Assets
import kotlin.random.Random


// I HAD SOME STRUGGLES HERE


fun main() {

    val stage = Stage()


    val kodeeE = Actor(Assets.kodee.ELECTRIFIED)
    kodeeE.x = 50
    kodeeE.y = 50
    stage.addActor(kodeeE)

    // irgendwie beeinflusst button -> display, aber warum?
    // Button
    val btn = Actor()
    btn.text.content = "Random Position"
    btn.text.textBackground = Assets.textBackgrounds.BLUE_BUTTON
    btn.location = Location(10,10)
    btn.size = Size(200,40)
//    btn.visible = false
    stage.addActor(btn)

    // display Anzeige
    var ateSnacksCounter = 0

    val display = Actor()
    display.text.content = "Anzahl Snacks: ${ateSnacksCounter}"
    display.text.textBackground = Assets.textBackgrounds.GREEN_BANNER
    display.x = 250
    display.y = 10
    display.width = 200
    display.height = 65
//    display.visible = false

    stage.addActor(display)


    // Stage width and height
    val stage_w = WorldConstants.STAGE_WIDTH // 800 stage width
    val stage_h = WorldConstants.STAGE_HEIGHT // 600 stage height




    val snackActorLists = mutableListOf(
        Assets.snacks.DONUT1,
        Assets.snacks.CUPCAKE1,
        Assets.snacks.PIZZA,
        Assets.snacks.RAMEN
    )



    // ✅ Collect all snack actors here
    val allSnackActors = mutableListOf<Actor>()



    // FOR LOOP
    for (snackAsset in snackActorLists) {

        // snackAsset ist eine String-Referenz
        val snackActor = Actor(snackAsset)


        // randomStage Numbers (location) on the stage()
        var randomStageX = Random.nextInt(stage_w)
        var randomStageY = Random.nextInt(stage_h)

        // randomSize Numbers for Actors (size)
        var randomSizeWidth = Random.nextInt(60, 150)
        var randomSizeHeight = Random.nextInt(60, 150)

        // Position / Location on stage
        snackActor.x = randomStageX
        snackActor.y = randomStageY

        // randomisierte Zahlen werden an die einzelnen SnackActor x & y Koordinaten zugewiesen
        snackActor.width = randomSizeWidth
        snackActor.height = randomSizeHeight

        // ✅ Add to list
        allSnackActors.add(snackActor)

        // Animation + opacity Logik für snackActor (für Snacks)
        snackActor.reactionForMousePressed = {

            // Animation für die opacity...
            val myAnimation = PropertyAnimationValueChange (
                _start = 100,
                _end = 0,
                numberOfSteps = 25,
                actor = snackActor,
                propertyName = AnimatableProperties.OPACITY
            )
            snackActor.animation.queue.addPropertyAnimation(myAnimation)


            if (snackActor.opacity == 100) {
                snackActor.visible = false
            } // if


            ateSnacksCounter++
            display.text.content = "Anzahl Snacks: $ateSnacksCounter"

            if (ateSnacksCounter == 4) {
                display.text.content = "Anzahl Snacks: $ateSnacksCounter \nIch bin satt"


                val rotateAnimationKodeE = PropertyAnimationValueChange(
                    _start = 0,
                    _end = 500,
                    numberOfSteps = 20,
                    actor = kodeeE,
                    propertyName = AnimatableProperties.ROTATION
                )
                kodeeE.animation.queue.addPropertyAnimation(rotateAnimationKodeE)

            } // if

        } // .reactionForMousePressed

        stage.addActor(snackActor)



    } // for loop


    // ✅ Button shuffles all snack positions
    btn.reactionForMousePressed = {
        for (actor in allSnackActors) {
            actor.x = Random.nextInt(stage_w)
            actor.y = Random.nextInt(stage_h)

        }
        // if
    }

} // fun main


/*
* own task: If all snackActors are invisible, then they should reappear,
* and each one should be placed at a new random position on the stage, in random order.
*
* Detect if all snackActors are invisible (actor.visible == false).
* If so:
* Make each actor visible again.
* Set a new random position.
* Optionally shuffle the order (for true randomness).
*
* add this into the code base:
* btn.reactionForMousePressed = {
    val stage_w = WorldConstants.STAGE_WIDTH
    val stage_h = WorldConstants.STAGE_HEIGHT

    // 🔍 Check if all snacks are invisible
    if (allSnackActors.all { !it.visible }) {

        // 🔄 Shuffle the list for random reappearance order
        allSnackActors.shuffle()

        for (actor in allSnackActors) {
            // Set new random position
            actor.x = Random.nextInt(stage_w)
            actor.y = Random.nextInt(stage_h)

            // Make actor visible again
            actor.visible = true
        }

        // 🔁 Reset counter if needed
        ateSnacksCounter = 0
        display.text.content = "Anzahl Snacks: $ateSnacksCounter"
    } else {
        // Move only the currently visible snacks
        for (actor in allSnackActors) {
            if (actor.visible) {
                actor.x = Random.nextInt(stage_w)
                actor.y = Random.nextInt(stage_h)
            }
        }
    }
}

*
*
* */
