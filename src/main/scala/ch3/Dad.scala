package ch3

object Dad {

  def rate(film: Film): Int = {
    film.director.name() match {
      case "Clint Eastwood" => 10
      case "John McTiernan" => 7
      case _ => 3
    }
  }
}
