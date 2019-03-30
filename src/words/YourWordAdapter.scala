package words

class YourWordAdapter(wordSpelling: String, wordSounds: List[String]) extends WordInterface {
  def spellingOldToNew(): String = {
    this.wordSpelling.toLowerCase
  }

  override def spelling(): String = spellingOldToNew()


  def soundsOldToNew(): String = {
    var newWord: String = ""
    for (syllable <- wordSounds){
      if (wordSounds.last != syllable){
        newWord += syllable.toLowerCase()
        newWord += ","
      }
      else if (wordSounds.last == syllable){
        newWord += syllable.toLowerCase()
      }
    }
    newWord
  }

  override def sounds(): String = soundsOldToNew()
}
