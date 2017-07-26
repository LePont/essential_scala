package ch3

case class Film(name: String, yearOfRelease: Int, imdbRating: Double, director: Director){

  def directorsAge(): Int ={
    yearOfRelease - director.yob
  }

  def isDirectedBy(dir: Director): Boolean = {
    director.name() == dir.name()
  }
}

object Film{

  def highestRating(film: Film,film2: Film):Film = {
    if (film.imdbRating > film2.imdbRating) film else film2
  }

  def oldestDirectorAtTime(film1: Film, film2: Film): Director={
    if(film1.directorsAge() > film2.directorsAge()) film1.director else film2.director

  }

}