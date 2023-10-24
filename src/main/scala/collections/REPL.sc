import scala.::

List()
List(1,2,3,4)
val colors:List[String]=List("Red","Green","Yellow")
"red" :: "yellow"::Nil //Nil Empty List

//Case class has unapply and used to extaract patterns , match

val names:List[String]=List("Dale","Susan","Bob","Del")
names match {
  //case List("Dale",_*) => println("Dale Found")
  //case List(x,"Susan",_*) => println(s"Susam Found Afer $x")
  case List(_,"Susan",x,_*) => println(s"After Susam Found  $x")

}

println("\n")