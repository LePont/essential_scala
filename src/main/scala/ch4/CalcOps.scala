package ch4


object CalcOps {
  sealed trait Expresion{
    def eval: Calculation = {
      this match {
        case Number(n) => Success(n)
        case Addition(x, y) => x.eval match {
          case Failure(message) => Failure(message)
          case Success(xVal) =>
            y.eval match {
              case Failure(message) => Failure(message)
              case Success(yVal) => Success(xVal + yVal)
            }
        }
        case Subtraction(x, y) => x.eval match {
          case Failure(message) => Failure(message)
          case Success(xVal) =>
            y.eval match {
              case Failure(message) => Failure(message)
              case Success(yVal) => Success(xVal - yVal)
            }
        }
        case Division(x, y) => x.eval match {
          case Failure(m) => Failure(m)
          case Success(xVal) =>
            y.eval match {
              case Failure(m) => Failure(m)
              case Success(yVal) =>
                  if (yVal == 0) Failure("Divide by zero")
                  else Success(xVal / yVal)
            }
        }
        case SquareRoot(v) => v.eval match {
            case Success(r) =>
              if(r < 0)
                Failure("Square root of negative number")
              else
                Success(Math.sqrt(r))
            case Failure(reason) => Failure(reason)
          }
      }
    }
  }

  final case class Number(value: Double) extends Expresion
  final case class Addition(left: Expresion, right: Expresion) extends Expresion
  final case class Subtraction(left: Expresion, right: Expresion) extends Expresion
  final case class Division(left: Expresion, right: Expresion) extends Expresion
  final case class SquareRoot(value: Expresion) extends Expresion

  sealed trait Calculation
  final case class Success(res: Double) extends Calculation
  final case class Failure(message: String) extends Calculation
}
