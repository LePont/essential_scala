package ch4

import ch5.ErrorHandling._


object Calculator {

  def +(cal: Result[Int], v: Int): Result[Int] ={
    cal match{
      case Success(c) => Success(c+v)
      case Failure(m) => Failure(m)
    }
  }

  def -(cal: Result[Int], v: Int):Result[Int] ={
    cal match {
      case Success(c) => Success(c-v)
      case Failure(m) => Failure(m)
    }
  }

  def /(cal: Result[Int], divisor: Int): Result[Int] ={
    cal match{
      case Success(value) => if(divisor == 0) Failure("Division by zero") else Success(value/divisor)
      case Failure(m) => Failure(m)
    }
  }
}
