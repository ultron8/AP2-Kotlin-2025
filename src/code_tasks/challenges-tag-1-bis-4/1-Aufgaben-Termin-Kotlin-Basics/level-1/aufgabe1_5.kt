import de.th_koeln.basicstage.Actor
import de.th_koeln.basicstage.Stage
import de.th_koeln.imageprovider.Assets




fun main() {
    val stage = Stage()

    // different actors
    val ultronRobot = Actor(Assets.robot.ACTION)
    ultronRobot.y = 500
    ultronRobot.x = 500

    // weiteren Actor hinzufügen
    val kodeeE = Actor(Assets.kodee.ELECTRIFIED)
    // Ausgngsposition von kodeeE ändern
//    kodeeE.x = 200
//    kodeeE.y = 5

    // Reaktionen auf Usereingaben:
    // reactionForMousePressed
    // weitere Modifikationen an ultron
    ultronRobot.reactionForMousePressed = {

        ultronRobot.rotation = 30
        ultronRobot.width = 200
        ultronRobot.height = 200
        // Geschwindigkeit des Actors anpassen
        ultronRobot.motion.speed = 10
        ultronRobot.motion.direction = 360
    }


    // 1)
    // Modifikationen an weiteren Actor idF kodeeE
        // hinzufügen der Motion Eigenschaft
//    kodeeE.reactionForMousePressed = {
//        kodeeE.motion.speed = 5
//        // 90° -> rechts ; 180° -> unten
//            // der Grad bestimmt die Richtung hierbei
//        kodeeE.motion.direction = 270
//    }
    // 2)
//    kodeeE.reactionForMousePressed = {
//        // kodeeE bewegt sich im Kreis durch clicks
//        kodeeE.animation.turtleControl.turnRight(10)
//        kodeeE.animation.turtleControl.forward(5)
//    }


    // 3)
    // PropertyAnimation
    kodeeE.reactionForMousePressed = {

        // X
        // eine Animations Funktion die per Mouse Click gestart wird für den actor = x
            // idF kodeeE
        // kodeeE bewegt sich automatisch nach rechts
        val myAnimation = PropertyAnimationValueChange(
            _start = 0,
            _end = 500,
            numberOfSteps = 20,
            actor = kodeeE,
            propertyName = AnimatableProperties.X
        )
        kodeeE.animation.queue.addPropertyAnimation(myAnimation)

        // OPACITY
        // kodeeE wird durchsichtig _end = 10 hilft dabei
            // aber verstehe den Mechanismus hierbei nicht so ganz
        val myAnimation2 = PropertyAnimationValueChange(
            _start = 0,
            // _end == degree
            _end = 10,
            // steps > höhere Zahl == Animation langsamer
            numberOfSteps = 10,
            actor = kodeeE,
            propertyName = AnimatableProperties.OPACITY
        )
        kodeeE.animation.queue.addPropertyAnimation(myAnimation2)

        // ROTATION
        // kodeeE rotiert um 180° in 30 steps
        val myAnimation3 = PropertyAnimationValueChange(
            _start = 0,
            // _end == degree
            _end = 180,
            // steps > höhere Zahl == Animation langsamer
            numberOfSteps = 30,
            actor = kodeeE,
            propertyName = AnimatableProperties.ROTATION
        )
        kodeeE.animation.queue.addPropertyAnimation(myAnimation3)

        // Y
        // sobald kodeeE angekommen ist an Punkt 500 bewegt es sich automatisch nach unten bis zur Mitte der stage()
        val myAnimation4 = PropertyAnimationValueChange(
            _start = 0,
            _end = 250,
            numberOfSteps = 20,
            actor = kodeeE,
            propertyName = AnimatableProperties.Y
        )
        kodeeE.animation.queue.addPropertyAnimation(myAnimation4)

        // kodeeE wird größer
        // WIDTH
        val myAnimation5 = PropertyAnimationValueChange(
            _start = 0,
            _end = 500,
            numberOfSteps = 20,
            actor = kodeeE,
            propertyName = AnimatableProperties.WIDTH
        )
        kodeeE.animation.queue.addPropertyAnimation(myAnimation5)

        //
        // HEIGHT
        val myAnimation6 = PropertyAnimationValueChange(
            _start = 0,
            _end = 500,
            numberOfSteps = 20,
            actor = kodeeE,
            propertyName = AnimatableProperties.HEIGHT
        )
        kodeeE.animation.queue.addPropertyAnimation(myAnimation6)

    }



    // Ausgabe der Actors auf die stage()
    stage.addActor(ultronRobot)
    stage.addActor(kodeeE)

}