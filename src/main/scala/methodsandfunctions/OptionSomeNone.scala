package methodsandfunctions

object OptionSomeNone extends App {

  def convertToFloat(value:String):Option[Double]={
    try {
      Some(value.toDouble)
    }catch {
      case e:Exception=>None
    }
  }

  val googlePrices:Vector[String]=Vector("123.45","130.66","abcd","452.34","781.34","xsd")

  googlePrices.map(x=>{
    val rnt=convertToFloat(x)
    rnt match {
      case Some(x)=>println(s"Double Value $x")
      case None=>"No Value"
    }
  })

  println("\n")
  googlePrices.map(x=>println(s"Return Value ${convertToFloat(x).getOrElse(0)}"))
  println("\n")

  val googlePriceDouble:Vector[Double]=googlePrices.flatMap(x=>convertToFloat(x))

  println(s"Average : ${googlePriceDouble.sum/googlePriceDouble.size}")
}
