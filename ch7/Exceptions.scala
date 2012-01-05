import java.io._

def halfer(n: Int): Int =
  if (n % 2 == 0)
    n / 2
  else
    throw new RuntimeException("n must be even, fool!")
    
try {
  val n = 5
  val f = new FileReader("input.txt")
  println("Half of " + n + " = " + halfer(n))
} catch { // scala uses pattern matching to process different exception types!
  case ex: FileNotFoundException => println("Can't find that file!")
  case ex: IOException => println("Egads, an IOExeption!")
  case ex: RuntimeException => println("Some other exception happened!")
} finally {
  println("reached the finally!")
  f.close()
}
