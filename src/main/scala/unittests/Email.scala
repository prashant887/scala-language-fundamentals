package unittests

object Email{
  def apply(value:String):Email={
    val string:Array[String]=value.split("@")
    if (string.length<2){
      throw new IllegalArgumentException("invalid email: does not contain '@' symbol")
    }
    if (string.length>2){
      throw new IllegalArgumentException("invalid email: should not contain '@' symbol more then once")
    }
    new Email(string(0),string(1))
  }
}
class Email(val localPart:String,val domain:String) {
  override def toString: String = s"$localPart@$domain"

}
