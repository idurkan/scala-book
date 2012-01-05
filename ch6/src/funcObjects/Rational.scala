package funcObjects

class Rational(n: Int, d: Int) {
  require(d != 0, "Denominator must not be zero")
  // compute the GCD so the numerator and denominator can be normalized.
  private val g = gcd(n.abs, d.abs)

  val numer: Int = n / g
  val denom: Int = d / g

  // auxiliary constructor for whole numbers
  def this(n: Int) = this(n, 1)

  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

  override def toString =
    if (denom == 1) {
      numer.toString
    } else {
      numer + "/" + denom
    }

  def + (other: Rational): Rational = add(other)
  def + (other: Int): Rational = add(other)

  def add(other: Rational): Rational =
    new Rational(
      this.numer * other.denom + other.numer * this.denom,
      this.denom * other.denom
    )

  def add(other: Int): Rational =
    new Rational(
      this.numer + other * this.denom,
      this.denom
    )
  
  def * (other: Rational): Rational = multiply(other)
  def * (other: Int): Rational = multiply(other)

  def multiply(other: Rational): Rational =
    new Rational(
      this.numer * other.numer,
      this.denom * other.denom
    )
  def multiply(other: Int) =
    new Rational(
      this.numer * other,
      this.denom
    )

  def - (other: Rational) = subtract(other)
  def - (other: Int) = subtract(other)

  def subtract(other: Rational): Rational =
    new Rational(
      this.numer * other.denom - other.numer * this.denom,
      this.denom * other.denom
    )
  def subtract(other: Int): Rational =
    new Rational(
      this.numer - other * this.denom,
      this.denom
    )

  def / (other: Rational): Rational = divide(other)
  def / (other: Int): Rational = divide(other)

  def divide(other: Rational): Rational =
    new Rational(
      this.numer * other.denom,
      this.denom * other.numer
    )
  def divide(other: Int): Rational =
    new Rational(
      this.numer,
      this.denom * other
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

  // the below implicit def would allow arithmetic of ints with Rationals, but if it's defined
  // within just Rational it is not in the correct scope to affect code outside of Rational.
  //implicit def intToRational(x: Int) = new Rational(x)
}