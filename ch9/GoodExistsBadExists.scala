
def containsNeg(nums: List[Int]): Boolean = {
    var exists = false
    for (num <- nums) {
        if (num < 0)
            exists = true
    }
    exists
}

def containsOdd(nums: List[Int]): Boolean = {
    var exists = false
    for (num <- nums) {
        if (num % 2 == 1)
            exists = true
    }
    exists
}


val datas = List(10, 5, 1, -5, -10 )

println("datas = " + datas)

println("datas contains negatives (bad way): " + containsNeg(datas))
println("datas contains odds (bad way): " + containsOdd(datas))

// good way to implement existence testing.
println("datas contains negatives (good way): " + datas.exists(_ > 0))
println("datas contains odds (good way): " + datas.exists( _ % 2 == 1 ))
println("datas contains multiples-of-3: " + datas.exists( _ % 3 == 0 ))
