package ch6

import scala.util.Try

object OptionOpts {

  def addInts(oa: Option[Int], ob: Option[Int]):Option[Int] = {
    for {
      a <- oa
      b <- ob
    }yield a+b
  }

  def addInts(oa: Option[Int], ob: Option[Int], oc: Option[Int]):Option[Int] = {
    for {
      a <- oa
      b <- ob
      c <- oc
    }yield a + b + c
  }

  def addInts2(oa: Option[Int], ob: Option[Int]):Option[Int] = {
    oa.flatMap(x => ob.map(y => x+y))
  }

  def addInts2(oa: Option[Int], ob: Option[Int], oc: Option[Int]):Option[Int] = {
    oa flatMap{a =>
      ob flatMap{ b =>
        oc map{ c =>
          a + b + c
        }
      }
    }
  }

  def divide(a: Int, b: Int): Option[Int] = {
    if(b < 1) None else Some(a/b)
  }

  def divideOptions(oa: Option[Int], ob: Option[Int]) = {
    for {
      a <- oa
      b <- ob
    } yield divide(a,b)
  }

  private def tryToInt(i: String) = {
    Try(i.toInt).toOption
  }

  def calc(operand1: String, operator: String, operand2: String): Unit = {

    val result = for {
      a <- tryToInt(operand1)
      b <- tryToInt(operand2)
      cal <- operator match {
        case "+" => Some(a + b)
        case "-" => Some(a - b)
        case "*" => Some(a * b)
        case "/" => divide(a, b)
        case _ => None
      }
    }yield cal

    result match {
      case Some(num) => println(s"Answer is ${num}")
      case None => println("Cannot calculate")
    }
  }
}
