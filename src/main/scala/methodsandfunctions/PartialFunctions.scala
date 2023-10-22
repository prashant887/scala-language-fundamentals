package methodsandfunctions

object PartialFunctions extends App {

  val divideBy=new PartialFunction[(Int,Int),Int]{
    override def isDefinedAt(x: (Int, Int)): Boolean = {
      x._2!=0
    }

    override def apply(v1: (Int, Int)): Int = {
      v1._1/v1._2
    }
  }

  println("Defined at 8: "+divideBy.isDefinedAt((64,8)))
  println("Defined at 0: "+divideBy.isDefinedAt((64,0)))

  println("Divide by 4 :"+(if (divideBy.isDefinedAt(64,4))divideBy((64,4))))

  val divideByCase: PartialFunction[(Int,Int),Int] = {
    case x:(Int, Int) if  x._2 != 0=> x._1/x._2
  }

  println("Defined CASE at 8: " + divideByCase.isDefinedAt((64, 8)))
  println("Defined Case at 0: " + divideByCase.isDefinedAt((64, 0)))

  println("Divide Case by 4 :" + (if (divideByCase.isDefinedAt(64, 4)) divideByCase((64, 4))))

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

  val data = readFinanceData().toList

  /*

  val printStockRecords:PartialFunction[String,Unit]={
    case ticker:String if (List("MSFT","GOOG","TTM","TM","DB","BNS").contains(ticker))=>
      for(lines <- data.filter(x=>x.ticker==ticker)){

      }


  }

   */
  val printStockRecords:PartialFunction[String,Unit]=new PartialFunction[String,Unit] {
    val tickerList:List[String]=List("MSFT","GOOG","TTM","TM","DB","BNS");

    override def isDefinedAt(ticker: String): Boolean = {
      tickerList.contains(ticker)
    }

    override def apply(ticker: String): Unit = {
      for (lines <- data.filter(x => x.ticker == ticker)) {
        println(s"Date ${lines.date} Ticker: ${lines.ticker} Close: ${lines.close}")
      }
    }
  }
if (printStockRecords.isDefinedAt("MSFT") ) printStockRecords("MSFT")

  //map collect implements isDefined
  List("DB","GM") map(printStockRecords)
  List("TTM","GM") collect (printStockRecords)


  val printMotorStocks:PartialFunction[String,Unit]=new PartialFunction[String,Unit] {
    override def isDefinedAt(ticker: String): Boolean = {
      ticker=="TM" || ticker=="TTM"
    }

    override def apply(ticker: String): Unit = {
      for (lines <- data.filter(x => x.ticker == ticker)) {
        println(s"Date ${lines.date} Ticker: ${lines.ticker} Close: ${lines.close}")
      }
    }
  }

  val printTechStocks: PartialFunction[String, Unit] = new PartialFunction[String, Unit] {
    override def isDefinedAt(ticker: String): Boolean = {
      ticker == "GOOG" || ticker == "MSFT"
    }

    override def apply(ticker: String): Unit = {
      for (lines <- data.filter(x => x.ticker == ticker)) {
        println(s"Date ${lines.date} Ticker: ${lines.ticker} Close: ${lines.close}")
      }
    }
  }

  //Combine partial functions
  val printTechOrMotor=printTechStocks orElse printMotorStocks

  printTechOrMotor("MSFT")
  printTechOrMotor("TM")
}
