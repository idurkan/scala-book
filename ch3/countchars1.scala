import scala.io.Source

def widthOfLength(str: String): Int = str.length.toString.length

if (args.length > 0) {

    val lines: List[String] = Source.fromFile(args(0)).getLines().toList
    
    // get length of longest line in file
    // reduceLeft: called N-1 times for a list L with N items, taking a function f(a, b)
    // for the first call f(L(0), L(1)) is called to get an accumulation value V.
    // for all remaining calls, V = f(V, L(i))
    // reduceLeft returns V after all N-1 calls have been made.
    // so in the call below, the accumulation value is storing the longest line String.
    val longestString: String = lines.reduceLeft(
        (res:String, nextLine:String) => 
            if (res.length > nextLine.length) res else nextLine)
            
    // get length / width of longest string representing a line's length
    val maxLengthWidth: Int = widthOfLength(longestString)

    for (line <- Source.fromFile(args(0)).getLines()) {
        val lengthWidth: Int = line.length.toString().length
        val numSpaces = maxLengthWidth - lengthWidth
        val lengthAndPadding: String = (" " * numSpaces) + line.length + " | "
        println(lengthAndPadding + line)
    }
} else {
    Console.err.println("Enter a filename as first argument.")
}

