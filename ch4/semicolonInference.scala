
// semicolon divides two statements on the same line.
val s = "hello"; println("s = " + s)


// scala properly splits the following five lines into five statements:
val x = 3
if (x < 2) 
    println("Too small!")
else 
    println("ok!")
    
val y = 4
// scala INCORRECTLY splits the following into two statements!
// not really sure how these are 'statements' though...
x
+ y

// this is one statement:
(x
+ y)

val z = 0
// this is one statement.  Scala bridges these lines because infix operators
// are not legal ends-of-statements
x +
y -
z

println("x = " + x + "; y = " + y + "; z = " + z)
