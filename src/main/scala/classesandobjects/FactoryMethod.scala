package classesandobjects
/*
Provies Common Method for all classes impliemntation

 */

abstract class Room {
  def bookingPrice:Double
  def availability:Int
}
object Room  {//Compaion Object
val STANDARD:Int=0
  val DELUX:Int=1
  val SUPER_DELUX:Int=2

  private class standardRoom extends Room {
    override def bookingPrice: Double = 70

    override def availability: Int = 20
  }

  private class deluxRoom extends Room {
    override def bookingPrice: Double = 90

    override def availability: Int = 10
  }

  private class superRoom extends Room {
    override def bookingPrice: Double = 100

    override def availability: Int = 5
  }

  def apply(roomType:Int):Room={
    roomType match {
      case STANDARD => new standardRoom()
      case SUPER_DELUX => new superRoom()
      case DELUX => new deluxRoom()
    }
  }
}
object FactoryMethod extends App {
  val room:Room=Room(Room.DELUX)
  println(s" ${room.availability} ${room.bookingPrice}")
}
