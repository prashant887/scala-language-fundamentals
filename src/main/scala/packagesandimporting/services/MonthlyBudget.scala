package packagesandimporting.services

import packagesandimporting.entities.{Budget, Transaction, User} //User=>_ User is not avilable for access

/*
Classes in different packge needs to be imported
 */
case class MonthlyBudget(val budget: Budget,val ts:Array[Transaction]) {
  //val userId:String=User("Tony","Stark")
}
