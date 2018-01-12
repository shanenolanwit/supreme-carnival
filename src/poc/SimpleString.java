package poc;

public class SimpleString {
	
	/**
	 * POC
	 * Breaks down a string to digit, non digit
	 * Messy and inefficient
	 * @param str
	 * @return
	 */
	public static String analyse(final String str){
		char[] chars = str.toCharArray();
		String regex = "";
		for(int i = 0; i < chars.length; i++){
			char c = chars[i];
			if(Character.isLetter(c)){
				regex += "D";
			} else if(Character.isDigit(c)){
				regex += "d";
			}else {
				regex += ".";
			}
		}
		
		chars = regex.toCharArray();
		regex = "";
		int count = 1;
		for(int i = 1; i < chars.length; i++){
			if(chars[i-1] == chars[i]){
				count++;
			}else{
				regex += chars[i-1] + "{" + count + "}";
				count = 1;
			}
		}
		if(count > 0){
			regex += chars[chars.length-1] + "{" + count + "}";
		}

		return regex.replace("d", "\\d").replace("D", "\\D");
	}

}
