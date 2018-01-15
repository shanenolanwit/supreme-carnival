package strategy.links;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LinkManager {
	
	public LinkManager(){
		
	}
	
	public String getRegex(String str){		
		boolean found = false;
		int count = str.length();
		String regex = "";
		do{
			if(str.length() > 0 && atozLowerMatch(str, count)){
				regex += atozLowerReplace(str, count);
				found = true;
			} else {
				if(str.length() > 0 &&  atozUpperMatch(str, count)){
					regex += atozUpperReplace(str, count);
					found = true;					
				} else {
					if(str.length() > 0 &&  zeroToNineAnyMatch(str, count)){
						regex += zeroToNineAnyReplace(str, count);						
						found = true;						
					} else {
						if(str.length() > 0 &&  specialAnyMatch(str, count)){
							regex += specialAnyReplace(str, count);
							found = true;							
						}
					}
				}				
			}
			count--;
		}while(!found && count > 1);	
		return regex;
	}
	
	public boolean atozLowerMatch(String str, int count){
		return str.matches("^[^a-z]*?[a-z]{"+ count + "}.*");
	}
	
	public String atozLowerReplace(String str, int count){
		return splitByPattern(str, "(.*?)([a-z]{" + count + "})(.*?)$", "[a-z]{" + count + "}");		
	}
	
	public boolean atozUpperMatch(String str, int count){
		return str.matches("^[^A-Z]*?[A-Z]{"+ count + "}.*");
	}
	
	public String atozUpperReplace(String str, int count){
		return splitByPattern(str, "(.*?)([A-Z]{" + count + "})(.*?)$", "[A-Z]{" + count + "}");	
	}
	
	public boolean specialAnyMatch(String str, int count){
		return str.matches("^[a-zA-Z0-9]*?[^a-zA-Z0-9]{"+ count + "}.*");
	}
	
	public String specialAnyReplace(String str, int count){
		return splitByPattern(str, "(.*?)([^a-zA-Z0-9]{" + count + "})(.*?)$", "[^a-zA-Z0-9]{" + count + "}");		
	}
	
	public boolean zeroToNineAnyMatch(String str, int count){
		return str.matches("^[^0-9]*?[0-9]{"+ count + "}.*");
	}
	
	public String zeroToNineAnyReplace(String str, int count){
		return splitByPattern(str, "(.*?)([0-9]{" + count + "})(.*?)$", "[0-9]{" + count + "}");
	}
	
	public String splitByPattern(String str, String stringPattern, String replacement){
		Matcher m = Pattern.compile(stringPattern).matcher(str);
		m.matches();
		String regex = "";
		regex += getRegex(m.group(1));
		regex += replacement;
		regex += getRegex(m.group(3));
		return regex;		
	}

	

}
