package strategy.links;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import poc.StringSims;

public class SubstringLinkManager {
	
	public static String getRegex(List<String> candidates){
		String regex = "";
		//check are there are any common substrings
		String common = StringSims.lazyMatch(candidates);
		if(!common.isEmpty()){
			List<String[]> beforeAndAfters = candidates.stream().map(s -> s.split(common, 2)).collect(Collectors.toList());
			List<String> befores = beforeAndAfters.stream().map(s -> s[0]).collect(Collectors.toList());
			List<String> afters = beforeAndAfters.stream().map(s -> s[1]).collect(Collectors.toList());
			regex = getRegex(befores) + common + getRegex(afters);			
		}else{
			//do any regexes match these strings?
			boolean matchFound = false;			
			if(candidates.stream().allMatch(s -> s.matches("^([a-z]+)(.*?)$"))){
				matchFound = true;	
				regex = splitAndRegex(candidates, "^([a-z]+)(.*?)$", "[a-z]");			
			} else if(!matchFound && candidates.stream().allMatch(s -> s.matches("^([A-Z]+)(.*?)$"))){
				matchFound = true;	
				regex = splitAndRegex(candidates, "^([A-Z]+)(.*?)$","[A-Z]");
			} else if(!matchFound && candidates.stream().allMatch(s -> s.matches("^([0-9]+)(.*?)$"))){
				matchFound = true;	
				regex = splitAndRegex(candidates, "^([0-9]+)(.*?)$","[0-9]");
			} else if(!matchFound && candidates.stream().allMatch(s -> s.matches("^([^a-zA-Z0-9]+)(.*?)$"))){
				matchFound = true;
				regex = splitAndRegex(candidates, "^([^a-zA-Z0-9]+)(.*?)$","[^a-zA-Z0-9]");
			} else if(!matchFound && candidates.stream().anyMatch(s -> !s.isEmpty())){
				regex = "(.*?)";
			}
		}	
		
		return regex;
	}
	
	public static String splitAndRegex(List<String> candidates, String expression, String base){
		List<Integer> ints = new ArrayList<>();
		List<String> afters = candidates.stream().map((s) -> {
			Matcher m = Pattern.compile(expression).matcher(s);
			m.matches();
			ints.add(m.group(1).length());
			return m.group(2);
		}).collect(Collectors.toList());
		
		List<Integer> lengths = ints.stream().sorted().collect(Collectors.toList());		
		return base + "{" + lengths.get(0) + "," + lengths.get(lengths.size()-1) + "}" + getRegex(afters);
	}

}
