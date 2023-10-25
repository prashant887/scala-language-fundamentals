package classesandobjects

import classesandobjects.Currency.conversionTable

object Currency{
  private val conversionTable:Map[String,Double]=Map("CAD"->1/1.30,"NZD"->1/1.50)
def apply(code:String,amount:Double)=new Currency(code, amount)

  def createUSD(amount:Double)=new Currency("USD",amount)
  def createNZD(amount:Double)=new Currency("NZD",amount)
  def createCAD(amount:Double)=new Currency("CAD",amount)

}
class Currency (code:String,amount:Double){
  private val _code:String=code
  private val _amount:Double=amount

private val _inUSD:Double=getConstInUsd

  private def getConstInUsd:Double={
    _code match {
      case "USD" => _amount
      case "CAD" => conversionTable.getOrElse("CAD",0.0)*_amount
      case "NZD" => conversionTable.getOrElse("NZD",0.0)*_amount

    }
  }

  override def toString: String = s"Code : ${_code} Amount: ${_amount} In USD : ${_inUSD}"
}

object CurrencyRunner extends App{
  val usdOne=new Currency("USD",100.12)
  println(usdOne)

  val nzdOne =  Currency("NZD", 100.12)
  println(nzdOne)

  val cadOne = new Currency("CAD", 100.12)
  println(cadOne)

  import Currency._
  val nzdTwo =  createNZD( 100.12)
  println(nzdTwo)

}
