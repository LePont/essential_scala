package ch4

object Colour {

sealed trait Colour {
    def R: Double
    def G: Double
    def B: Double
    def isLight = (R + G + B) / 3.0 > 0.5
    def isDark = !isLight
  }

  final case object Red extends Colour {
    val R = 1.0
    val G = 0
    val B = 0
  }

  final case object Yellow extends Colour {
    val R = 1.0
    val G = 1.0
    val B = 0
  }

  final case object Pink extends Colour {
    val R = 1.0
    val G = 0.41
    val B = 0.7
  }

  final case class CustomColour(R: Double, G: Double, B: Double) extends Colour {}

}