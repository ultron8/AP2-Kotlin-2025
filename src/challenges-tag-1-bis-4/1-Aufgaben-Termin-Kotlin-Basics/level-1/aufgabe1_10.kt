import de.th_koeln.basicstage.Actor
import de.th_koeln.basicstage.Stage
import de.th_koeln.basicstage.coordinatesystem.WorldConstants
import de.th_koeln.imageprovider.Assets
import kotlin.random.Random



fun main() {
    // creates a stage
    val stage = Stage()

    // die ACTORS
    val kodeeE = Actor(Assets.kodee.ELECTRIFIED)
    kodeeE.x = 50
    kodeeE.y = 50
    stage.addActor(kodeeE)
    // KodeeE macht ein Salto nachdem alle Snacks gegessen wurden
    //if ()



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
    // set is not working out...
//        set(value) {
//            if (value == 4) {
//                field = 4
//            }
//        }
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
            // Animation einbauen: Snacks nicht sofort ausgeblendet, langsam verschwinden
            val myAnimation = PropertyAnimationValueChange (
                _start = 100,
                _end = 0,
                numberOfSteps = 25,
                actor = snackActor,
                propertyName = AnimatableProperties.OPACITY
            )
            snackActor.animation.queue.addPropertyAnimation(myAnimation)

            // falls die opdacity von snackActor == 100 ist
            // dann bitte visibility = false setzen (somit nicht mehr anklickbar)
            if (snackActor.opacity == 100) {
                snackActor.visible = false
            } // if

            // PROBLEM: hier wird der neue Wert von ateSnackCounter, da es im Loop ist, nicht an der Variablen auserhalb des Loops angepasst
            ateSnacksCounter++
            display.text.content = "Anzahl Snacks: $ateSnacksCounter"
            if (ateSnacksCounter == 4) {
                display.text.content = "Anzahl Snacks: $ateSnacksCounter \nIch bin satt"

                // animieren flip von KodeeE
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

        // snackActor will be displayed on stage()
        stage.addActor(snackActor)




    } // for loop


} // fun main


