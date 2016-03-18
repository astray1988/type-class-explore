package dyang

import dyang.cat.Cat


object Main extends App {
  // test type object
//  val cat = Cat("dd", 4, "blue")
//  Print.print(cat)


  // test type syntax

  import Cat._
  import PrintSyntax._

  Cat("Lili", 5, "Yellow").print

}
