package data;

public enum RegexSample {
	
	SAMPLE_1("BBasbAAA087--bbb", "[A-Z]{2}[a-z]{3}[A-Z]{3}[0-9]{3}[^a-zA-Z0-9]{2}[a-z]{3}"),
	SAMPLE_2("B1234--4321a", "[A-Z]{1}[0-9]{4}[^a-zA-Z0-9]{2}[0-9]{4}[a-z]{1}"),
	SAMPLE_3("HelloSN18", "[A-Z]{1}[a-z]{4}[A-Z]{2}[0-9]{2}"),
	SAMPLE_4("a-A-b--+", "[a-z]{1}[^a-zA-Z0-9]{1}[A-Z]{1}[^a-zA-Z0-9]{1}[a-z]{1}[^a-zA-Z0-9]{3}"),
	SAMPLE_5("BATMAN", "[A-Z]{6}");
	
	private final String input;
	private final String output;	
	
	private RegexSample(String input, String output) {
		this.input = input;
		this.output = output;
	}

	public String getInput() {
		return input;
	}

	public String getOutput() {
		return output;
	}	

}
