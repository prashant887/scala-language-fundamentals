package packagesandimporting.entities

/*
Since Transaction and User are in same Package no need to import User
 */
case class Transaction(val user: User){
  val userId:String=User("Tony","Stark").getId

}
