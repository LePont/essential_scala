package ch5

import ch5.GenTypes._


object GenCalc {

  sealed trait Expresion {
    def eval: Sum[String, Double] = {
      this match {
        case Number(n) => Success(n)

        case Addition(l, r) => myHelp(l, r, (left, right) => Success(left + right))
        case Subtraction(l, r) => myHelp(l, r, (left, right) => Success(left - right))
        case Division(l, r) => myHelp(l, r, (left, right) =>
          if (right == 0)
            Failure("Divide by Zero  error")
          else
            Success(left / right)
        )
        case SquareRoot(v) =>
          v.eval flatMap { value =>
            if (value < 0)
              Failure("Square root of negative number")
            else
              Success(Math.sqrt(value))
          }
      }
    }

    def myHelp(l: Expresion, r: Expresion, fn: (Double, Double) => Sum[String, Double]) = {
      l.eval flatMap { left =>
        r.eval flatMap { right =>
          fn(left, right)
        }

      }
    }
  }

  final case class Number(value: Double) extends Expresion

  final case class Addition(left: Expresion, right: Expresion) extends Expresion

  final case class Subtraction(left: Expresion, right: Expresion) extends Expresion

  final case class Division(left: Expresion, right: Expresion) extends Expresion

  final case class SquareRoot(value: Expresion) extends Expresion

}