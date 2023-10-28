package gettingstarted


object Implicits extends App {

  case class Currency(code:String,amount:Double,toUSD:Double)
//money "USD 100"
  implicit def stringToCurrency(money:String):Currency={
    val ary :Array[String]=money.split("\\s")
    //    val Array(code:String,value:String)=money.split("\\s")
    val amount=ary(1).toDouble
    val code=ary(0)

    code match {
      case "USD" => Currency("USD",amount,amount)
      case "NZD" => Currency("USD",amount,amount*(1/1.5))
      case "CAD" => Currency("USD",amount,amount*(1/1.30))
    }
  }
  //This works normally
  println(stringToCurrency("USD 100"))
  println(stringToCurrency("NZD 100"))

  //This works after making function implicit
  val cad:Currency = "CAD 100"//mathes for function with this format

  println(cad)

  def sayHello(name:String)(implicit myself:String):String={
    s"Hello $name ! My name is $myself"
  }

  implicit val myString="implicets" //only one impicient variable can be present
  implicit val newStr="anotherStr"

  val fast=sayHello("test")(newStr)
  // or when only one impicent var is defined
  //  val fast=sayHello("test")(newStr)

  println(fast)


  //Implcient class , that takes single param implcient class can take any variable of i/p type (string here) and convert to instance of itself
  implicit class stringUtils(myString:String){
    def wordCount():Unit={
      println(myString)
    }
  }

  "This is a sentence".wordCount()
}
