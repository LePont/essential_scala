package ch7

import scala.math.Ordering
import scala.math.abs
import ch7.Order

object GO7 extends App {

  val c = List(1, 2, 3, 5, -4)
  implicit val absOrd = Ordering.fromLessThan[Int](abs(_) < abs(_))

  assert(List(-4, -1, 0, 2, 3).sorted == List(0, -1, 2, 3, -4))
  assert(List(-4, -3, -2, -1).sorted == List(-1, -2, -3, -4))
/*
  Type Class Instance Packaging: Companion Objects
  When defining a type class instance, if

      1. there is a single instance for the type; and
      2. you can edit the code for the type that you are defining the instance for

  then define the type class instance in the companion object of the type.
*/

  final case class Rational(Numerator: Double, Denom: Double)

  object Rational {

    implicit val rationalOrd = Ordering.fromLessThan[Rational]((x, y) =>
      (x.Numerator / x.Denom) < (y.Numerator / y.Denom))
  }

  assert(List(Rational(1, 2), Rational(3, 4), Rational(1, 3)).sorted == List(Rational(1, 3), Rational(1, 2), Rational(3 ,4)))

  val orders = List(Order(100, 1), Order(2, 100), Order(50, 50))
  orders.foreach(o => println(o))
  println(orders.sorted)

//  import ch7.UnitPriceOrdering.unitPriceOrd
  println(orders.sorted)

  import ch7.UnitOrdering.unitOrd
  println(orders.sorted)

}
