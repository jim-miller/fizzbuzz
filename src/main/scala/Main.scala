import FizzBuzz._

object Main extends App {

  // print numbers from 1 to 100 and replace all multiples of 3 with Fizz,
  // multiples of 5 with Buzz, and multiples of both 3 and 5 with FizzBuzz

  (1 to 100).map(FizzBuzzes).foreach(println)
  FizzBuzzes.take(100).foreach(println)
}
