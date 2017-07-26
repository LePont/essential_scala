package ch3

case class Person(fn: String, ln: String) {
  def name(): String = { fn + " " + ln }
}

object Person{
  def apply(n: String): Person = {
    val parts = n.split(" ")
    apply(parts(0),parts(1))
  }
}

