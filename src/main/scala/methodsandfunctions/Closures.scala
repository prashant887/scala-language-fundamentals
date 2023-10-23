package methodsandfunctions

object Closures extends App {

  case class StockRecord(
                          open_date: String,
                          open: Float,
                          high: Float,
                          low: Float,
                          close: Float,
                          adj_close: Float,
                          volume: Double
                        )

  //Generator

  def readFinanceData():Vector[StockRecord]= {
    val source = io.Source.fromFile("data/VMW.csv")
    for {
      line: String <- source.getLines().drop(1).toVector
      cols = line.split(",").map(x => x.trim)

    } yield StockRecord(
      cols(0), cols(1).toFloat,
      cols(2).toFloat, cols(3).toFloat,
      cols(4).toFloat, cols(5).toFloat,
      cols(6).toDouble
    )
  }

  val decisionMakerFunction=(records:Vector[StockRecord],date:String)=>{
    //Below 2 are closure variables
    val currDate:String=date
    val currRecords:Vector[StockRecord]=records

    val makeDecision=(percentDelta:Float)=>{

      /*
      val filteredRecords=currRecords.filter(x=>x.open_date==currDate)

      val record:StockRecord=filteredRecords.head

       */

      //Closures variables can also be variable passed to main function

      val filteredRecords = records.filter(x => x.open_date == date)

      val record: StockRecord = filteredRecords.head

      val percentageMove:Double=((record.close-record.open)/record.open)*100

      if (percentageMove>percentDelta){
        println(s"Buy Based on Date ${record.open_date} , Percentage Move ${percentageMove}")
      }else if(percentageMove< -percentDelta ){
        println(s"Sell Based on Date ${record.open_date} , Percentage Move ${percentageMove}")

      } else {
        println(s"No Call on Date ${record.open_date} , Percentage Move ${percentageMove}")

      }



    }
    makeDecision
  }
println("--------------")
  val decisionMakerOne=decisionMakerFunction(readFinanceData(),"2010-07-26")

  decisionMakerOne(1)


  val decisionMakerFunctionNoDate = (records: Vector[StockRecord]) => {
    //Below 2 are closure variables
    val currDate: String = date
    val currRecords: Vector[StockRecord] = records

    val makeDecision = (percentDelta: Float) => {

      /*
      val filteredRecords=currRecords.filter(x=>x.open_date==currDate)

      val record:StockRecord=filteredRecords.head

       */

      //Closures variables can also be variable passed to main function

      val filteredRecords = records.filter(x => x.open_date == date)

      val record: StockRecord = filteredRecords.head

      val percentageMove: Double = ((record.close - record.open) / record.open) * 100

      if (percentageMove > percentDelta) {
        println(s"Buy Based on Date ${record.open_date} , Percentage Move ${percentageMove}")
      } else if (percentageMove < -percentDelta) {
        println(s"Sell Based on Date ${record.open_date} , Percentage Move ${percentageMove}")

      } else {
        println(s"No Call on Date ${record.open_date} , Percentage Move ${percentageMove}")

      }


    }
    makeDecision
  }

  val date:String="2020-04-01"

  val decisionMakerOneNoDate = decisionMakerFunctionNoDate(readFinanceData())

  decisionMakerOneNoDate(1)
}
