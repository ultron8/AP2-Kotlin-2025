import de.th_koeln.basicstage.Actor
import de.th_koeln.basicstage.Stage
import de.th_koeln.imageprovider.Assets
import java.awt.print.Book

fun main() {

//     obj of Game
    val game = Game()

//     show the Stage()
    game.stage


//     show the display of the energy on the Stage()
    game.stageTheEnergyDisplay
    game.stageTheHappinessDisplay


    // test to println the countItem() method of the class Pet()
    val test = Pet()
    val count = test.countItem()

    // create items
    val testItem = Item("Ball", ItemCategory.BALL, 10, 15, 2)

    test.addItem(testItem)
//    println()

    println("The size of the list is: ${test.countItem()}")
    println("The list is: ${test.inventory}") // aktuell wird nur die Referenzen zurückgegeben


} // fun main