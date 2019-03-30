package words

object Main {

  def main(args: Array[String]): Unit = {

    //  Sample usage of new library
    val word1 = new Word("pressure", "p,r,eh1,sh,er0")
    val word2 = new Word("prosper", "p,r,aa1,s,p,er0")

    val alliteration: Boolean = AlliterationLibrary.isAlliteration(word1, word2)
//    println(alliteration)

    // Sample usage of our library
    val spelling1 = "PROSPER"
    val sounds1 = List("P", "R", "AA1", "S", "P", "ER0")

    val spelling2 = "PRESSURE"
    val sounds2 = List("P", "R", "EH1", "SH", "ER0")

    val rhyme: Boolean = RhymingDictionary.isRhymeSounds(sounds1, sounds2)
//    println(rhyme)

    // Your task is to use words in our format with the new library by getting code like
    // the following to function properly

//    val adaptedWord2 = new YourWordAdapter(spelling2, sounds2)
//    val testAlliteration: Boolean = AlliterationLibrary.isAlliteration(word1, adaptedWord2)
//    println(adaptedWord2.spelling(), adaptedWord2.sounds())
//    println(testAlliteration)
  }

}
