package strategy.nibble;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Nibbler {
	
	private final static String A2ZLOWER = "^([a-z]{2,})(.*)$";
	private final static String A2ZUPPER = "^([A-Z]{2,})(.*)$";
	private final static String A2ZALL = "^([a-zA-Z]+)(.*)$";
	private final static String ZERO2NINE = "^([0-9]+)(.*)$";
	private final static String NONALPHANUMERIC = "^([^a-zA-Z0-9]+)(.*)$";
	
	private String regex;
	
	public Nibbler(String str){
		System.out.println("Nibble String is " + str);
		this.regex = "";
		if(dynoMatch(str, A2ZLOWER).containsKey(true)){
			regex += "[a-z]{" + dynoMatch(str, A2ZLOWER).get(true).length() + "}";
			regex += new Nibbler(str.replaceFirst("^[a-z]+", "")).getRegex();
		} else if(dynoMatch(str, A2ZUPPER).containsKey(true)){
			regex += "[A-Z]{" + dynoMatch(str, A2ZUPPER).get(true).length() + "}";
			regex += new Nibbler(str.replaceFirst("^[A-Z]+", "")).getRegex();
		} else if(dynoMatch(str, A2ZALL).containsKey(true)){
			regex += "[a-zA-Z]{" + dynoMatch(str, A2ZALL).get(true).length() + "}";
			regex += new Nibbler(str.replaceFirst("^[a-zA-Z]+", "")).getRegex();
		} else if(dynoMatch(str, ZERO2NINE).containsKey(true)){
			regex += "[0-9]{" + dynoMatch(str, ZERO2NINE).get(true).length() + "}";
			regex += new Nibbler(str.replaceFirst("^[0-9]+", "")).getRegex();
		} else if(dynoMatch(str, NONALPHANUMERIC).containsKey(true)){
			regex += "[^a-zA-Z0-9]{" + dynoMatch(str, NONALPHANUMERIC).get(true).length() + "}";
			regex += new Nibbler(str.replaceFirst("^[^a-zA-Z0-9]+", "")).getRegex();
		}		
	}	
	
	public String getRegex() {
		return regex;
	}
	
	private Map<Boolean,String> dynoMatch(String str, String expr){
		System.out.println("[String:" + str + ",Expr:" + expr + "]");
		Pattern pattern = Pattern.compile(expr);
		Matcher matcher = pattern.matcher(str);
		Map<Boolean,String> matchData = new HashMap<Boolean,String>();
		if(matcher.matches()){
			matchData.put(true, matcher.group(1));
		}else {
			matchData.put(false, "");
		}
		return matchData;
		
	}
	
	
	
	
	
	

}
