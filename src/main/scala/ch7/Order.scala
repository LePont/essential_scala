package ch7

final case class Order(units: Int, unitPrice: Double) {
  val totalPrice: Double = units * unitPrice
}

object Order {
  implicit val priceOrd: Ordering[Order] = Ordering.fromLessThan[Order]((x, y) => x.totalPrice > y.totalPrice)
}

object UnitPriceOrdering{
  implicit val unitPriceOrd = Ordering.fromLessThan[Order]((x, y) => x.unitPrice > y.unitPrice)
}

object UnitOrdering {
  implicit val unitOrd = Ordering.fromLessThan[Order]((x, y) => x.units > y.units)
}