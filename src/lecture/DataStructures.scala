package lecture

object DataStructures {
  def maxMultiply(input: List[Int]): Int = {
    if (input.isEmpty) {
      -1
    } else if (input.length == 1) {
      // round to avoid truncation errors
      Math.round(Math.pow(input.head, 2)).toInt
    } else {
      var maxFound = input.head * input.apply(1)
      var ix = 0
      var iy = 0
      for (x <- input) {
        iy = 0
        for (y <- input) {
          if (iy != ix) {
            if (x * y > maxFound) {
              maxFound = x * y
            }
          }
          iy += 1
        }
        ix += 1
      }
      maxFound
    }
  }
}
