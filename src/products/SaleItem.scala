package products

abstract trait SaleItem extends Discount {
  val name: String
  val cost: BigDecimal
}

trait Discount {
  def getDiscount(count: Int, threshold: Int, discount: BigDecimal): BigDecimal = {
    (count / threshold) * -discount
  }

  def getBestDiscount(count: Int): (String, BigDecimal)
}