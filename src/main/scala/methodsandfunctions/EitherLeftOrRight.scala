package methodsandfunctions

import methodsandfunctions.OptionSomeNone.convertToFloat

object EitherLeftOrRight extends App {

  def convertToFloat(value: String): Either[String,Double] = {
    try {
      Right(value.toDouble)
    } catch {
      case e: Exception => Left(s"Error Encountered :${e.getMessage}")
    }
  }

  def convertToFloatDefault(value: String): Either[Double, Double] = {
    try {
      Right(value.toDouble)
    } catch {
      case e: Exception => Left(-1)
    }
  }

  val googlePrices: Vector[String] = Vector("123.45", "130.66", "abcd", "452.34", "781.34", "xsd")

  googlePrices.foreach(x => {
    val rnt = convertToFloat(x)
    rnt match {
      case Right(x) => println(s"Double Value $x")
      case Left(message) => println(message)
    }
  })

  println("\n")

  googlePrices.map(x => {
    val rnt = convertToFloatDefault(x)
    rnt match {
      case Right(x) => println(s"Double Value $x")
      case Left(message) => println(message)
    }
  })
}
