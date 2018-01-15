package strategy.links;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LinkManager {
	
	public LinkManager(){
		
	}
	
	/**
	 * Returns a regular expression matching a given string
	 * Searches the string for the longest match possible
	 * @param str
	 * @return
	 */
	public String getRegex(String str){		
		boolean found = false;
		int count = str.length();
		String regex = "";
		while(!found && count > 0){
			if(!found && str.matches("^[^a-z]*?[a-z]{"+ count + "}.*")){
				regex += splitByPattern(str, "(.*?)([a-z]{" + count + "})(.*?)$", "[a-z]{" + count + "}");
				found = true;
			}
			if(!found && str.matches("^[^A-Z]*?[A-Z]{"+ count + "}.*")){
				regex += splitByPattern(str, "(.*?)([A-Z]{" + count + "})(.*?)$", "[A-Z]{" + count + "}");
				found = true;
			}
			if(!found && str.matches("^[^0-9]*?[0-9]{"+ count + "}.*")){
				regex += splitByPattern(str, "(.*?)([0-9]{" + count + "})(.*?)$", "[0-9]{" + count + "}");						
				found = true;						
			} 
			if(!found && str.matches("^[a-zA-Z0-9]*?[^a-zA-Z0-9]{"+ count + "}.*")){
				regex += splitByPattern(str, "(.*?)([^a-zA-Z0-9]{" + count + "})(.*?)$", "[^a-zA-Z0-9]{" + count + "}");
				found = true;							
			}			
			count--;
		}			
		return regex;
	}
	
	/**
	 * Takes a string and an expression, replaces the matching sequence with the expression and surrounds it
	 * with expressions matching the remaining string to the left and right
	 * @param str
	 * @param stringPattern
	 * @param replacement
	 * @return
	 */
	private String splitByPattern(String str, String stringPattern, String replacement){
		Matcher m = Pattern.compile(stringPattern).matcher(str);
		m.matches();
		return new StringBuilder(getRegex(m.group(1)))
					.append(replacement)
					.append(getRegex(m.group(3)))
					.toString();			
	}
	

}
