package strategy.simple;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleRegexiser {
	
	public static String getSimpleRegex(String str){
		Matcher m = Pattern.compile("([^a-zA-Z0-9]+|[a-z]+|[A-Z]+|[0-9]+)").matcher(str);
		StringBuilder sb = new StringBuilder();
		while(m.find()){
			String matchtext = m.group(1);
			int matchtextLength = matchtext.length();
			if(matchtext.matches("[0-9]+")){
				sb.append("[0-9]{" + matchtextLength + "}");
			}else if(matchtext.matches("[a-z]+")){
				sb.append("[a-z]{" + matchtextLength + "}");
			}else if(matchtext.matches("[A-Z]+")){
				sb.append("[A-Z]{" + matchtextLength + "}");
			}else {
				sb.append("[^a-zA-Z0-9]{" + matchtextLength + "}");
			}			
		}
		return sb.toString();
	}
	

}
