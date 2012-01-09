import java.io.File

object FileMatcher {
    private def filesHere = (new java.io.File(".")).listFiles
    
    // methods outmoded by the power 
    //def filesEnding(query: String): Array[File] =
    //    for (file <- filesHere; if file.getName.endsWith(query))
    //        yield file
    //        
    //def filesContaining(query: String): Array[File] =
    //    for (file <- filesHere; if file.getName.contains(query))
    //        yield file
    //        
    //def filesMatchingRegex(pattern: String) =
    //    for (file <- filesHere; if file.getName.matches(pattern))
    //        yield file
            
    // a red truth: higher-order functions are better.
    def filesMatching(query: String, matcher: (String, String) => Boolean) = {
        for (file <- filesHere; if matcher(file.getName, query))
            yield file
    }
    
    def filesEnding(query: String) =
        filesMatching(query, _.endsWith(_)) // making a partially-applied function out of String.endsWith!
        
    def filesContaining(query: String) =
        filesMatching(query, _.contains(_)) // another partially-applied function
        
    def filesMatchingRegex(pattern: String) =
        // note: the _.xxyyzz(_) syntax is short for the following form of function - remember,
        // the first '_' represents the function's first param, the second '_' is the second
        // parameter.
        filesMatching(pattern, (fname: String, pattern: String) => fname.matches(pattern))
        
    // even better - leave out the query string as a param to the matcher function.
    def filesMatchingExtreme(matcher: String => Boolean) =
        for (file <- filesHere; if matcher(file.getName))
            yield file
       
    def filesEndingExtreme(query: String) =
        filesMatchingExtreme(_.endsWith(query))
        
    // etc. etc.
    
    // test out the higher-order functional solution
    def main(args: Array[String]) {
        println("Files ending in scala: " + filesEnding("scala").mkString(", "))
        println("Files matching '*.xorb': " + filesMatchingRegex(""".*\.xorb""").mkString(", "))
        println("Hateful files: " + filesContaining("hate").mkString(", "))
        
        val matcher1 = (filename: String, query: String) => filename.contains(query)
        println("Touchy files: " + filesMatching("touch", matcher1).mkString(", "))
    }
}
