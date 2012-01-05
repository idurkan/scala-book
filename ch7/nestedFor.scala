import java.io._

def fileLines(file: File):List[String] =
  scala.io.Source.fromFile(file).getLines().toList
  
def getMatchingFiles(files: Array[File]): Array[File] =
  // the for-expression has TWO generator clauses.  One produces all the files
  // in files ending with '.scala'.  The second produces all lines in each file 
  // from the first clause that match the regex in pattern.
  for {
    file <- files
    if file.getName.endsWith(".scala")
  } yield file 

val pattern = ".*gcd.*"
val matchingFiles: Array[File] = getMatchingFiles(new File(".").listFiles)

for {file <- matchingFiles
     line <- fileLines(file)
     trimmed = line.trim
     if trimmed.matches(pattern)
     } { println(file.toString() + ": " + trimmed) }

//    line <- fileLines(file)
//    trimmed = line.trim // behavior of variables declared in a for generator clause is like that of vals
//    if trimmed.matches(pattern)

