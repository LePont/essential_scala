package ch4

import ch4.ADTSamples.{Calculation, Failure, Success}


object Calculator {

  def +(cal: Calculation, v: Int): Calculation ={
    cal match{
      case Success(c) => Success(c+v)
      case Failure(m) => Failure(m)
    }
  }

  def -(cal: Calculation, v: Int):Calculation ={
    cal match {
      case Success(c) => Success(c-v)
      case Failure(m) => Failure(m)
    }
  }

  def /(cal: Calculation, divisor: Int): Calculation ={
    cal match{
      case Success(value) => if(divisor == 0) Failure("Division by zero") else Success(value/divisor)
      case Failure(m) => Failure(m)
    }
  }
}
