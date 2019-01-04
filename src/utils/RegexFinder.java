package utils;

import java.util.List;

public class RegexFinder {

	/**
	 * Compares a list of lists containing optimised regexes and finds the regex that is present in all lists
	 * this regex is then returned as it is considered to be the best match 
	 * @param regexLists the list of lists of regex
	 * @return the regex to use
	 */
	public static String compareRegexes(List<List<String>> regexLists){
		// sort the lists to get the smallest list in the list of lists
		regexLists.sort((x1, x2) -> x1.size() - x2.size());
		
		// grab the smallest list of optimisations
		// we use the smallest list because the regex needs to be present in all
		// so using the smallest list will result in less loops
		List<String> smallestList = regexLists.get(0);
		
		// create a new lists of lists without the smaller lists of lists in there
		List<List<String>> slicedListofLists = regexLists.subList(1, regexLists.size());
		
		String regexToUse = null;
		
		// loop through these optimisations
		for(String regex : smallestList) {
			// check and see if all the lists contain this regex 
			boolean isInAllLists = slicedListofLists.stream().allMatch(lst -> lst.contains(regex));
			// if there is a regex present in each list then use this regex
			if(isInAllLists) {
				regexToUse = regex;
				break;
			}
		}
		return regexToUse;
	}
}