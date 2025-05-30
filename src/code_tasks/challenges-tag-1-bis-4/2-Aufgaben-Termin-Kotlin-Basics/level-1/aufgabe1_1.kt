import de.th_koeln.basicstage.Actor
import de.th_koeln.basicstage.Stage
import de.th_koeln.imageprovider.Assets

class Pet(name: String = "Kodee", health: Int = 80, happiness: Int = 50 ): Actor() {

    // Actors
    val kodee = Actor(Assets.kodee.ELECTRIFIED)

}

class Game(){
    // creates a stage
    val stage = Stage()

    var somePet = Pet("Ultron", 100, 100)

}

