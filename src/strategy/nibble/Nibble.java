package strategy.nibble;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Nibble {
	
	private final boolean matches;
	private final String bite;
	private final String leftovers;
	private final PatternDefiniton patternDefinition;	
	
	public Nibble(String str, PatternDefiniton patternDefinition){	
		this.patternDefinition = patternDefinition;
		String expr = patternDefinition.getCaptureString();
		Matcher matcher = Pattern.compile(expr).matcher(str);
		if(matcher.matches()){
			this.matches = true;
			this.bite = matcher.group(1);
			this.leftovers = matcher.groupCount() > 1 ? matcher.group(2) : "";
		}else {
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

	public PatternDefiniton getPatternDefinition() {
		return patternDefinition;
	}	

}
