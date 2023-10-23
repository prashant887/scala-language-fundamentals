package methodsandfunctions

object GenericTypeParameters extends App {

  def pickRandomStocks(tickers:Seq[String]):String={
    val randomNumber=util.Random.nextInt(tickers.length)
    tickers(randomNumber)
  }

  def pickRandomQuantity(quantaties:Seq[Int]):Int={
    val randomNumber=util.Random.nextInt(quantaties.length)
    quantaties(randomNumber)

  }

  def pickRandomValue(values: Seq[Double]): Double = {
    val randomNumber = util.Random.nextInt(values.length)
    values(randomNumber)

  }

  val stock:String=pickRandomStocks(Vector("PS","TSLA","AAPL","FB"))
  val quantity:Int=pickRandomQuantity(List(10,200,1020,2040))
  val value:Double=pickRandomValue(List(10.0,20.0,30.0,40.0))

  println(s"Stock Select = $stock of $quantity Quanity for Price $value")


  def pickRandmom[T](values: Seq[T]): T = {
    val randomNumber = util.Random.nextInt(values.length)
    values(randomNumber)

  }

  val stockGeneric: String = pickRandmom(Vector("PS", "TSLA", "AAPL", "FB"))
  val quantityGeneric: Int = pickRandmom(List(10, 200, 1020, 2040))
  val valueGeneric: Double = pickRandmom(List(10.0, 20.0, 30.0, 40.0))

  println(s"Stock Select = $stockGeneric of $quantityGeneric Quanity for Price $valueGeneric")


}
