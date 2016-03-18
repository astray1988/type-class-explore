package dyang

trait Printable[A] {
	def format[A](input: A): String
}


