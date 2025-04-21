import de.th_koeln.basicstage.Actor
import de.th_koeln.basicstage.Stage
import de.th_koeln.imageprovider.Assets




fun main() {
    val stage = Stage()

    // different actors
    val ultronRobot = Actor(Assets.robot.ACTION)


    // weitere Modifikationen an ultron
    ultronRobot.reactionForMousePressed = {
        ultronRobot.x = 400
        ultronRobot.y = 400
        ultronRobot.rotation = 30
        ultronRobot.width = 200
        ultronRobot.height = 200
    }



    stage.addActor(ultronRobot)
}