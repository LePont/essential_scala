package ch3

case class Counter(count: Int = 0){

  def inc(i: Int =1): Counter ={
    copy(count+i)
  }

  def dec(i: Int =1): Counter ={
    copy(count-i)
  }

  def adjust(adder: Adder): Counter= {
    copy(adder(count))
  }
}
