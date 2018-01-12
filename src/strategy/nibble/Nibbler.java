package strategy.nibble;

public class Nibbler {
	
	private String regex;
	
	public Nibbler(String str){
		System.out.println("Nibble String is " + (str.isEmpty() ? "empty" : str));
		this.regex = "";		
		if(str.isEmpty()){
			//Do nothing
		} else {
			Nibble lowerNibble = new Nibble(str, NibbleExpression.A2ZLOWER.getCaptureString());			
			if(lowerNibble.isTasty()){
				regex += NibbleExpression.A2ZLOWER.getBaseString() + "{" + lowerNibble.getBite().length() + "}";
				regex += new Nibbler(lowerNibble.getLeftovers()).getRegex();
			} else {
				Nibble upperNibble = new Nibble(str, NibbleExpression.A2ZUPPER.getCaptureString());				
				if(upperNibble.isTasty()){
					regex += NibbleExpression.A2ZUPPER.getBaseString() + "{" + upperNibble.getBite().length() + "}";
					regex += new Nibbler(upperNibble.getLeftovers()).getRegex();
				} else{
					Nibble lettersNibble = new Nibble(str, NibbleExpression.A2ZALL.getCaptureString());					
					if(lettersNibble.isTasty()){
						regex += NibbleExpression.A2ZALL.getBaseString() + "{" + lettersNibble.getBite().length() + "}";
						regex += new Nibbler(lettersNibble.getLeftovers()).getRegex();
					} else {
						Nibble numbersNibble = new Nibble(str, NibbleExpression.ZERO2NINE.getCaptureString());
						if(numbersNibble.isTasty()){
							regex += NibbleExpression.ZERO2NINE.getBaseString() + "{" + numbersNibble.getBite().length() + "}";
							regex += new Nibbler(numbersNibble.getLeftovers()).getRegex();
						} else {
							Nibble nonAlphaNibble = new Nibble(str, NibbleExpression.NONALPHANUMERIC.getCaptureString());
							if(nonAlphaNibble.isTasty()){
								regex += NibbleExpression.NONALPHANUMERIC.getBaseString() + "{" + nonAlphaNibble.getBite().length() + "}";
								regex += new Nibbler(nonAlphaNibble.getLeftovers()).getRegex();
							}
						} 		
					}										
				}				
			}			
		}

	}	
	
	public String getRegex() {
		return regex;
	}
	
	

}
