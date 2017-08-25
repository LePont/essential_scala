package ch5

object ErrorHandling {

  sealed trait Result[A]

  final case class Success[A](result: A) extends Result[A]

  final case class Failure[A](msg: String) extends Result[A]

}