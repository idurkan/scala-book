args.foreach((arg : String) => println(arg))
println("MOAR!")

// mmmm functional sexiness
args.foreach(println)

println("MOOOOOAR!")

for(val arg <- args) {
    println(arg)
}
