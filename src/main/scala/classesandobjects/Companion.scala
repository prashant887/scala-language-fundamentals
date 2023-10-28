package classesandobjects

import java.util.UUID

/*
Define all instance variables and metods in Class
Static methods and objs in Object
Scala dosnt allow static methods to be created in class
Class and obj can access private methods
 */

class Graph private(path:String) {
  println(s"Loading from $path")
   def  numEdge:Int=500
  private  def numVertices:Int=300

  def persist(storageLevel:Int):Unit={
    println(s"Storage Level $storageLevel")
  }

  def apply(string: String ):Unit={
    println(s"Apply Method $string and $path")
  }

  //def getId:String=id


}
object Graph  {

  val DISK_ONLY=0
  val MEM=1

  val g=new Graph("id")
 // g.id=UUID.randomUUID().toString //Accessing Private Memeber

  def getVertices:Int=g.numVertices //Private Method
  def apply(path:String)=new Graph(path)



}

object Companion extends App {
  /*
  Cant create Instance of a class outside by making class private
  val cmp: Graph = new Graph("/abc")
  cmp("param")
  cmp.persist(Graph.MEM)

   */

  //by using apply in Graph object can elemenate new
  val cmpTwo: Graph =  Graph("/xyz")
  cmpTwo("param")
  cmpTwo.persist(Graph.DISK_ONLY)

  println(cmpTwo.numEdge) //Here class method is accessed as static
  //println("ID "+cmpTwo.getId)
}