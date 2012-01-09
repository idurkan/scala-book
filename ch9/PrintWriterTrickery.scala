import java.io.File
import java.io.PrintWriter

def withPrintWriter(file: File)(op: PrintWriter => Unit) {
    val writer = new PrintWriter(file)
    try {
        op(writer)
    } finally {
        writer.close();
    }
}

// effect: withPrintWriter creates a PrintWriter to date.txt, then executes the given function
// using the supplied function.  finally, withPrinterWriter closes the file.
withPrintWriter(new File("date.txt"))(writer => writer.println(new java.util.Date))

println("First write done!")

// other way to invoke it.
withPrintWriter(new File("date2.txt")) {
    (writer: PrintWriter) => writer.println(new java.util.Date)
}

// NOTE: using curly braces to invoke a function is only allowed when the function takes one arg.
// withPrintWriter gets curried with the file, creating a truly one-arg function; then it is applied
// to the function literal in the curly braces.

println("Second write done!")
