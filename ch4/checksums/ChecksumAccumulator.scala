import scala.collection.mutable.Map

class ChecksumAccumulator {
    private var sum = 0
    
    // alternate syntax for Unit-type functions - leave out the return type and
    // equals, but keep the {}
    def add(b: Byte) {
        sum += b
    }

    // curly-braces and return can be left out of a function that immediately returns a value.
    def checksum(): Int = ~(sum & 0xFF) + 1
}

// one instance of a type defined using object is 
// created automatically, giving us an easy way to make singletons.  No more 
// abusive enums and/or private static initializers, woohoo!

// defining an object with the same name as a class in a single file makes the
// object a "companion" of the class.  Methods of the companion object can be
// called against the typename.  This takes the place of static methods as seen
// in Java, C++, etc.

// NOTE: defining an object alone does not create a user-visible type.
// singleton objects CAN extend a superclass and mix-in traits.  A singleton
// object can be stored in references of parent types and trait types, however.
object ChecksumAccumulator {
    private val cache = Map[String, Int]()
    
    // memoizes results of checksum
    def calculate(s: String): Int = {
        if (cache.contains(s)) {
            return cache(s)
        } else {
            val acc = new ChecksumAccumulator
            for (character <- s) {
                acc.add(character.toByte)
            }
            val strChecksum = acc.checksum()
            
            // adds new mapping to cache
            cache += (s -> strChecksum)
            
            return strChecksum
        }
    }
}


