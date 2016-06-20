import products._

object TestFruit {
  def main(args: Array[String]) {
    val items = List(Apple, Apple, Orange, Apple, Orange, Orange, Peanuts, Peanuts)
    val cart = Cart(items)
    Cart.printReceipt(cart.subTotal)
  }
}