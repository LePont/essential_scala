package ch4

object ADTSamples {

  //SUM TYPE IS A OR
  // Pattern Match
  sealed trait TrafficLight {
    def next(): TrafficLight =
      this match {
        case Red => Green
        case Yellow => Red
        case Green => Yellow
      }
  }
  final case object Red extends TrafficLight
  final case object Yellow extends TrafficLight
  final case object Green extends TrafficLight

  /*
  polymorphism

  sealed trait TrafficLight {
    def next()
  }
  final case object Red extends TrafficLight {
    override def next() = {
      Green
    }
  }
  final case object Yellow extends TrafficLight{
    override def next() = {
      Red
    }
  }
  final case object Green extends TrafficLight {
    override def next: Unit ={
      Yellow
    }
  }
  */

  sealed trait Source
  final case object well extends Source
  final case object spring extends Source
  final case object tap extends Source

  // PRODUCT TYPE HAS A AND
  case class BottleWater(size: Int, source: Source, carbonated: Boolean)

}
