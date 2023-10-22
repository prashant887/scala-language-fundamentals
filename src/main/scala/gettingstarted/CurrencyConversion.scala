package gettingstarted

object CurrencyConversion {
  def main(args: Array[String]): Unit = {
    val Array(code:String,value:String)=args(0).split("\\s")
    val valueAsDouble:Double=value.toDouble
    if(!Set("CAD","NZD").contains(code)){
      println("Supported Currencies are CAD and NZD")
      System.exit(0)
    }
    /*
    val utils:Utils=new Utils()
    val rate:Double=utils.getRateFrom(code = code)

     */
    //This acts as static class
    val rate:Double=Utils.getRateFrom(code = code)
    println(args(0)+ " = USD "+(rate*valueAsDouble))
  }

}
//class Utils
object Utils {
  private  val cadToUsd:Double=1/1.30
  private  val nzdToUsd:Double=1/1.50

  def getRateFrom(code:String):Double={
    println(s"Getting Rate From $code")
    code match {
      case "NZD" => nzdToUsd
      case "CAD" => cadToUsd
    }
  }

}