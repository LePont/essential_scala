package ch5

import ch5.ErrorHandling.{Failure, Result, Success}

object LinkedList {

  sealed trait LinkedList[A] {

        def apply(i: Int): Result[A] = {
          this match {
            case End() => Failure("Bad times dude")
            case Pair(h, tl) => if(i == 0) Success(h) else tl(i-1)
          }
        }

        def length: Int =
          this match {
            case Pair(_, tl) => 1 + tl.length
            case End() => 0
          }

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
