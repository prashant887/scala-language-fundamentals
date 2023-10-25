package classesandobjects

import java.util.UUID


class CustomerTrait(first:String,last:String,email:String) {

  private val _id:UUID=UUID.randomUUID()
  private val _first:String=first
  private val _last:String=last
  private val _email:String=email

  def getId:UUID=_id
  def getFirst:String=_first
  def getLast:String=_last
  def getEmail:String=_email


}

trait Address{
  protected var _zip:Int
  protected var _street:String
  protected var _state:String

  //abstract methods
  def setZip(zip:Int):Unit
  def setStreet(street:String):Unit
  def setState(state:String):Unit
  def printAddress():String=s"Address Zip : ${_zip} Street: ${_street} State: ${_state}"

}

trait SecreteCodeGenerator{
  def getOpt:String=UUID.randomUUID().toString
}

//Can extend one class and multiple traits
class CustomersWithAddress(first:String,last:String,email:String)
  extends CustomerTrait(first, last, email)
    with Address
    with SecreteCodeGenerator
    {

  override protected var _zip: Int = -1
  override protected var _street: String = ""
  override protected var _state: String = ""
  override def setZip(zip: Int): Unit = _zip=zip

  override def setStreet(street: String): Unit = _street=street

  override def setState(state: String): Unit = _state=state

}

class DepositContainer extends SecreteCodeGenerator
object RunTrait extends App {
val c1=new CustomersWithAddress("Tony","Stark","tonystark@avengers.com")
c1.setZip(343432)
  c1.setStreet("Bull Street")
  c1.setState("NY")
println(c1.getId,c1.getFirst,c1.getLast)
  println(c1.printAddress())
println(c1.getOpt)
  
  println()
  val c2=new DepositContainer
  println(c2.getOpt)
}
