import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatest.Inspectors.forAll

class FizzBuzzSpec extends AnyFlatSpec with Matchers {
  import FizzBuzz._

  val testNumbers = 0 to 10000
  val multiplesOf3 = (n: Int) => n % 3 == 0
  val multiplesOf5 = (n: Int) => n % 5 == 0

  "FizzBuzz" should "return Fizz for multiples of 3" in {
    forAll(testNumbers.filter(multiplesOf3).filterNot(multiplesOf5)) {
      FizzBuzzes(_) should be(Fizz)
    }
  }

  "FizzBuzz" should "return Buzz for multiples of 5" in {
    forAll(testNumbers.filter(multiplesOf5).filterNot(multiplesOf3)) {
      FizzBuzzes(_) should be(Buzz)
    }
  }

  "FizzBuzz" should "return FizzBuzz for multiples of both 3 and 5" in {
    forAll(testNumbers.filter(n => multiplesOf3(n) && multiplesOf5(n))) {
      FizzBuzzes(_) should be(FizzBuzz)
    }
  }

  "FizzBuzz" should "return a number for non-multiples of 3 or 5" in {
    forAll(testNumbers.filterNot(n => multiplesOf3(n) || multiplesOf5(n))) {
      n => FizzBuzzes(n) should be(FbNumber(n))
    }
  }
}
