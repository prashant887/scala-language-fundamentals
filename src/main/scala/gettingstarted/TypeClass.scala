package gettingstarted

object TypeClass {
  trait Combiner[T]{
    def combine(a:T,b:T):T
  }

  /*
  Create Companion Object
   */
  object Combiner{
    implicit val intConsumer:Combiner[Int]=new Combiner[Int] {
      override def combine(a: Int, b: Int): Int = a+b
    }

    implicit val stringConsumer:Combiner[String]=(a:String,b:String)=>s"$a $b"

    implicit def listCombiner[T]:Combiner[List[T]]=(a:List[T],b:List[T])=>a++b
  }

  object CombinerOps {
    //Interface Method
    def combine[T](a:T,b:T)(implicit ev:Combiner[T]):T=ev.combine(a, b)
  }
  def main(args: Array[String]): Unit = {
    import CombinerOps.combine

    val intCombined=combine(1,3)
    val stringCombined=combine("Hello","World")
    val listCombined=combine(List(1,2,3),List(7,8,9))

    println(intCombined)
    println(stringCombined)
    println(listCombined)
  }

}
