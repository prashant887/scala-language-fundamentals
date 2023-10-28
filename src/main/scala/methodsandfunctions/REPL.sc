
val stockPrice:Int=14
lazy val volume={println("Lazy Assignment")
100}
println("Calculate Final price")
val findValue:Int=stockPrice*volume
println(s"Final Price $findValue")

lazy val data:Array[String]={
  println("Initilize Array")
  Array("MS","APPL")
}

println("Before Accessing Array")
data.foreach(println)

println("------------------")
data.foreach(println)

/*

 */
def getNumRowsMethod:Int=data.length

val getNumRowsFunction=()=>data.length //assign fun to variable
//THis can also be written as
/*
val applyGetNumRows=new Function1[Array[String],Int] {
  override def apply(data: Array[String]): Int = data.length
}
println("Total Number of Rows (apply): ",applyGetNumRows(data))

*/


println("Total Number of Rows (method): ",getNumRowsMethod)

println("Total Number of Rows (function): ",getNumRowsFunction())



println("Class of Function :",getNumRowsFunction.getClass)
println("Class of Method :",getNumRowsMethod.getClass)

println("Total Number of Rows (apply): ",getNumRowsFunction.apply())

//Mthods can be called without () , functions cannot be

println("Function Instance O: ",getNumRowsFunction.isInstanceOf[Function0[_]])

println("Done")

def exitsMethod(ticker:String):Boolean=data.contains(ticker)

val existFunction=(ticker:String)=>data.contains(ticker)

println("Exist Method "+exitsMethod("APP"))
println("Exist Function "+existFunction("APP"))

val myList:List[String]=List("Spark","mimics","Scala","collections")

val flatMapped:List[String]=myList.flatMap(s=>{
  println(s)
  val filters=List("mimics","collections")
  if (filters.contains(s)){
    None
  }
  else {
    Some(s)
  }
})

println(flatMapped)
//FLatMap filters None at its own , flatmap unboxes elements explodes/shrinks values