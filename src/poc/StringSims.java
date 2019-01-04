package poc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import tree.RegexTree;

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
	 * Takes in a list of strings, finds the most common substring, uses it to build a regex common to all candidates
	 * @param candidates
	 * @return
	 */
	public static String lazyMatchRegex(List<String> candidates){
		
		String candidate = candidates.get(0);
		List<String> others = candidates.subList(1, candidates.size());
		List<String> substrings = getSubsets(candidate)
									.stream().filter(s -> s.length() > 2)
									.collect(Collectors.toList());		
		boolean hasMatches;
		String matchingRegex = "(.+?)";
		for(String substring : substrings){
			String regex = "^(.*?)(" + new RegexTree(substring).getRegex() + ")(.*?)$";			
			hasMatches = others.stream().allMatch(s -> s.matches(regex));
			if(hasMatches){
				matchingRegex = regex;
				break;
			}
		}
		
		return matchingRegex;
	}
	
	public static List<String> extractMatches(List<String> candidates, String regex){
		return candidates.stream().map( cand -> { 
			Matcher m = Pattern.compile(regex).matcher(cand);
			return m.find() ? m.group(2) : null; 
		}).collect(Collectors.toList());
	}
	
	
	public static List<String> optimiseRegex(String unoptRegex){
		String optRegex = unoptRegex;
		List<Function<String, String>> catalog = new RegexOptimiser().getCatalog();
		Set<String> optimisations = new HashSet<String>();
		for(Function<String,String> f : catalog){						
			optRegex = f.apply(optRegex);
			optimisations.add(optRegex);
		}
		return new ArrayList<String>(optimisations);
	}
	
	
	public static String matchAll(List<String> candidates){
		return "";
	}
	
	


}
