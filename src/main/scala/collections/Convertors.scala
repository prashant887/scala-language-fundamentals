package collections
import scala.jdk.CollectionConverters._
object Convertors extends App {

def validate(number:String):Boolean = {
  val total:Int=number
    .map(x=>x.asDigit)
    .reverse
    .zipWithIndex
    .map {case (x,y)=> if (x%2==0 ) y else y*2}
    .flatMap(number=>List(number/10,number%10))
    .sum

  total%10==0
}
  println(validate("1234567"))

}
