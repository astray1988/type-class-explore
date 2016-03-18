package dyang

/**
  * Created by dylan on 3/17/16.
  */
object PrintSyntax {
  implicit class PrintOpts[A](value: A) {
    def format[A](implicit printable: Printable[A]): String = printable.format(value)

    def print[A](implicit printable: Printable[A]): Unit = println(printable.format(value))
  }

}
