package simpleMath

/**
  * Created by dylan on 3/18/16.
  * Typeclasses in Scala with Dan Rosen
  * https://www.youtube.com/watch?v=sVMES4RZF-8
  */

// Define the trait
sealed trait Expression

case class Number(value: Int) extends Expression

case class Plus(lhs: Expression, rhs: Expression) extends Expression

case class Minus(lhs: Expression, rhs: Expression) extends Expression



// provide an implementation of instance
object ExpressionEvaluator {
  def value(expression: Expression): Int = expression match {
    case Number(value) => value
    case Plus(lhs, rhs) => value(lhs) + value(rhs)
    case Minus(lhs, rhs) => value(lhs) - value(rhs)
  }
}
