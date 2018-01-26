package poc;

import java.util.ArrayList;
import java.util.List;
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
	
	public static String lazyMatch(List<String> candidates){
		
		String candidate = candidates.get(0);
		List<String> others = candidates.subList(1, candidates.size());
		List<String> substrings = getSubsets(candidate)
									.stream().filter(s -> s.length() > 2)
									.collect(Collectors.toList());
		
		boolean hasMatches;
		String matchingSubstring = "";
		for(String substring : substrings){
			String regex = "^(.*?)(" + substring + ")(.*?)$";
			hasMatches = others.stream().allMatch(s -> s.matches(regex));
			if(hasMatches){
				matchingSubstring = substring;
				break;
			}
		}
		
		return matchingSubstring;
	}
	
	


}
