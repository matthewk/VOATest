package products

sealed trait Orange extends SaleItem {
  val cost: BigDecimal = 0.25
  val name: String = "Orange"
}

object Orange extends Orange {
  def getBestDiscount(count: Int): (String, BigDecimal) = {
    val discounts: Map[String, BigDecimal] = Map(
      "Three for two discount" -> threeForTwo(count)
    )
    discounts.minBy(_._2)
  }

  def threeForTwo(count: Int) = getDiscount(count, 3, cost)
}