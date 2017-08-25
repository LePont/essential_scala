package ch4

import ch5.ErrorHandling._

object Recursion {
  sealed trait LinkedList[A]{

    def apply(i: Int): Result[A] = {
        this match {
          case End() => Failure("Bad times dude")
          case Pair(h, tl) => if(i == 0) Success(h) else tl(i-1)
        }
    }

    def length: Int = {
      this match {
        case End() => 0
        case Pair(_, tl) => 1+ tl.length
      }
    }

//    def product(): Int = {
//      this match {
//        case End() => 1
//        case Pair(h, tl) => h * tl.product()
//      }
//    }
//
//    def double(): LinkedList[Int] = {
//      this match{
//        case End() => End()
//        case Pair(h, tl) => Pair(h *2, tl.double())
//      }
//    }

    def contains[A](value: A): Boolean = {
      this match {
        case End() => false
        case Pair(h, t) => if(h == value) true else t.contains(value)
      }
    }
  }

  final case class End[A]() extends LinkedList[A]
  final case class Pair[A](head: A, tail: LinkedList[A]) extends LinkedList[A]

}
