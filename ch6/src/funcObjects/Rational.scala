package funcObjects

class Rational(n: Int, d: Int) {
  require(d != 0, "Denominator must not be zero")
  val numer: Int = n
  val denom: Int = d

  // auxiliary constructor for whole numbers
  def this(n: Int) = this(n, 1)

  override def toString =
    if (denom == 1) {
      numer.toString
    } else {
      numer + "/" + denom
    }

  def add(other: Rational): Rational =
    new Rational(
      this.numer * other.denom + other.numer * this.denom,
      this.denom * other.denom
    )

  override def equals(other: Any): Boolean =
    other match {
      case that: Rational =>
        (that.canEqual(this)) && (this.numer == that.numer) && (this.denom == that.denom)
      case _ => false
    }

  def canEqual(other: Any): Boolean =
    other.isInstanceOf[Rational]

  override def hashCode: Int =
    41 * (41 + numer) + denom
}