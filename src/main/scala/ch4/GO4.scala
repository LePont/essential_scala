package ch4

import ch4.Colour.{CustomColour, Yellow}
import ch4.IntList.{IntEnd, IntPair}
import ch4.Shapes.{Rectangle, Square}
import ch4.Trees.{Leaf, Node}
import ch5.ErrorHandling.{Failure, Success}

object GO4 extends App{
    println("** Shapes **")

  val myCol = CustomColour(1,3,2)
  val sq = Square(4, Yellow)
  val rect = Rectangle(12,2,myCol)

  println(Draw(sq))
  println(Draw(rect))

  def checkDiv(x: Int) = divide(1,x) match {
    case Finite(v) => s"Its finite ${v}"
    case Infinite => "It an infinite"
  }

  println(checkDiv(2))
  println(checkDiv(0))

  //CALC

  assert(Calculator.+(Success(1), 1) == Success(2))
  assert(Calculator.-(Success(1), 1) == Success(0))
  assert(Calculator.+(Failure("Badness"), 1) == Failure("Badness"))

  assert(Calculator./(Success(4), 2) == Success(2))
  assert(Calculator./(Success(4), 0) == Failure("Division by zero"))
  assert(Calculator./(Failure("Badness"), 0) == Failure("Badness"))


  //Recursion with Lists
  val example = IntPair(1, IntPair(2, IntPair(3, IntEnd)))

  assert(example.length == 3)
  assert(example.tail.length == 2)
  assert(IntEnd.length == 0)

  assert(example.product == 6)
  assert(example.tail.product == 6)
  assert(IntEnd.product == 1)

  assert(example.double == IntPair(2, IntPair(4, IntPair(6, IntEnd))))
  assert(example.tail.double == IntPair(4, IntPair(6, IntEnd)))
  assert(IntEnd.double == IntEnd)

  // Recusion with Trees
  val myTree =Trees.Node(Leaf(2),Node(Leaf(4), Leaf(12)))
  assert(TreeOps.sum(myTree) == 18)

  //
  //JSON

  import JSONOps._
  println(SeqItem(JSString("Test"), SeqItem(JSDouble(2.0),SeqEnd)).print)
  println(ObjSeq("MyKey", SeqItem(JSString("Test"), SeqItem(JSDouble(2.0),SeqEnd)),ObjEnd).print)


}
