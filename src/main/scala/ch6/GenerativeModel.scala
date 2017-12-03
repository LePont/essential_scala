package ch6

object GenerativeModel {

  def allCombos(names: List[String], verbs: List[String], objects: List[String]) = {
    for {
      a <- names
      b <- verbs
      c <- objects
    } yield (a, b, c)
  }

  def verbPicker(name :String): List[String] = {
    name match {
      case "Noel" => List("wrote","chased","slepton")
      case "Thecat" => List("meowed at","chased","slepton")
      case "Thedog" => List("barked at","chased","slepton")
    }
  }

  def objectPicker(verb: String): List[String] = {
    verb match {
      case "wrote" => List("The book", "The letter", "The Code")
      case "chased" => List("The ball", "the dog", "the cat")
      case "slepton" => List("the bed", "the mat", "the train")
      case "meowed at" => List("Noel", "the door", "the cupboard")
      case "barked at" => List("the post man ", "the car", "the cat")
    }
  }

  def refinedCombos(names: List[String]) = {
    for {
      a <- names
      b <- verbPicker(a)
      c <- objectPicker(b)
    } yield (a, b, c)
  }

  final case class Distribution[A](ev: List[(A, Double)]) {

    def map[B](f: A => B): Distribution[B] = {
      Distribution(ev.map { case (a, b) => (f(a), b) })
    }

    def flatMap[B](f: A => Distribution[B]): Distribution[B] = {
      Distribution(ev.flatMap{case (a, p1) =>
        f(a).ev map {case (b, p2) => (b, (p1 *p2))}
        }).compact.normalize
    }

    def normalize: Distribution[A] = {
      val totalWeight = (ev map { case (a, p) => p }).sum
      Distribution(ev map { case (a, p) => a -> (p / totalWeight) })
    }

    def compact: Distribution[A] = {
      val distinct = (ev map { case (a, p) => a }).distinct

      def prob(a: A): Double =
        (ev filter { case (x, p) => x == a } map { case (a, p) => p }).sum

      Distribution(distinct map { a => a -> prob(a) })
    }
  }

  object Distribution {

    def uniform[A](e: List[A]): Distribution[A] = {
      val probability = 1.0/e.length
      Distribution(e.map(x => (x, probability)))
    }

    def discrete[A](ev: List[(A,Double)]): Distribution[A] = Distribution(ev).compact.normalize
  }

}
