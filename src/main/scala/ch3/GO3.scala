package ch3

object GO3 extends App{

  val c1 = Cat("q","red","chips")
  val c2 = Cat("q2","blue","chips")
  val c3 = Cat("q3","redfd","fish")

  println(ChipShop.willServe(c1))


  val eastwood              = new Director("Clint", "Eastwood", 1930)
  val mcTiernan             = new Director("John", "McTiernan", 1951)
  val nolan                 = new Director("Christopher", "Nolan", 1970)
  val someBody              = new Director("Just", "Some Body", 1990)
  val memento               = new Film("Memento", 2000, 8.5, nolan)
  val darkKnight            = new Film("Dark Knight", 2008, 9.0, nolan)
  val inception             = new Film("Inception", 2010, 8.8, nolan)
  val highPlainsDrifter     = new Film("High Plains Drifter", 1973, 7.7, eastwood)
  val outlawJoseyWales      = new Film("The Outlaw Josey Wales", 1976, 7.9, eastwood)
  val unforgiven            = new Film("Unforgiven", 1992, 8.3, eastwood)
  val granTorino            = new Film("Gran Torino", 2008, 8.2, eastwood)
  val invictus              = new Film("Invictus", 2009, 7.4, eastwood)
  val predator              = new Film("Predator", 1987, 7.9, mcTiernan)


  println(eastwood.yob)
  println(granTorino.director.name)
  println(invictus.isDirectedBy(nolan))

  val c = Counter(10).inc(12).dec().inc().dec().count
  println(c)

  val p = Person("my name")
  val p3 = Person("sfvf","sfsdfv")

  println(Dad.rate(unforgiven))

}
