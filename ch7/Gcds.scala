package Ch7

object Gcds {
  def gcdRecurse(a: Long, b: Long): Long =
    if (b == 0) a
    else gcdRecurse(b, a % b)
    
  def gcdIterate(x: Long, y: Long): Long = {
    var a = x
    var b = y
    
    while (b != 0) {
      val lastB = b
      b = a % b
      a = lastB
    }
    
    return a
  }
}
