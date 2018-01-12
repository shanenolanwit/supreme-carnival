package strategy.nibble;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Nibbler {
	
	private String regex;
	
	public Nibbler(String str){
		System.out.println("Nibble String is " + (str.isEmpty() ? "empty" : str));
		this.regex = "";
		if(str.isEmpty()){
			//Do nothing
		} else if(dynoMatch(str, NibbleExpression.A2ZLOWER.getCaptureString()).containsKey(true)){
			regex += NibbleExpression.A2ZLOWER.getBaseString() + "{" + dynoMatch(str, NibbleExpression.A2ZLOWER.getCaptureString()).get(true).length() + "}";
			regex += new Nibbler(str.replaceFirst(NibbleExpression.A2ZLOWER.getReplaceString(), "")).getRegex();
		} else if(dynoMatch(str, NibbleExpression.A2ZUPPER.getCaptureString()).containsKey(true)){
			regex += NibbleExpression.A2ZUPPER.getBaseString() + "{" + dynoMatch(str, NibbleExpression.A2ZUPPER.getCaptureString()).get(true).length() + "}";
			regex += new Nibbler(str.replaceFirst(NibbleExpression.A2ZUPPER.getReplaceString(), "")).getRegex();
		} else if(dynoMatch(str, NibbleExpression.A2ZALL.getCaptureString()).containsKey(true)){
			regex += NibbleExpression.A2ZALL.getBaseString() + "{" + dynoMatch(str, NibbleExpression.A2ZALL.getCaptureString()).get(true).length() + "}";
			regex += new Nibbler(str.replaceFirst(NibbleExpression.A2ZALL.getReplaceString(), "")).getRegex();
		} else if(dynoMatch(str, NibbleExpression.ZERO2NINE.getCaptureString()).containsKey(true)){
			regex += NibbleExpression.ZERO2NINE.getBaseString() + "{" + dynoMatch(str, NibbleExpression.ZERO2NINE.getCaptureString()).get(true).length() + "}";
			regex += new Nibbler(str.replaceFirst(NibbleExpression.ZERO2NINE.getReplaceString(), "")).getRegex();
		} else if(dynoMatch(str, NibbleExpression.NONALPHANUMERIC.getCaptureString()).containsKey(true)){
			regex += NibbleExpression.NONALPHANUMERIC.getBaseString() + "{" + dynoMatch(str, NibbleExpression.NONALPHANUMERIC.getCaptureString()).get(true).length() + "}";
			regex += new Nibbler(str.replaceFirst(NibbleExpression.NONALPHANUMERIC.getReplaceString(), "")).getRegex();
		}		
	}	
	
	public String getRegex() {
		return regex;
	}
	
	private Map<Boolean,String> dynoMatch(String str, String expr){
		
		Pattern pattern = Pattern.compile(expr);
		Matcher matcher = pattern.matcher(str);
		Map<Boolean,String> matchData = new HashMap<Boolean,String>();
		if(matcher.matches()){
			System.out.println("[String:" + str + ",Expr:" + expr + ",Match:true]");
			matchData.put(true, matcher.group(1));
		}else {
			System.out.println("[String:" + str + ",Expr:" + expr + ",Match:false]");
			matchData.put(false, "");
		}
		return matchData;
		
	}	

}
