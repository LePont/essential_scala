package ch5

object GenTypes {

  case class GenPair[A, B](one: A, two: B)

  sealed trait Sum[A, B] {

    def fold[C](gl: (A, B) => C, gr: (A, B) => C): C = {
      this match {
        case GenLeft(value) => gl(value)
        case GenRight(value) => gr(value)
      }
    }
  }

  final case class GenLeft[A, B](value: A) extends Sum[A, B]
  final case class GenRight[A, B](value: B) extends Sum[A, B]

  sealed trait Maybe[A] {

    def fold[B](empty: B, full: A => B): B ={
      this match{
        case Empty() => empty
        case Full(a) => full(a)
      }
    }
  }

  final case class Full[A](a: A) extends Maybe[A]
  final case class Empty[A]() extends Maybe[A]


}