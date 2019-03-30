package words

object RhymingDictionary {

  def isVowel(sound: String): Boolean = {
    sound.length == 3
  }

  def stripVowel(sound: String): String = {
    sound.replace("0", "").replace("1", "").replace("2", "")
  }

  def isRhymeSounds(sounds1: List[String], sounds2: List[String]): Boolean = {
    var p1: Int = sounds1.length - 1
    var p2: Int = sounds2.length - 1

    while (p1 >= 0 && p2 >= 0) {
      val s1 = sounds1.apply(p1)
      val s2 = sounds2.apply(p2)
      if (s1 != s2) {
        if (isVowel(s1) && isVowel(s2)) {
          if (stripVowel(s1) == stripVowel(s2)) {
            return true
          }else{
            return false
          }
        } else {
          return false
        }
      } else {
        if (isVowel(s1) && isVowel(s2)) {
          return true
        }
      }
      p1 -=  1
      p2 -=  1
    }
    false
  }

}
