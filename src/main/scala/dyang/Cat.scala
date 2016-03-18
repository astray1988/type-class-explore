package dyang

object cat {

  final case class Cat(name: String, age: Int, color: String)

  object Cat {
    import PrintDefault._

    implicit val catPrintable = new Printable[Cat] {

      override def format[A](input: A): String = {
        val name = Print.format(input.asInstanceOf[Cat].name)
        val age = Print.format(input.asInstanceOf[Cat].age)
        val color = Print.format(input.asInstanceOf[Cat].color)
        s"$name is a $age year-old $color cat."
      }
    }
  }

}



