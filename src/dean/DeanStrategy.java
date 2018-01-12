package dean;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeanStrategy {
	
	private static String REGEX_ALPHA = "[a-z]+";
	private static String REGEX_NUMERIC = "[0-9]+";

	private static Pattern PATTERN_ALPHA = Pattern.compile(REGEX_ALPHA);
	private static Pattern PATTERN_NUMERIC = Pattern.compile(REGEX_NUMERIC);
	
	public static String analyse(String str) {
		return analyse(str, "");
	}
	
	private static String analyse(String str, String regex) {
		Matcher alphaMatcher = PATTERN_ALPHA.matcher(str);
		Matcher numericMatcher = PATTERN_NUMERIC.matcher(str);
		String temp = "";
		do {
			if(alphaMatcher.find()) {
				temp = str.substring(alphaMatcher.end(), str.length());
				regex += REGEX_ALPHA;
			}else if(numericMatcher.find()) {
				temp = str.substring(numericMatcher.end(), str.length());
				regex += REGEX_NUMERIC;
			}
		}while(!temp.isEmpty());
		
		return regex;
	}
	
	public static int getMatchedCount(String str) {
		int count = 0;
//		Matcher alphaMatcher = REGEX_ALPHA.matcher(str);
//		alphaMatcher.find();
//		int matchSize = str.substring(alphaMatcher.start(), alphaMatcher.end()).length();
		return count;
	}
	
}
