import ch3._
import ch4.Colour.{CustomColour, Yellow}
import ch4.Recursion._
import ch4._
import ch4.Shapes._
import ch4.Trees.{Leaf, Node}
import ch5.ErrorHandling._

object Appy extends App{

  val c1 = Cat("q","red","chips")
  val c2 = Cat("q2","blue","chips")
  val c3 = Cat("q3","redfd","fish")

  println(ChipShop.willServe(c1))


  val eastwood              = new Director("Clint", "Eastwood", 1930)
  val mcTiernan             = new Director("John", "McTiernan", 1951)
  val nolan                 = new Director("Christopher", "Nolan", 1970)
  val someBody              = new Director("Just", "Some Body", 1990)
  val memento               = new Film("Memento", 2000, 8.5, nolan)
  val darkKnight            = new Film("Dark Knight", 2008, 9.0, nolan)
  val inception             = new Film("Inception", 2010, 8.8, nolan)
  val highPlainsDrifter     = new Film("High Plains Drifter", 1973, 7.7, eastwood)
  val outlawJoseyWales      = new Film("The Outlaw Josey Wales", 1976, 7.9, eastwood)
  val unforgiven            = new Film("Unforgiven", 1992, 8.3, eastwood)
  val granTorino            = new Film("Gran Torino", 2008, 8.2, eastwood)
  val invictus              = new Film("Invictus", 2009, 7.4, eastwood)
  val predator              = new Film("Predator", 1987, 7.9, mcTiernan)


  println(eastwood.yob)
  println(granTorino.director.name)
  println(invictus.isDirectedBy(nolan))

  val c = Counter(10).inc(12).dec().inc().dec().count
  println(c)

  val p = Person("my name")
  val p3 = Person("sfvf","sfsdfv")

  println(Dad.rate(unforgiven))

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
  val example = Pair(1, Pair(2, Pair(3, End())))
  assert(example.length == 3)
  assert(example.tail.length == 2)
  assert(End().length == 0)

//  assert(example.product == 6)
//  assert(example.tail.product == 6)
//  assert(End().product == 1)
//
//  assert(example.double == Pair(2, Pair(4, Pair(6, End()))))
//  assert(example.tail.double == Pair(4, Pair(6, End())))
//  assert(End().double == End())

  // Recusion with Trees
  val myTree =Trees.Node(Leaf(2),Node(Leaf(4), Leaf(12)))
  assert(TreeOps.sum(myTree) == 18)

  //
  //JSON

  import JSONOps._
  println(SeqItem(JSString("Test"), SeqItem(JSDouble(2.0),SeqEnd)).print)
  println(ObjSeq("MyKey", SeqItem(JSString("Test"), SeqItem(JSDouble(2.0),SeqEnd)),ObjEnd).print)

  // Generics

  println(example(0))

  assert(example.contains(2) == true)
  assert(example.contains("THis Sdfgs") == false)

  assert(example(0) == Success(1))
  assert(example(1) == Success(2))
  assert(example(2) == Success(3))
  assert(example(3) == Failure("Bad times dude"))

}
