// like a static import
import ChecksumAccumulator.calculate

// Objects with method main taking an Array of String will act as application
// entry point.
object Summer {
    def main(args: Array[String]) {
        for (arg <- args) {
            println(arg + ": " + calculate(arg))
        }
    }
}
