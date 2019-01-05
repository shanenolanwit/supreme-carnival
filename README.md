# Supreme Carnival

## Regular Expression Fun & Utilities

The main functionality is encompassed by the classes
 * LinkManager
 * RegexTree\
 They are both used to convert a string to a regex which can be used to match it (see examples below)\
 Still a lot of clean up to come\

Some of the current functionality / work in progress
 * Given a string - create a regex that can be used to match it
 	* BATMAN becomes [A-Z]{6}
 	* HelloSN18 becomes [A-Z]{1}[a-z]{4}[A-Z]{2}[0-9]{2}
 	* B1234--4321a becomes [A-Z]{1}[0-9]{4}[^a-zA-Z0-9]{2}[0-9]{4}[a-z]{1}
 * Given a strict regex - optimise the regex to make it shorter and more generic
 	* [a-z]{3}[A-Z]{1} becomes [a-zA-Z]{4}
 	* [A-Z]{3}[a-z]{2}[A-Z]{3}[a-z]{2} becomes [a-zA-Z]{10}
 * Given two lists of optimised regular expressions - find one in common
 


gradle test jacocoTestReport