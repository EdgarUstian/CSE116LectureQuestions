package words

object AlliterationLibrary {

  /**
    *  This library is designed to work with the type WordInterface which expects sounds to be all lowercase and
    *  in a single String separated by commas
    */

  def firstSound(word: WordInterface): String = {
    word.sounds().slice(0,word.sounds().indexOf(","))
  }

  def isAlliteration(word1: WordInterface, word2: WordInterface): Boolean = {
    this.firstSound(word1) == this.firstSound(word2)
  }

}
