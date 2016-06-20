import products.SaleItem

case class Cart(items: List[SaleItem]) {
  def subTotal: Map[SaleItem, List[(String, BigDecimal)]] = {
    val groupedItems = items.groupBy(si => si).map {
      case (k, v) => (k, v.map(f => (f.name, f.cost)))
    }

    groupedItems map {
      case (k, v) => (k, v ++ List(k.getBestDiscount(v.size)))
    }
  }
}

object Cart {
  def getBestDiscountForItem(item: SaleItem, count: Int) = {
    item.getBestDiscount(count)
  }

  def printReceipt(items: Map[SaleItem, List[(String, BigDecimal)]]): Unit = {

    val printList = items.values.flatten

    val maxItem = printList.toList.sortBy(-_._1.length).head._1.length

    val total = items.map {
      case (k, v) => v.map(_._2).sum
    }.sum

    items.foreach(i => i._2.foreach(printReceiptItem(maxItem, _)))
    printReceiptTotal(maxItem, total)
  }

  def printReceiptTotal(maxItem: Int, total: BigDecimal): Unit = {
    println(List.fill(maxItem + 10)("=").mkString)
    println("Total" + List.fill(maxItem - 5)(" ").mkString + " ->  £" + total)
  }

  def printReceiptItem(descriptionColSize: Int, item: (String, BigDecimal)) = {
    val spaces = List.fill(descriptionColSize - item._1.length)(" ").mkString
    //    if (item._2 < 0) println(List.fill(descriptionColSize + 10)("-").mkString)
    println(item._1 + spaces + " -> " + (if (item._2 > 0) " £" else "-£") + item._2.abs)
    if (item._2 < 0) println(List.fill(descriptionColSize + 10)("-").mkString)
  }

}
