package poc;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexOptimiser {
	
	private List<Function<String,String>> catalog;
	
	public RegexOptimiser(){
		this.catalog = new ArrayList<Function<String,String>>();
		catalog.add(
				( input -> {
					String regex = "\\[([a-z]\\-[a-z])\\]\\{([0-9])+\\}\\[([A-Z]\\-[A-Z])\\]\\{([0-9])+\\}";
					String result = input;
					Matcher m = Pattern.compile(regex).matcher(input);
					if(m.find()){
						String prefix = m.group(1) + m.group(3);
						String suffix = String.valueOf(Integer.parseInt(m.group(2)) + Integer.parseInt(m.group(4)));
						String replacer = "[" + prefix + "]{" + suffix + "}";
						result = input.replace(m.group(0), replacer);
					}
					
					return result;
				}) 
			);
		
		catalog.add(
				( input -> {
					String regex = "\\[([A-Z]\\-[A-Z])\\]\\{([0-9])+\\}\\[([a-z]\\-[a-z])\\]\\{([0-9])+\\}";
					String result = input;
					Matcher m = Pattern.compile(regex).matcher(input);
					if(m.find()){
						String prefix = m.group(3) + m.group(1);
						String suffix = String.valueOf(Integer.parseInt(m.group(2)) + Integer.parseInt(m.group(4)));
						String replacer = "[" + prefix + "]{" + suffix + "}";
						result = input.replace(m.group(0), replacer);
					}
					
					return result;
				}) 
			);
		
		
		catalog.add(
				( input -> {
					String regex = "\\[([A-Z]\\-[A-Z])\\]\\{([0-9])+\\}\\[(a-zA-Z)\\]\\{([0-9])+\\}";
					String result = input;
					Matcher m = Pattern.compile(regex).matcher(input);
					if(m.find()){
						String prefix = m.group(3) ;
						String suffix = String.valueOf(Integer.parseInt(m.group(2)) + Integer.parseInt(m.group(4)));
						String replacer = "[" + prefix + "]{" + suffix + "}";
						result = input.replace(m.group(0), replacer);
					}
					
					return result;
				}) 
			);
		
		catalog.add(
				( input -> {
					String regex = "\\[([a-z]\\-[a-z])\\]\\{([0-9])+\\}\\[(a-zA-Z)\\]\\{([0-9])+\\}";
					String result = input;
					Matcher m = Pattern.compile(regex).matcher(input);
					if(m.find()){
						String prefix = m.group(3) ;
						String suffix = String.valueOf(Integer.parseInt(m.group(2)) + Integer.parseInt(m.group(4)));
						String replacer = "[" + prefix + "]{" + suffix + "}";
						result = input.replace(m.group(0), replacer);
					}
					
					return result;
				}) 
			);
		
		catalog.add(
				( input -> {
					String regex = "\\[(a-zA-Z)\\]\\{([0-9])+\\}\\[([A-Z]\\-[A-Z])\\]\\{([0-9])+\\}";
					String result = input;
					Matcher m = Pattern.compile(regex).matcher(input);
					if(m.find()){
						String prefix = m.group(3) ;
						String suffix = String.valueOf(Integer.parseInt(m.group(2)) + Integer.parseInt(m.group(4)));
						String replacer = "[" + prefix + "]{" + suffix + "}";
						result = input.replace(m.group(0), replacer);
					}
					
					return result;
				}) 
			);
		
		catalog.add(
				( input -> {
					String regex = "\\[(a-zA-Z)\\]\\{([0-9])+\\}\\[([a-z]\\-[a-z])\\]\\{([0-9])+\\}";
					String result = input;
					Matcher m = Pattern.compile(regex).matcher(input);
					if(m.find()){
						String prefix = m.group(1) ;
						String suffix = String.valueOf(Integer.parseInt(m.group(2)) + Integer.parseInt(m.group(4)));
						String replacer = "[" + prefix + "]{" + suffix + "}";
						result = input.replace(m.group(0), replacer);
					}
					
					return result;
				}) 
			);
		
		
		catalog.add(
				( input -> {
					String regex = "\\[([a-z]\\-[a-z])\\]\\{([0-9])+\\}\\[([0-9]\\-[0-9])\\]\\{([0-9])+\\}";
					String result = input;
					Matcher m = Pattern.compile(regex).matcher(input);
					if(m.find()){
						String prefix = m.group(1) + m.group(3);
						String suffix = String.valueOf(Integer.parseInt(m.group(2)) + Integer.parseInt(m.group(4)));
						String replacer = "[" + prefix + "]{" + suffix + "}";
						result = input.replace(m.group(0), replacer);
					}
					
					return result;
				}) 
			);
		
		
		catalog.add(
				( input -> {
					String regex = "\\[([A-Z]\\-[A-Z])\\]\\{([0-9])+\\}\\[([0-9]\\-[0-9])\\]\\{([0-9])+\\}";
					String result = input;
					Matcher m = Pattern.compile(regex).matcher(input);
					if(m.find()){
						String prefix = m.group(1) + m.group(3);
						String suffix = String.valueOf(Integer.parseInt(m.group(2)) + Integer.parseInt(m.group(4)));
						String replacer = "[" + prefix + "]{" + suffix + "}";
						result = input.replace(m.group(0), replacer);
					}
					
					return result;
				}) 
			);
		
		catalog.add(
				( input -> {
					String regex = "\\[([0-9]\\-[0-9])\\]\\{([0-9])+\\}\\[([A-Z]\\-[A-Z])\\]\\{([0-9])+\\}";
					String result = input;
					Matcher m = Pattern.compile(regex).matcher(input);
					if(m.find()){
						String prefix = m.group(1) + m.group(3);
						String suffix = String.valueOf(Integer.parseInt(m.group(2)) + Integer.parseInt(m.group(4)));
						String replacer = "[" + prefix + "]{" + suffix + "}";
						result = input.replace(m.group(0), replacer);
					}
					
					return result;
				}) 
			);
		
		catalog.add(
				( input -> {
					String regex = "\\[([0-9]\\-[0-9])\\]\\{([0-9])+\\}\\[([a-z]\\-[a-z])\\]\\{([0-9])+\\}";
					String result = input;
					Matcher m = Pattern.compile(regex).matcher(input);
					if(m.find()){
						String prefix = m.group(1) + m.group(3);
						String suffix = String.valueOf(Integer.parseInt(m.group(2)) + Integer.parseInt(m.group(4)));
						String replacer = "[" + prefix + "]{" + suffix + "}";
						result = input.replace(m.group(0), replacer);
					}
					
					return result;
				}) 
			);
		
		
		
	}

	public List<Function<String, String>> getCatalog() {
		return catalog;
	}

	public void setCatalog(List<Function<String, String>> catalog) {
		this.catalog = catalog;
	}
	
	

}
