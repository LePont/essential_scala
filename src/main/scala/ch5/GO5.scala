package ch5

import ch5.ErrorHandling.{Failure, Success}
import ch5.LinkedList._
import ch5.Tree._
import ch5.GenTypes._

object GO5 extends App{

  val example2 = Pair(1, Pair(2, Pair(3, End())))
  println(example2(0))

  assert(example2.contains(2) == true)
  assert(example2.contains("THis Sdfgs") == false)

  assert(example2(0) == Success(1))
  assert(example2(1) == Success(2))
  assert(example2(2) == Success(3))
  assert(example2(3) == Failure("Bad times dude"))

  val tree: Tree[String] =
    Node(Node(Leaf("To"), Leaf("iterate")),
      Node(Node(Leaf("is"), Leaf("human,")),
        Node(Leaf("to"), Node(Leaf("recurse"), Leaf("divine")))))


  println(tree.fold[String]((a, b) => a + " " + b, str => str))


  val p = GenPair[Int, String](1,"hi")
  println(p.one, p.two, p)

  val su: Sum[Int, String] = GenLeft(120)
  val lsu = su match {
    case GenLeft(x) => x.toString
    case GenRight(y) => y
  }

  println(lsu)

  val perhapsNot: Maybe[Int] = Empty[Int]
  println(perhapsNot)
  val perhapsSo: Maybe[Int] = Full(123)
  println(perhapsSo)

}
