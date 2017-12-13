package ch7

import scala.math.Ordering
import scala.math.abs

object GO7 extends App {

  val c = List(1,2,3,5,-4)

  implicit val absOrd = Ordering.fromLessThan[Int](abs(_) < abs(_))

  assert(List(-4, -1, 0, 2, 3).sorted == List(0, -1, 2, 3, -4))
  assert(List(-4, -3, -2, -1).sorted == List(-1, -2, -3, -4))

  final case class Rational(Numerator: Double, Denom: Double)

  implicit val ratOrd = Ordering.fromLessThan[Rational]((x, y) =>
    (x.Numerator / x.Denom)  < (y.Numerator / y.Denom))

  assert(List(Rational(1, 2), Rational(3, 4), Rational(1, 3)).sorted == List(Rational(1, 3), Rational(1, 2), Rational(3 ,4)))

}
