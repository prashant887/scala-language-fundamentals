package methodsandfunctions

object Currying extends App {

  case class StockRecord(date: String,
                         open: Float,
                         high: Float,
                         low: Float,
                         close: Float,
                         ticker: String)

  val readFinanceData = () => {
    val source = io.Source.fromFile("data/stockMarketData.csv")
    for {
      line <- source.getLines().drop(1).toVector
      cols = line.split(",").map(_.trim)
    } yield StockRecord(cols(0), cols(1).toFloat,
      cols(2).toFloat, cols(3).toFloat,
      cols(4).toFloat, cols(5))
  }

  val records=readFinanceData()

  def getPrice(date:String,tricker:String,priceType:String):Float={
    val recordsByDate=records.filter(x=>x.date==date)
    val recordsbyTicker=recordsByDate.filter(x=>x.ticker==tricker)

    val price=priceType match {
      case "open" => recordsbyTicker(0).open
      case "close" => recordsbyTicker(0).close
      case "high" => recordsbyTicker(0).high
      case "low" => recordsbyTicker(0).low

    }
    price
  }

  println(getPrice(date = "12-06-2020",tricker = "GOOG",priceType = "high"))

  def getPriceCurry(date:String,tricker:String)(priceType:String): Float = {
    val recordsByDate = records.filter(x => x.date == date)
    val recordsbyTicker = recordsByDate.filter(x => x.ticker == tricker)

    val price = priceType match {
      case "open" => recordsbyTicker(0).open
      case "close" => recordsbyTicker(0).close
      case "high" => recordsbyTicker(0).high
      case "low" => recordsbyTicker(0).low

    }
    price
  }
  println(getPriceCurry(date = "12-06-2020",tricker = "GOOG")(priceType = "high"))

  //Currying allows partaially applied fuction

  val getPriceGoogle=getPriceCurry(date = "12-06-2020",tricker = "GOOG") _

  println("GOOGLE")
 println(" OPEN "+getPriceGoogle("open"))
  println(" CLOSE "+getPriceGoogle("close"))
  println(" HIGH "+getPriceGoogle("high"))
  println(" LOW "+getPriceGoogle("low"))

  def getPriceCurryMulti(date: String)( tricker: String)(priceType: String): Float = {
    val recordsByDate = records.filter(x => x.date == date)
    val recordsbyTicker = recordsByDate.filter(x => x.ticker == tricker)

    val price = priceType match {
      case "open" => recordsbyTicker(0).open
      case "close" => recordsbyTicker(0).close
      case "high" => recordsbyTicker(0).high
      case "low" => recordsbyTicker(0).low

    }
    price
  }
  println(getPriceCurryMulti(date = "12-06-2020")(tricker = "GOOG")(priceType = "high"))

  val getPriceForDate=getPriceCurryMulti(date = "12-06-2020") _ //Holds Multiple Value

  println("\n DB")

  println(" OPEN " + getPriceForDate("DB")("open"))
  println(" CLOSE " + getPriceForDate("DB")("close"))
  println(" HIGH " + getPriceForDate("DB")("high"))
  println(" LOW " + getPriceForDate("DB")("low"))

  val getPriceForDateTicker=getPriceCurryMulti(date = "12-06-2020")(tricker = "TM") _ //Holds Single Value

  println("\n TM")

  println(" OPEN " + getPriceForDateTicker("open"))
  println(" CLOSE " + getPriceForDateTicker("close"))
  println(" HIGH " + getPriceForDateTicker("high"))
  println(" LOW " + getPriceForDateTicker("low"))

  def logger(level:String)(message:String): Unit = {
    level match {
      case "info" => println(s"INFO:$message")
      case "debug" => println(s"DEBUG:$message")
      case "error" => println(s"ERROR:$message")

    }
  }

    val errorMessage=logger("error")_
    val infoMessage=logger("info")_
    val debugMessage=logger("debug")_

    println("\n")

    errorMessage("Nll Pointer Exception")
    infoMessage("Process Started")
    debugMessage("Debugging Here")


}
