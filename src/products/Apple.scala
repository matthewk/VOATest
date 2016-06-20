package products

sealed trait Apple extends SaleItem {
  val cost: BigDecimal = 0.60
  val name: String = "Apple"
}

object Apple extends Apple {
  def getBestDiscount(count: Int): (String, BigDecimal) = {
    val discounts: Map[String, BigDecimal] = Map(
      "Two for one discount" -> twoForOne(count)
    )
    discounts.minBy(_._2)
  }

  def twoForOne(count: Int) = getDiscount(count, 2, cost)
}