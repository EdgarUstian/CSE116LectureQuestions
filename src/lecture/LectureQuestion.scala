package lecture
import scala.io.{BufferedSource, Source}

object LectureQuestion {
  def fileSum (filename: String): Int = {
    var sum: Int = 0
  val file: BufferedSource = Source.fromFile(filename)
    for (line <- file.getLines()){
      val splits: Array[String] = line.split("#")
      for (value <- splits){
        var valueAsInt: Int = value.toInt
        sum += valueAsInt
      }
    }
    sum
  }
}
