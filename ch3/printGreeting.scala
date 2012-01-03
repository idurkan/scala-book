// not generics - 'type parameter'
val greetStrings = new Array[String](3)

greetStrings(0) = "Hello"
greetStrings(1) = ", "
greetStrings(2) = "World"

for (i <- 0 to greetStrings.length-1) {
    print(greetStrings(i))
}

println("\nOnce more, with idiomaticity!\n")

val greets : Array[String] = Array("Hello", ", ", "World!")

// what realy happens:
val greets : Array[String] = Array("Hello", ", ", "World!")
// note Array is an instance of a 'companion object'.  above is not a static method call.

greets.foreach(print)
println()
