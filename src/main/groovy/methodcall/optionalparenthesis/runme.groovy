package methodcall.optionalparenthesis

MetalFan metalFan = new MetalFan()

/** Method .whatsYourFavouriteBand() has no parameters **/
metalFan.whatsYourFavouriteBand()

/**
 * A method with no parameters can't be invoked with omitted parenthesis
 */
try {
    metalFan.whatsYourFavouriteBand
} catch (MissingMethodException e) {
    println "No method found, as expected"
} catch (MissingPropertyException e) {
    println "No property found found, as expected"
}

/**
 * Method .myFavoureiteBandIs(String band) has one
 * paramter. A method with one or more parameters can be invoked
 * with omitted parenthesis (when there is no ambiguity)
 */
String myFavouriteBand = metalFan.myFavoureiteBandIs "Judas Priest"
assert "Judas Priest" == myFavouriteBand