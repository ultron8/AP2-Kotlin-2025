import de.th_koeln.basicstage.Actor
import de.th_koeln.basicstage.Stage
import de.th_koeln.imageprovider.Assets




fun main() {
    val stage = Stage()

    // different actors
//    val actor = Actor()
    val kodee = Actor(Assets.KODEE)
    val kodeeE = Actor(Assets.kodee.ELECTRIFIED)
    val monster1 = Actor(Assets.monster.MONSTER1)
    val monster2 = Actor(Assets.monster.MONSTER2)
    val ghostRED = Actor(Assets.monster.GHOST_RED)
    val happyDog = Actor(Assets.dog.HAPPY)
    val ultronRobot = Actor(Assets.robot.ACTION)

    // Modifizieren der Actors
    // versetzen der Positonen der einzelnen Actors
    // kodee
    kodee.x = 700
    kodee.y = 5
    kodee.rotation = 45

    // kodeeE
    kodeeE.x = 600
    kodeeE.y = 5
    kodeeE.rotation = 90
    kodeeE.active

    // monster1
    monster1.x = 500
    monster1.y = 5
    monster1.rotation = 15
    monster1.visible = true

    // monster2
    monster2.x = 400
    monster2.y = 5
    monster2.rotation = 25
    monster1.visible = false

    // ghostRED
    ghostRED.x = 300
    ghostRED.y = 5
    ghostRED.rotation = 35
    ghostRED.opacity = 10

    // happyDog
    happyDog.x = 200
    happyDog.y = 5
    happyDog.rotation = 180

    // ultronRobot
    ultronRobot.x = 100
    ultronRobot.y = 5
    ultronRobot.rotation = 270
    // ultronRobot.drawBorder = true -> wird nicht gefunden
    ultronRobot.width = 150
    ultronRobot.height = 150




    // Ausgabe von den Actor() auf der Stage()
    stage.addActor(kodee)
    stage.addActor(kodeeE)
    stage.addActor(monster1)
    stage.addActor(monster2)
    stage.addActor(ghostRED)
    stage.addActor(happyDog)
    stage.addActor(ultronRobot)
}