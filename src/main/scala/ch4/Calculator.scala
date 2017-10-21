package ch4

import ch5.ErrorHandling._


object Calculator {

  def +(cal: Result[Int], v: Int): Result[Int] ={
    cal match{
      case SuccessResult(c) => SuccessResult(c+v)
      case FailureResult(m) => FailureResult(m)
    }
  }

  def -(cal: Result[Int], v: Int):Result[Int] ={
    cal match {
      case SuccessResult(c) => SuccessResult(c-v)
      case FailureResult(m) => FailureResult(m)
    }
  }

  def /(cal: Result[Int], divisor: Int): Result[Int] ={
    cal match{
      case SuccessResult(value) => if(divisor == 0) FailureResult("Division by zero") else SuccessResult(value/divisor)
      case FailureResult(m) => FailureResult(m)
    }
  }
}
