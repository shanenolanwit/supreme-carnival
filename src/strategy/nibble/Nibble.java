package strategy.nibble;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Nibble {
	
	private final boolean matches;
	private final String bite;
	private final String leftovers;
	private final NibbleExpression nibbleExpression;
	
	
	public Nibble(String str, NibbleExpression nibbleExpression){	
		this.nibbleExpression = nibbleExpression;
		String expr = nibbleExpression.getCaptureString();
		Pattern pattern = Pattern.compile(expr);
		Matcher matcher = pattern.matcher(str);
		if(matcher.matches()){
//			System.out.println("[String:" + str + ",Expr:" + expr + ",Match:true]");
			this.matches = true;
			this.bite = matcher.group(1);
			this.leftovers = matcher.groupCount() > 1 ? matcher.group(2) : "";
		}else {
//			System.out.println("[String:" + str + ",Expr:" + expr + ",Match:false]");
			this.matches = false;
			this.bite = "";
			this.leftovers = "";
		}
		
	}	
	
	public boolean matches() {
		return matches;
	}
	public String getBite() {
		return bite;
	}

	public String getLeftovers() {
		return leftovers;
	}

	public NibbleExpression getNibbleExpression() {
		return nibbleExpression;
	}
	
	
	
	
	
	
	
	
	
	

}
