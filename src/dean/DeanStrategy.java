package dean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeanStrategy {

	private final static String A2ZLOWER = "^([a-z]{2,})(.*)$";
	private final static String A2ZUPPER = "^([A-Z]{2,})(.*)$";
	private final static String A2ZALL = "^([a-zA-Z]+)(.*)$";
	private final static String ZERO2NINE = "^([0-9]+)(.*)$";
	private final static String NONALPHANUMERIC = "^([^a-zA-Z0-9]+)(.*)$";

	private Map<String, String> regexMap;
	private List<String> regexList;

	public DeanStrategy() {
		init();
	}

	public void init() {
		populateRegexList();
		populateRegexMap();
	}

	private void populateRegexMap() {
		this.regexMap = new HashMap<String, String>();
		this.regexMap.put(A2ZLOWER, "^[a-z]+");
		this.regexMap.put(A2ZUPPER, "^[A-Z]+");
		this.regexMap.put(A2ZALL, "^[a-zA-Z]+");
		this.regexMap.put(ZERO2NINE, "^[0-9]+");
		this.regexMap.put(NONALPHANUMERIC, "^[^a-zA-Z0-9]+");
	}

	private void populateRegexList() {
		this.regexList = new ArrayList<String>(Arrays.asList(A2ZLOWER,
				A2ZUPPER,
				A2ZALL,
				ZERO2NINE,
				NONALPHANUMERIC));
	}

	/**
	 * Analyses a string and generates a regex for the string.
	 * Method calls analyse(str, regex) with a blank string for regex
	 * @param str - the string to analyse
	 * @return regex that matches the given string
	 */
	public String analyse(String str) {
		return analyse(str, "");
	}

	/**
	 * Analyses a string and returns  aregex that matches it
	 * @param str - string to analyse
	 * @param regex - the current regex expression
	 * @return regex expression that matches the string
	 */
	private String analyse(String str, String regex) {
		if(!str.isEmpty()) {
			String key = this.regexList.stream()		//grab the pattern that matches the string
									   .filter(p -> Pattern.compile(p).matcher(str).matches())
									   .findFirst()
									   .get();		

			Pattern pattern = Pattern.compile(key);
			Matcher matcher = pattern.matcher(str);
			String replacementPattern = getReplacementPattern(this.regexMap.get(key));	//create replacement pattern
			
			if(matcher.matches()) {	
				String patternWithCount = replacementPattern + "{" + matcher.group(1).length() + "}";
				//make recursive call with new string and updated regex
				return analyse(str.replaceFirst(this.regexMap.get(key), ""), regex += patternWithCount);
			}
		}
		return regex;
	}
	
	/**
	 * Replaces all characters outside of '[' and ']'
	 * @param pattern - the pattern to modify
	 * @return the pattern excluding all characters outside of the square brackets
	 */
	private String getReplacementPattern(String pattern) {
		int start = pattern.indexOf("[");
		int end = pattern.indexOf("]");
		return pattern.substring(start, end + 1);
	}

}
