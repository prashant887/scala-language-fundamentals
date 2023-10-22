package methodsandfunctions

import scala.collection.immutable.List

object PartiallyAppliedFunction extends App {
  val priceList:List[Double]=List(122.32,32.45,67.23,453.23,82.34)

  def checkGreaterThen100(price:Double):Boolean={
    price>100
  }

  val greaterPrice:List[Double]=priceList.filter(x=>checkGreaterThen100(x))

  println(greaterPrice)

  val greaterPricePartial:List[Double]=priceList.filter(checkGreaterThen100) //PlaceHolder that takes entire param list , this is a partial function None is passed

  println(greaterPricePartial)

  //Convert method to function

  val greaterThenPriceFunction=checkGreaterThen100 _ //Replaces entire param list , here only one param

  val greaterThenFunctionList:List[Double]=priceList.filter(greaterThenPriceFunction)

  println(greaterThenFunctionList)

  def checkPriceInRange(price:Double,lower:Double,upper:Double):Boolean={
    lower<=price && price<=upper
  }

  val priceRangeFunction=checkPriceInRange _

  val priceRangeList:List[Double]=priceList.filter(price=>priceRangeFunction(price,50,100))

  println(priceRangeList)

  val priceRangeFunctionUpper=checkPriceInRange(_:Double,_:Double,150) //Partial Function

  val priceRangeListUpper:List[Double]=priceList.filter(price=>priceRangeFunctionUpper(price,50))


  def logMessages(level:String,message:String) : Unit = {
    level.toLowerCase match {
      case "info" => println(s"INFO:$message")
      case "debug" => println(s"DEBUG:$message")
      case "error" => println(s"ERROR:$message")

    }
  }
    val infoMessage=logMessages("info",_:String)
    val debugMessage=logMessages("debug",_:String)
    val errorMessage=logMessages("error",_:String)

    infoMessage("Started")
  debugMessage("Here")
  errorMessage("Null Point Exception")



}
