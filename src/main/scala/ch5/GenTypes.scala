package ch5

object GenTypes {

  case class GenPair[A, B](one: A, two: B)

  //Either
  sealed trait Sum[+A, +B] {

    def flatMap[AA >: A, C](f: B => Sum[AA, C]): Sum[AA, C] = {
      this match {
        case Success(v) => f(v)
        case Failure(v) => Failure(v)
      }
    }

    def map[C](f: B => C): Sum[A, C] = {
      this match {
        case Success(v) => Success(f(v))
        case Failure(v) => Failure(v)
      }
    }

    def fold[C](gl: A => C, gr: B => C): C = {
      this match {
        case Failure(value) => gl(value)
        case Success(value) => gr(value)
      }
    }
  }

  final case class Failure[A](value: A) extends Sum[A, Nothing]
  final case class Success[B](value: B) extends Sum[Nothing, B]

  //Option
  sealed trait Maybe[A] {

    def flatMap[B](fn: A => Maybe[B]): Maybe[B] = {
      this match {
        case Full(v) => fn(v)
        case Empty() => Empty[B]()
      }
    }

    def map[B](fn: A => B): Maybe[B] = {
      this match {
        case Full(v) => Full(fn(v))
        case Empty() => Empty[B]()
      }
    }

    def map2[B](fn: A => B): Maybe[B] = {
      flatMap(v => Full(fn(v)))
    }


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