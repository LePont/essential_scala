package ch3

case class Director(fn: String, ln: String, yob: Int) {
  def name(): String = {
    fn +" "+ln
  }
}

object Director {

  def older(director1: Director, director2: Director) = {
    if (director1.yob > director2.yob) director1 else director2
  }
}
