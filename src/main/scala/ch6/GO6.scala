package ch6

import OptionOpts._
import GenerativeModel._
import ch6.Food_Opts._

object GO6 extends App{

  val oa = Some(3)
  val ob = Some(4)
  val na = None

  assert(addInts(oa, ob) == Some(7))
  assert(addInts2(oa, ob) == Some(7))

  calc("12", "+", "13")
  calc("12", "*", "13")
  calc("12", "-", "13")
  calc("12", "/", "3")
  calc("12", "+", "wdsdf")


  val names = List("Noel","Thecat","Thedog")
  val verbs = List("wrote","chased","slepton")
  val objects = List("thebook","theball","thebed")

  println(refinedCombos(names))

  val food: Distribution[Food] = Distribution(List(Raw -> 0.7, Cooked -> 0.3))

  val foodModel:Distribution[(Food, Cat)] =
    for{
      f <- food
      c <- cat(f)
    }yield(f,c)

  println(foodModel.ev)

  val pHarrasing = foodModel.ev filter{
    case ((_, Harassing), _) => true
    case ((_, Asleep), _) => false
  } map {case (a, p) => p} sum

  println(pHarrasing)

  //FROM REPL

  import scala.util.Try
  val opt1 = Some(1)
  val opt2 = Some(2)
  val opt3 = Some(3)
  val seq1 = Seq(1)
  val seq2 = Seq(2)
  val seq3 = Seq(3)
  val try1 = Try(1)
  val try2 = Try(2)
  val try3 = Try(3)

  for{
    a <- opt1
    b <- opt2
    c <- opt3
  } yield a+b+c

  for{
    a <- seq1
    b <- seq2
    c <- seq3
  } yield a+b+c

  for{
    a <- try1
    b <- try2
    c <- try3
  } yield a+b+c

  for((a,b) <- Seq(1,2,3).zip(Seq(4,5,6)))yield a+b

  for{
    a <- Seq(4,2,6)
    sq = a*a
    b <- Seq(5,34,78)
  }yield sq + b

  val example = Map(1 -> "a", 2 -> "b", 3 -> "c")
  example.get(1)

  example.flatMap {
    case (str, num) =>
      (1 to 3).map(x => (str + x) -> (num * x)) }

  for {
    (i,s) <- example
    x <- 1 to 3
  }yield (s + x) -> (i * x)


  val people = Set(
    "Alice",
    "Bob",
    "Charlie",
    "Derek",
    "Edith",
    "Fred")
  val ages = Map(
    "Alice"   -> 20,
    "Bob"     -> 30,
    "Charlie" -> 50,
    "Derek"   -> 40,
    "Edith"   -> 10,
    "Fred"    -> 60)
  val favoriteColors = Map(
    "Bob"     -> "green",
    "Derek"   -> "magenta",
    "Fred"    -> "yellow")
  val favoriteLolcats = Map(
    "Alice"   -> "Long Cat",
    "Charlie" -> "Ceiling Cat",
    "Edith"   -> "Cloud Cat")

  def favCol(name: String): Option[String] = {
    if (favoriteColors.contains(name)) Some(favoriteColors(name)) else Some("Beige")
  }

  favCol("Alice")
  favCol("Bob").get

  def printColours():Unit = {
    //  people.map(x => favCol(x).map(y => println(y)))
    val cols = for {
      p <- people
      result <- favCol(p)
    }yield result
    println(cols)
  }

  printColours()

  def lookup(name: String, m: Map[String, String]): String = {
    m(name)
  }


  lookup("Alice", favoriteLolcats)

  val oldest = people.foldLeft(Option.empty[String]) {(older, person) =>
    if (ages.getOrElse(person,0) > older.flatMap(ages.get).getOrElse(0)){
      Some(person)
    } else{
      older
    }
  }

  val fav = for {
    p <- oldest
    col <- favCol(p)
  }yield col


  val s1 = Set(1,2,3,4)
  val s2 = Set(2,5,7,98)

  def union[A](s1: Set[A], s2: Set[A]):Set[A] = {
    s1.flatMap(x  => s2 + x)
  }
  union(s1, s2)

  val m1 = Map('a' -> 1, 'b' -> 2, 'c'-> 12)
  val m2 =  Map('a' -> 10, 'b' -> 20, 'd'-> 14)

  m1 + ('a' -> 3)

  def mapUnion[A](m1: Map[A, Int], m2: Map[A, Int]): Map[A, Int] = {
    m1.foldLeft(m2){(a, b) =>
      val (k, v) = b
      val newV = a.getOrElse(k, 0)
      a + (k -> (newV+v))
    }
  }
  mapUnion(m1,m2)

  def genUnion[A, B](m1: Map[A, B], m2: Map[A, B], add: (B,B) => B): Map[A, B] = {
    m1.foldLeft(m2){(a, b) =>
      val (k, v) = b
      val newValue = a.get(k).map(x => add(x, v)).getOrElse(v)
      a + (k -> newValue)
    }
  }



}
