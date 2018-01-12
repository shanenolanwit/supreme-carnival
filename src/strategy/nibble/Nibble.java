package strategy.nibble;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Nibble {
	
	private final boolean tasty;
	private final String bite;
	private final String leftovers;
	
	
	public Nibble(String str, String expr){		
		Pattern pattern = Pattern.compile(expr);
		Matcher matcher = pattern.matcher(str);
		if(matcher.matches()){
			System.out.println("[String:" + str + ",Expr:" + expr + ",Match:true]");
			this.tasty = true;
			this.bite = matcher.group(1);
			this.leftovers = matcher.groupCount() > 1 ? matcher.group(2) : "";
		}else {
			System.out.println("[String:" + str + ",Expr:" + expr + ",Match:false]");
			this.tasty = false;
			this.bite = "";
			this.leftovers = "";
		}
		
	}	
	
	public boolean isTasty() {
		return tasty;
	}
	public String getBite() {
		return bite;
	}

	public String getLeftovers() {
		return leftovers;
	}
	
	
	
	
	
	
	
	

}
