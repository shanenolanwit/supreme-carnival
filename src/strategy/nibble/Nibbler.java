package strategy.nibble;

import java.util.Optional;
import java.util.stream.Stream;

public class Nibbler {	
	
	public static String nibble(String str){
		String result = "";
		if(str.isEmpty()){
			//Do nothing
		} else {
			Optional<PatternDefiniton> expr = Stream.of(PatternDefiniton.values())
					.filter(e -> new Nibble(str,e).matches())
					.findFirst();
			if(expr.isPresent()){
				result += breakup(new Nibble(str,expr.get()));
			}		
		}
		return result;
	}
	
	private static String breakup(Nibble n){
		return new StringBuilder()
				.append(n.getPatternDefinition().getBaseString())
				.append("{")
				.append(n.getBite().length())
				.append("}")
				.append(Nibbler.nibble(n.getLeftovers()))
				.toString();
		
	}
	
	

}
