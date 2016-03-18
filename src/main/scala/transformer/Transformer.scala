package transformer

import scala.xml.Node

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


  /**
    *Transformer does transform int to string, here need extend and implement the Transformer trait
    * Two ways implementation.
    * 1. define an object to extend the Transformer trait and give concrete implementation
    * 2. use def to implement Transformer trait.
    */

  implicit object InttoStringTransformer extends Transformer[Int, String] {
    override def transform(t: Int): String = t.toString
  }

//  implicit def IntToStringTrans[T] = new Transformer[T, String] {
//    override def transform(t: T): String = t.toString
//  }





  /**
    * another implementation does transform a List[T] to String
    * But to do that it needs a transformer for T to String.
    */

  implicit def ListToStringTransformer[T](implicit tToString: Transformer[T, String]) = new Transformer[List[T], String] {
    override def transform(t: List[T]): String = t.map(tToString.transform(_)).mkString(",")
  }


}

/**
  * Make use of the typeclass, here transformer will drop back to the default implementation.
  */

trait Transform {

  def transform[T, R](t: T)(implicit transformer: Transformer[T, R]): R = transformer.transform(t)

}


/**
  *
  * The default implementations in the Transformer's companion object
  */

object ExampleWithDefaults extends App with Transform {

  println(transform(2))
  println(transform(List(1, 2, 3)))
}

object ExmapleWithMyTransformers extends App with Transform {
  implicit object MyIntToXmlTransformer extends Transformer[Int, scala.xml.Node] {
    override def transform(t: Int): Node = <aNumber>{ t.toString }</aNumber>
  }

  implicit def ListToXMLTransformer[T](implicit transformer: Transformer[T, xml.Node]) =
    new Transformer[List[T], xml.NodeSeq] {
      import xml._

      override def transform(t: List[T]): xml.NodeSeq = t.foldLeft(NodeSeq.Empty) {
        (accu, next) => accu ++ transformer.transform(next)
      }
    }

  /**
    * Define a transformer from Boolean to String,
    * After defining this, we can now transform List[Boolean] to String.
    * Note: The List transformer defined in the default Transformer trait will be used.
    */
  implicit object BooleanToStringTransformer extends Transformer[Boolean, String] {
    override def transform(b: Boolean): String = b.toString
  }

  println(transform(2))
  println(transform(List(2,3,4)))
  println(transform(List(true, false, true, true)))


}