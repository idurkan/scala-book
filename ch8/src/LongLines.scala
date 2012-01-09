import io.Source

/**
 * User: idurkan
 * Date: 1/8/12
 * Time: 12:13 PM
 */
object LongLines {
  def processFile(filename: String, width: Int) {
    // note: can't have private local functions - doesn't make any sense anyway.  Local functions are
    // only visible in the scope of their enclosing function.  The order in which they are defined
    // has no effect on visibility.

    val source = Source.fromFile(filename)
    for (line <- source.getLines()) {
      processLine(filename, width, line)
    }

    // local function: use these to avoid polluting the class/object namespace with tons of
    // private functions that are only used by one public function.
    // note how processLine can access the parameters of processFile.
    def processLine(line: String) {
      if (line.length > width)
        println(filename + ": " + line.trim)
    }

  }

}