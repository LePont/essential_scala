package ch5

import ch5.ErrorHandling.{Failure, Success}
import ch5.LinkedList._

object GO5 extends App{

  val example2 = Pair(1, Pair(2, Pair(3, End())))
  println(example2(0))

  assert(example2.contains(2) == true)
  assert(example2.contains("THis Sdfgs") == false)

  assert(example2(0) == Success(1))
  assert(example2(1) == Success(2))
  assert(example2(2) == Success(3))
  assert(example2(3) == Failure("Bad times dude"))

}
