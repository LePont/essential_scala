package ch4

object Recursion {
  sealed trait IntList{

    def length(): Int = {
      this match {
        case End => 0
        case Pair(_, tl) => 1+ tl.length()
      }
    }

    def product(): Int = {
      this match {
        case End => 1
        case Pair(h, tl) => h * tl.product()
      }
    }

    def double(): IntList = {
      this match{
        case End => End
        case Pair(h, tl) => Pair(h *2, tl.double())
      }
    }
  }

  final case object End extends IntList
  final case class Pair(head: Int, tail: IntList) extends IntList

}
