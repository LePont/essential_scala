package ch6

import ch6.GenerativeModel.Distribution

object Food_Opts {

  sealed trait Food
  case object Raw extends Food
  case object Cooked extends Food

  sealed trait Cat
  case object Asleep extends Cat
  case object Harassing extends Cat

  def cat(f:Food): Distribution[Cat] = {
    f match {
      case Raw => Distribution.discrete(List(Harassing -> 0.4, Asleep -> 0.6))
      case Cooked => Distribution.discrete(List(Harassing -> 0.8, Asleep -> 0.2))
    }
  }
}
