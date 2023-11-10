package methodsandfunctions

import java.io.{FileNotFoundException, IOException}
import scala.annotation.tailrec
import scala.io.{BufferedSource, Source, StdIn}
import scala.util.{Failure, Success, Try}


object TrySuccessFailure extends App {

    def getLinesFromFile(file:String):Try[BufferedSource]={
        Try(Source.fromFile(file))
    }

    val sourcePath:Try[BufferedSource]=getLinesFromFile("data/dividendStocks.csv")


    sourcePath match {
        case Success(value)=>value.getLines().toVector.foreach(x=>println(x))
        case Failure(exception)=>println(exception.getMessage)
    }

    case class DividendRecord(date: String,
                              ticker: String,
                              dividend: Float,
                              face_value: Float)

    def readCsvFile(filePath:String):Seq[DividendRecord]={
        val source=io.Source.fromFile(filePath)
        for {
            line <- source.getLines().drop(1).toVector
            cols = line.split(",").map(_.trim)
        } yield DividendRecord(cols(0), cols(1), cols(2).toFloat, cols(3).toFloat) // todo: Java's yield is not supported

    }

    val records = readCsvFile("data/dividendStocks.csv")

    @tailrec
    def calculateDividendYield(): Try[Double] = {
        val ticker = StdIn.readLine("Enter ticker: ")
        val currentPrice = Try(StdIn.readLine("Enter current price: ").toDouble)

        val faceValue: Try[Double] = Try(
            records.filter(_.ticker == ticker).map(_.face_value).head.toDouble)
        val dividendRate: Try[Double] = Try(
            records.filter(_.ticker == ticker).map(_.dividend).head * 0.01)

        val dividendPerShare: Try[Double] = faceValue.flatMap(
            fv => dividendRate.map(divRate => fv * divRate))
        val dividendYield: Try[Double] = dividendPerShare.flatMap(
            divPerShare => currentPrice.map(currPrice => divPerShare / currPrice * 100))

        dividendYield match {

            case Success(divYield) =>
                println(s"Dividend yield of $ticker is: ${divYield}%")
                Success(divYield)

            case Failure(exception) =>
                println("----" + exception.getMessage)

                println("An error occurred along the way, try again!")
                calculateDividendYield()
        }
    }

    calculateDividendYield()


}
