// remember - only objects can have main methods.
object MultiTable {
  def printMultiTable(size: Int): Unit = {
    var i = 1
    
    while (i <= size) {
      var j = 1
      
      while (j <= size) {
        val prod = (i * j).toString
        var k = prod.length
        
        while (k < 5) {
          print(" ")
          k += 1
        }
        
        print(prod)
        j += 1
      }
      
      println()
      i += 1
    }
  }
  
  def getMultiTable(size: Int): String = {
    // makes a list of per-column strings for a row.
    def makeRowSeq(row: Int, size: Int) =
      for (col <- 1 to size) yield {
        val prod = (row*col).toString
        val padding = " " * (5 - prod.length)
        (padding + prod)
      }
      
    def makeRow(row: Int, size: Int) = makeRowSeq(row, size).mkString

    val tableSeq =
      for (row <- 1 to size)
      yield makeRow(row, size)
      
    (tableSeq.mkString("\n"))    
  }
  
  def main(args: Array[String]): Unit = {
    println("Multiplication table using iteration:")
    printMultiTable(10)
    
    println("Multiplication table using FP-style code:")
    println(getMultiTable(10))
  }
}
