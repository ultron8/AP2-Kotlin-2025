import de.th_koeln.basicstage.Actor
import de.th_koeln.basicstage.Stage
import de.th_koeln.imageprovider.Assets
import kotlin.random.Random

class Pet(var name: String = "Kodee",
          var health: Health = Health(80, 80),
          var happiness: Int = 50
): Actor() {


    // Actors
    val kodee = Actor(Assets.kodee.ELECTRIFIED)


    // Methods
    fun lifeGoesOn(): Int {
        // creates random num of health.energy
        var randomNum = Random.nextInt(health.energy)
        health.energy -= randomNum
        return health.energy
    } // fun lifeGoesOn()

    init {
        animation.everyNsteps.reactionForTimePassed = {
            animation.everyNsteps.timeSpan = 25
            // 1 sek = 40 Zeitschritte
                // >0,5 sek = 25 Zeitschritte
        }
    } // init

//    var someItem = Item("name", ItemCategory.FOOD, 100, 100, 20)



    // List
    // inventory list
    var inventory : MutableList<Item> = mutableListOf()

    // addItem()
    fun addItem(item: Item) {
        inventory.add(item)
        happiness += item.happinessImpact
//        if (item.category == ItemCategory.BALL || item.category == ItemCategory.BOOK) {
//            happiness = happiness + item.happinessImpact(20)
//        }
    } // fun addItem()

    // deleteItem()
    fun deleteItem(item: Item) {
        inventory.remove(item)
        happiness -= item.happinessImpact

    } // fun deleteItem()

    // countItem()
    fun countItem(): Int {
        return inventory.size

    } // fun countItem()







} // class Pet

class Game() {
    // creates a stage
    val stage = Stage()

    // DIFFERENT ACTORS
    // object of class Pet()
    var myPet = Pet("Ultron", Health(100, 100), 100)



    fun energyDisplay(): Actor {
        // create a display
        val energyDisplay = Actor()
        // display is adjusted
        energyDisplay.text.content = "Energieanzeige: ${myPet.lifeGoesOn()}"
        energyDisplay.text.textBackground = Assets.textBackgrounds.GREEN_BANNER // later change the color if energy is below 50
        energyDisplay.x = 450
        energyDisplay.y = 10
        energyDisplay.width = 200
        energyDisplay.height = 60

        return energyDisplay

    } // energyDisplay()
    var stageTheEnergyDisplay = stage.addActor(energyDisplay())

    fun happinessDisplay(): Actor {
        val happinessDisplay = Actor()

        happinessDisplay.text.content = "Happiness-Anzeige ${myPet.happiness}"
        happinessDisplay.text.textBackground = Assets.textBackgrounds.GOLD_BANNER
        happinessDisplay.x = 100
        happinessDisplay.y = 10
        happinessDisplay.width = 200
        happinessDisplay.height = 60

        return happinessDisplay
    }
    var stageTheHappinessDisplay = stage.addActor(happinessDisplay())

} // class Game

