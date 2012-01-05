import scala.util.control.Breaks._ // 'static import' for methods of the Breaks object.
import java.io._

val in = new BufferedReader(new InputStreamReader(System.in))

// wrap anything that calls the break method in 
breakable {
  while(true) {
    var text = in.readLine()
    if (text == "") break
    println("? " + text)
  }
}
