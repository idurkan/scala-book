// mkString: compose one string from a sequence of strings, inserting a string b/t each string.
def formatArgs(args: Array[String]): String = args.mkString("\n")

println("Args string printed using mkString: " + formatArgs(args))

// assertions for unit testing
val result = formatArgs(Array("zero", "one", "two"))

println("result = " + result)
assert(result == "zero\none\ntwo")
