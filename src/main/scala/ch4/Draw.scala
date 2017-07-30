package ch4

import ch4.Colour._
import ch4.Shapes._


object Draw{
  def apply(s: Shape): String = s match {
    case Rectangle(w, h, c) => s"A ${Draw(c)} rectangle with width ${w}cm and height ${h}cm of colour ${c}"
    case Square(side, c) => s"a ${Draw(c)} square with side size ${side}cm of colour ${c}"
    case Circle(r, c) => s"a ${Draw(c)} circle with radius ${r}cm of colour ${c}"
  }

  def apply(c: Colour): String = c match {
    case Red => "red"
    case Yellow => "yellow"
    case Pink => "pink"
    case colour => if(colour.isLight) "light" else "dark"

  }
}