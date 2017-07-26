package ch4

object Shapes {

  case class Circle(radius: Double) extends Shape{
    override def area: Double = ???

    override def perimeter: Double = ???

    override def sides: Double = 0
  }

  case class Square(side: Double) extends Shape {
    override def area: Double = ???

    override def perimeter: Double = ???

    override def sides: Double = ???
  }
}
