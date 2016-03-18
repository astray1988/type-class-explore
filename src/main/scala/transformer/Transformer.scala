package transformer

/**
  * Created by dylan on 3/17/16.
  * This is an example from http://underscore.io/blog/posts/2012/05/03/typeclasses.html
  *
  */
// define a trait Transformer tranform from type T to type R
trait Transformer[T, R] {
  def transform(t: T): R
}

/**
  * Create an companion object and giving default implementations for the typeclass
  */
object Transformer {
  // Transformer does transform int to string
  implicit object InttoStringTransformer extends Transformer[Int, String] {
    override def transform(t: Int): String = t.toString
  }

  /**
    * another implementation does transform a List[T] to String
    * But to do that it needs a transformer for T to String.
    */

  implicit def ListToStringTransformer[T](implicit tToString: Transformer[T, String]) = new Transformer[List[T], String] {
    override def transform(t: List[T]): String = t.map(tToString.transform(_)).mkString(",")
  }



}