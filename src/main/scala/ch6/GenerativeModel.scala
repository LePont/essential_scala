package ch6

object GenerativeModel {

  def allCombos(names: List[String], verbs: List[String], objects: List[String]) = {
    for {
      a <- names
      b <- verbs
      c <- objects
    } yield (a, b, c)
  }

  def verbPicker(name :String): List[String] = {
    name match {
      case "Noel" => List("wrote","chased","slepton")
      case "Thecat" => List("meowed at","chased","slepton")
      case "Thedog" => List("barked at","chased","slepton")
    }
  }

  def objectPicker(verb: String): List[String] = {
    verb match {
      case "wrote" => List("The book", "The letter", "The Code")
      case "chased" => List("The ball", "the dog", "the cat")
      case "slepton" => List("the bed", "the mat", "the train")
      case "meowed at" => List("Noel", "the door", "the cupboard")
      case "barked at" => List("the post man ", "the car", "the cat")
    }
  }

  def refinedCombos(names: List[String]) = {
    for {
      a <- names
      b <- verbPicker(a)
      c <- objectPicker(b)
    } yield (a, b, c)
  }
}
