package dyang

/**
  * Define an interface object
  */
object Print {
  def format[A](input: A)(implicit printer: Printable[A]): String = printer.format(input)

  def print[A](input: A)(implicit printer: Printable[A]): Unit = println(printer.format(input))
}
