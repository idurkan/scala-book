import java.net._

def urlFor(path: String): URL =
  try {
    println("This always prints!")
    new URL(path)
  } catch {
    case e: MalformedURLException =>
      new URL("http://www.scala-lang.org") // catch clause evaluates to a value!
  } finally {
      println("This always prints too!")
  }

if (args.length >= 1) {
  println("The URL = " + urlFor(args(0)).toString())
}
