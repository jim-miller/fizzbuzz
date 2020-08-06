object FizzBuzz {

  val FizzBuzzes =
    LazyList
      .from(0)
      .map(n =>
        (n % 3 == 0, n % 5 == 0) match {
          case (true, true) => FizzBuzz
          case (true, _)    => Fizz
          case (_, true)    => Buzz
          case _            => FbNumber(n)
        }
      )

  sealed trait FbReturn extends Product with Serializable
  final case object Fizz extends FbReturn
  final case object Buzz extends FbReturn
  final case object FizzBuzz extends FbReturn
  final case class FbNumber(n: Int) extends FbReturn {
    override def toString = n.toString
  }

}
