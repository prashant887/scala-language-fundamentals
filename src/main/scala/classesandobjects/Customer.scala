package classesandobjects

import java.util.UUID

//Adding FInal on class will not let this class to be extended
final class Customer(first:String,last:String,email:String) {

  private val _id:UUID=UUID.randomUUID()
  private val _first:String=first
  private val _last:String=last
  private val _email:String=email

  def getId:UUID=_id
  def getFirst:String=_first
  def getLast:String=_last
  def getEmail:String=_email


}

object EmailRunner extends App {
  val c1=new Customer("tony","stark","tonystark@avengers.com")
  println(c1.getId,c1.getFirst,c1.getLast,c1.getEmail)
}