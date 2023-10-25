package packagesandimporting.entities

/*
private[package] Gives access to subclass under same package
 */
case class User(val first:String,val last:String)
{
  private[entities] def getId:String = ???
}