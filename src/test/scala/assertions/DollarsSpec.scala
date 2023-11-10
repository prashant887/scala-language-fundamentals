package assertions

import org.scalatest.flatspec.AnyFlatSpec
import unittests.Dollars

class DollarsSpec extends AnyFlatSpec{
behavior of "A Dollar"
  it should "create a correct Dollar object for number 10 as input" in {
    val tenDollar=Dollars(10)

    assert("$10"==tenDollar.toString)
  }

  it should "correctly identify that $10 > $5" in {
    val tenDollar=Dollars(10)
    val fiveDollar=Dollars(5)

    assert(tenDollar>fiveDollar)

  }

  it should "correctly add two Dollar Amount" in {
    val tenDollar = Dollars(10)
    val fiveDollar = Dollars(5)

    assertResult("$15","Expected $15 Value"){
      (tenDollar+fiveDollar).toString
    }

  }

  it should "correctly identify $4=$4" in {
    val fiveDollar = Dollars(5)

    assertResult(true) {
     fiveDollar===fiveDollar
    }

  }

  it should "throw an exception Invalid Integer" in {
    assertThrows[ArithmeticException]{

      Dollars(10/0)
    }
  }

  it should "have every amount greater then 0" in {
    val dollars:List[Dollars]=List.empty

    assume(dollars.nonEmpty)
    dollars.foreach(d=>
      assert(d.amount>0)
    )
  }
}
