package gettingstarted

object ImplicitConversions extends App {


  def capatilizer(words: List[String]): List[String] = words.map(x => x.capitalize)

  def tokinizer(str: String): List[String] = str.split(" ").toList

  implicit def  implTokinizer(str: String): List[String] = str.split(" ").toList

  val words:List[String]=List("apple","ball","cat")
  println(capatilizer(words))

  val title:String="implicit what where when"

  //Convert String to Array and then Capatlize
  println(capatilizer(tokinizer(title)))

  //Implicts takes care , capatilizer takes list of string ,
  // and see what method can do that work and calls matching function string to list converson function on itw own
  
  println(capatilizer(title))

}
