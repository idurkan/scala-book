val firstArg = if (args.length > 0) args(0) else ""

// match expressions can evaluate to a value, like many things in scala.
val firstAccompaniment: String = firstArg match {
  case "salt" => "potatoes"
  case "chips" => "sour cream dip"
  case "eggs" => "toast"
  case _ => "huh?"
}

var secondAccompaniment: String = ""
// match expressions can also be used like Java case-statements.
firstArg match {
  case "salt" => 
    secondAccompaniment = "pepper"
  case "chips" => 
    secondAccompaniment = "salsa"
  case "eggs" => 
    secondAccompaniment = "bacon"
  case _ => 
    secondAccompaniment = "what?"
  }

println(firstArg + " goes with " + firstAccompaniment + " and " + secondAccompaniment)
