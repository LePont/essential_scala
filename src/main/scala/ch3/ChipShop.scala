package ch3

object ChipShop {

  def willServe(cat: Cat): Boolean = {
    cat.food match {
      case "Chips" => true
      case _ => false
    }
  }

}
