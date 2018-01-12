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

	public String analyse(String str) {
		return analyse(str, "");
	}

	private String analyse(String str, String regex) {

		if(!str.isEmpty()) {
			String key = this.regexList.stream()
					.filter(p -> Pattern.compile(p).matcher(str).matches())
					.findFirst()
					.get();

			Pattern pattern = Pattern.compile(key);
			Matcher matcher = pattern.matcher(str);
			String replacementPattern = this.regexMap.get(key);
			if(matcher.matches()) {
				String patternWithCount = replacementPattern.replaceAll("[\\^\\+]+", "") + "{" + matcher.group(1).length() + "}";
				return analyse(str.replaceFirst(replacementPattern, ""), regex += patternWithCount);
			}
		}
		return regex;
	}

	public int getMatchedCount(String str) {
		return 0;
	}

}
