package ch5

object ErrorHandling {

  sealed trait Result[A]

  final case class SuccessResult[A](result: A) extends Result[A]

  final case class FailureResult[A](msg: String) extends Result[A]

}