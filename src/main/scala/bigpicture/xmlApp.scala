package bigpicture

import scala.xml.{Elem, NodeSeq}

object xmlApp extends App {

  val person:Elem = <person>
  <firstname>Scott</firstname>
    <lastname>Tiger</lastname>
    <emails>
      <office>scott@oralce.com</office>
      <home>scott@hotmail.com</home>
    </emails>
  </person>

  val seq:NodeSeq=person\"firstname"

  println(seq)

  val email:NodeSeq=person \\ "emails"

email.map(e=>println(e))
}
