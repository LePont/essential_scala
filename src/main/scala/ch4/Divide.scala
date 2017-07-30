package ch4


sealed trait DivisionResult

final case class Finite(res: Int) extends DivisionResult
final case object Infinite extends DivisionResult

object divide {

  def apply(v1: Int, v2: Int): DivisionResult = {
    if (v2 == 0) Infinite else Finite(v1/v2)
  }
}
