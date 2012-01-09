/**
 * User: idurkan
 * Date: 1/8/12
 * Time: 12:13 PM
 */
object FindLongLines {
  def main(args: Array[String]) {
    val width = args(0).toInt
    for (arg <- args.drop(1)) { // drop(n): return new array with first n elements removed.
      // constrast with init(n): return new array with ONLY the first n elements of the original.
      LongLines.processFile(arg, width)
    }
  }
}