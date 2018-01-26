package strategy.nibble;

public class Nibbler {
	
	private String regex;
	
	public Nibbler(String str){
//		System.out.println("Nibble String is " + (str.isEmpty() ? "empty" : str));
		this.regex = "";
		Nibble nibbleType = null;
		boolean matchFound = false;
		if(str.isEmpty()){
			//Do nothing
		} else {
			if(!matchFound && new Nibble(str, NibbleExpression.A2ZLOWER).matches()){
				matchFound = true;
				nibbleType = new Nibble(str, NibbleExpression.A2ZLOWER);
			}
			if(!matchFound && new Nibble(str, NibbleExpression.A2ZUPPER).matches()){
				matchFound = true;
				nibbleType = new Nibble(str, NibbleExpression.A2ZUPPER);
			}
			if(!matchFound && new Nibble(str, NibbleExpression.ZERO2NINE).matches()){
				matchFound = true;
				nibbleType = new Nibble(str, NibbleExpression.ZERO2NINE);
			}
			if(!matchFound && new Nibble(str, NibbleExpression.NONALPHANUMERIC).matches()){
				matchFound = true;
				nibbleType = new Nibble(str, NibbleExpression.NONALPHANUMERIC);
			}
			if(matchFound){
				this.regex += breakup(nibbleType);
			}
		}

	}	
	
	public String getRegex() {
		return regex;
	}
	
	private String breakup(Nibble n){
		String pattern = "";
		pattern += n.getNibbleExpression().getBaseString() + "{" + n.getBite().length() + "}";
		pattern += new Nibbler(n.getLeftovers()).getRegex();
		return pattern;
	}
	
	

}
