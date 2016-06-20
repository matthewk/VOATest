package products

sealed trait Peanuts extends SaleItem {
  val cost: BigDecimal = 1.30
  val name: String = "Salty peanuts"
}

object Peanuts extends Peanuts {
  def getBestDiscount(count: Int): (String, BigDecimal) = {
    val discounts: Map[String, BigDecimal] = Map(
      "25% off" -> twentyFivePercent(count)
    )
    discounts.minBy(_._2)
  }

  def twentyFivePercent(count: Int) = getDiscount(count, 1, cost * 0.25)
}