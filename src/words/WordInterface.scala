package words

trait WordInterface {

  //  A String representing the word in all lowercase letters
  def spelling(): String

  // The sounds of the word all in lowercase letters separated by commas
  def sounds(): String

}
