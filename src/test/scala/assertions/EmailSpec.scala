package assertions

import org.scalatest.flatspec.AnyFlatSpec
import unittests.Email

class EmailSpec extends AnyFlatSpec{

  behavior of "An Email"
  it should "return an Email object for a valid String" in {
    val email=Email("prashant887@gmail.com")
    assert(email.localPart==="prashant887")
    assert(email.domain==="gmail.com")

  }

  it should "Intercept Correct Error Message " in {
    val exception=intercept[IllegalArgumentException] { Email("google.com")}
    assert(exception.isInstanceOf[IllegalArgumentException])
    assert(exception.getMessage.contains("does not contain '@'"))
  }

}
