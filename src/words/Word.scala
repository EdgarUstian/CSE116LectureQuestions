package words

class Word(word:  String, pronunciation: String) extends WordInterface {

  override def spelling(): String = {
    this.word
  }

  override def sounds(): String = {
    this.pronunciation
  }
}
