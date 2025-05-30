import de.th_koeln.basicstage.Actor

enum class ItemCategory {
    FOOD,
    TOY,
    BOOK,
    BALL,
    OTHER
}

class Item(var name: String,
           var category: ItemCategory,
           var amount: Int,
           var energyImpact: Int,
           var happinessImpact: Int
)  {

//    override fun toString(): String {
//        return "[$name, $happinessImpact]"
//    }

} // class Item