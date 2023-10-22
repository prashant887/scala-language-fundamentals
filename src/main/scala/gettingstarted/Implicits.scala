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
  val cad:Currency = "CAD 100"
  println(cad)
}
