package ch4

import ch4.Colour.Colour

object Shapes {

  sealed trait Shape {
    def sides: Int
    def perimeter: Double
    def area: Double
    def colour: Colour
  }

  sealed trait Rectangular extends Shape {
    def width: Double
    def height: Double
    val sides = 4
    val perimeter = 2*width + 2*height
    val area = width*height
  }

  final case class Circle(radius: Double, colour: Colour) extends Shape {
    val sides = 1
    val perimeter = 2 * math.Pi * radius
    val area = math.Pi * radius * radius
  }

  final case class Rectangle(width: Double, height: Double, colour: Colour) extends Rectangular {}

  final case class Square(size: Double, colour: Colour) extends Rectangular {
    val width = size
    val height = size
  }
}