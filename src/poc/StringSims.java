package poc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StringSims {
	
	/**
	 * Returns all subsets of this string, ordered longest to shortest
	 * @param input
	 * @return
	 */
	public static List<String> getSubsets(String input){
		List<String> substrs = new ArrayList<String>();
		for(int i=1; i<= input.length(); i++){
			substrs.add(input.substring(0,i));
		} if(input.length() > 0){
			substrs.addAll(getSubsets(input.substring(1)));
		}		
		return substrs.stream()
						.sorted((x,y) -> { 
							return Integer.compare(y.length(), x.length());
						}).collect(Collectors.toList());
	}
	
	/**
	 * This is a work in progress - might not make sense as we need to be able to detect multiple duplicate sequences
	 * @param input
	 * @return
	 */
	public static Map<String,Integer> getSubsetIndexes(String input){
		return getSubsets(input).stream().collect(Collectors.toMap(k -> k, k -> input.indexOf(k)));
	}
	


}
