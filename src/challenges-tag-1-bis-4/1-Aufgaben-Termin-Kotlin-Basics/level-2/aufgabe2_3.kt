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



    // FOR LOOP
    for (snackAsset in snackActorLists) {

        // randomStage Numbers (location)
        var randomStageX = Random.nextInt(stage_w)
        var randomStageY = Random.nextInt(stage_h)

        // randomSize Numbers for Actors (size)
        var randomSizeWidth = Random.nextInt(60, 150)
        var randomSizeHeight = Random.nextInt(60, 150)


        // snackAsset ist eine String-Referenz
        val snackActor = Actor(snackAsset)

        snackActor.x = randomStageX
        snackActor.y = randomStageY
        snackActor.width = randomSizeWidth
        snackActor.height = randomSizeHeight

        // Animation
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



    } // for loop


} // fun main


/*
* Pseudocode
* random Zahlen generieren
* diese an Variable übergeben
*
* */
