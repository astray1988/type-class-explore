package dyang

object PrintDefault {
	implicit val stringPrintable = new Printable[String] {
		override def format[A](input: A): String = input.toString
	}

	implicit val intPrintable = new Printable[Int] {

		override def format[A](input: A): String = input.toString
	}
}