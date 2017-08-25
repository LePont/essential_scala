package ch4

object IntList {

  sealed trait IntList {

    def fold[A](end: A, f: (Int, A) => A): A =
      this match {
        case IntEnd => end
        case IntPair(hd, tl) => f(hd, tl.fold(end, f))
      }
    def length: Int =
      fold[Int](0, (_, tl) => 1 + tl)

    def product: Int =
      fold[Int](1, (hd, tl) => hd * tl)

    def sum: Int =
      fold[Int](0, (hd, tl) => hd + tl)

    def double: IntList =
      fold[IntList](IntEnd, (hd, tl) => IntPair(hd * 2, tl))
  }
  final case object IntEnd extends IntList

  final case class IntPair(head: Int, tail: IntList) extends IntList
}
