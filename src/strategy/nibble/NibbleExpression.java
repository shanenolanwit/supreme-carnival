package strategy.nibble;

public enum NibbleExpression {
	
	A2ZLOWER("^([a-z]{2,})(.*)$","[a-z]","^[a-z]+"),
	A2ZUPPER("^([A-Z]{2,})(.*)$","[A-Z]","^[A-Z]+"),
	A2ZALL("^([a-zA-Z]+)(.*)$","[a-zA-Z]","^[a-zA-Z]+"),
	ZERO2NINE("^([0-9]+)(.*)$","[0-9]","^[0-9]+"),
	NONALPHANUMERIC("^([^a-zA-Z0-9]+)(.*)$","[^a-zA-Z0-9]","^[^a-zA-Z0-9]+");
	
	private NibbleExpression(String captureString, String baseString, String replaceString) {
		this.captureString = captureString;
		this.baseString = baseString;
		this.replaceString = replaceString;
	}

	private final String captureString;
	private final String baseString;
	private final String replaceString;

	public String getCaptureString() {
		return captureString;
	}

	public String getBaseString() {
		return baseString;
	}

	public String getReplaceString() {
		return replaceString;
	}
	
	
	

}
