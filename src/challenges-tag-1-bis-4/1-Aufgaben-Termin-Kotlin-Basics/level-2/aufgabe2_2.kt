import de.th_koeln.basicstage.Actor
import de.th_koeln.basicstage.Stage
import de.th_koeln.basicstage.coordinatesystem.WorldConstants
import de.th_koeln.imageprovider.Assets
import kotlin.random.Random



fun main() {

    val stage = Stage()


    val kodeeE = Actor(Assets.kodee.ELECTRIFIED)
    kodeeE.x = 50
    kodeeE.y = 50
    stage.addActor(kodeeE)





    val stage_w = WorldConstants.STAGE_WIDTH // 800 stage width
    val stage_h = WorldConstants.STAGE_HEIGHT // 600 stage height



    val snackActorLists = mutableListOf(
        Assets.snacks.DONUT1,
        Assets.snacks.CUPCAKE1,
        Assets.snacks.PIZZA,
        Assets.snacks.RAMEN
    )




    var ateSnacksCounter = 0

    val display = Actor()

    display.text.content = "Anzahl Snacks: ${ateSnacksCounter}"
    display.text.textBackground = Assets.textBackgrounds.GREEN_BANNER
    display.x = 250
    display.y = 10
    display.width = 200
    display.height = 60

    stage.addActor(display)



    for (snackAsset in snackActorLists) {

        var randomStageWidth = Random.nextInt(stage_w)
        var randomStageHeight = Random.nextInt(stage_h)

        val snackActor = Actor(snackAsset)

        snackActor.x = randomStageWidth
        snackActor.y = randomStageHeight


        snackActor.reactionForMousePressed = {

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

        val allSnacks = mutableListOf<Actor> ()
        allSnacks.add(snackActor)
        println("All snacks: $allSnacks")

    } // for loop

    // AUFGABE 2

} // fun main

