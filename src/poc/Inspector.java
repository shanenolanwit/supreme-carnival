package poc;

public class Inspector {
	
	/**
	 * Primitive replacement strategy, doesn't bother counting the length of capture groups,
	 * instead it just uses a big dirty plus symbol
	 */
	public Inspector(){
		
	}
	
	public String simplify(String str){
		System.out.println(str);
		String calc = calculateString(str);
		return str.isEmpty() || str.equals(calc) ? "" :
			calc.substring(0, calc.indexOf("+")+1) 
			+ simplify(calc.substring(calc.indexOf("+")+1));
	}
	
	private String calculateString(String str){
		return str.replaceFirst("^[^a-zA-Z0-9]+", "[^a-zA-Z0-9]+")
				  .replaceFirst("^[a-z]{2,}", "[a-z]+")
				  .replaceFirst("^[A-Z]{2,}", "[A-Z]+")
				  .replaceFirst("^[a-zA-Z]+", "[a-zA-Z]+")
				  .replaceFirst("^[0-9]+", "[0-9]+");
	}

}
