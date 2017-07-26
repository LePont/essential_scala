package ch4

object Cats {

  case class Lion(colour: String, maneSize: Int) extends Feline

  case class Tiger(colour: String) extends Feline

  case class Panther(colour: String) extends Feline

  case class Cat(colour: String, food: String) extends Feline {
    override def sound: String = "meow"
  }

}