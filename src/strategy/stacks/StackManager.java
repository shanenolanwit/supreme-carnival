package strategy.stacks;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Used to normalise regex pairs
 * [a-z]{2} used to match String1 and [a-z]{7} used to match String2 becomes [a-z]{2,7} to match both String1 and String2
 */
public class StackManager {
	
	public String normalise(String a, String b){
		//https://docs.oracle.com/javase/8/docs/api/java/util/Stack.html
		//A more complete and consistent set of LIFO stack operations is provided by the 
		//Deque interface and its implementations, which should be used in preference to this class
		//https://docs.oracle.com/javase/8/docs/api/java/util/Deque.html
		Deque<String> stackA = new ArrayDeque<>();
		Deque<String> stackB = new ArrayDeque<>();
		
		while(!a.isEmpty()){
			System.out.println(a);
			int marker = a.indexOf("}") + 1;
			stackA.push(a.substring(0, marker));
			a = a.substring(marker);			
		}
		
		while(!b.isEmpty()){
			System.out.println(b);
			int marker = b.indexOf("}") + 1;
			stackB.push(b.substring(0, marker));
			b = b.substring(marker);			
		}
		
		StringBuilder sb = new StringBuilder();
		while(!(stackA.isEmpty() && stackB.isEmpty())){
			sb.append(normaliseSection(stackA.removeLast(), stackB.removeLast()));
		}
		while(!stackA.isEmpty()){
			sb.append(stackA.removeLast() + "?");
		}
		while(!stackB.isEmpty()){
			sb.append(stackB.removeLast() + "?");
		}
		
		
		
		return sb.toString();
		
	}
	
	public String normaliseSections(String... strs){
		StringBuilder sb = new StringBuilder();
		Set<String> se = new TreeSet<String>();
		se.addAll(
				Arrays.asList(strs)
				.stream()
				.map(s -> s.substring(1, s.indexOf("]"))).collect(Collectors.toList()));
		if(se.size()>1){
			//not the same
		}else {
			sb.append(strs[0].substring(0, strs[0].indexOf("]")+1));
			List<Integer> allTheInts = Stream.of(strs)
					.map(s -> Integer.valueOf(s.substring(s.indexOf("{")+1, s.indexOf("}"))))
					.sorted()
					.collect(Collectors.toList());
					
					
			sb.append("{" + allTheInts.stream().min((x,y) -> Integer.compare(x, y)).get() + "," + allTheInts.stream().max((x,y) -> Integer.compare(x, y)).get() + "}");
			
		}
		
		return sb.toString();
	}
	
	public String normaliseSection(String a, String b){
		String subStringA1 = a.substring(1, a.indexOf("]"));
		String subStringB1 = b.substring(1, b.indexOf("]"));
		
		String subStringA2 = a.substring(a.indexOf("{") +1, a.indexOf("}"));
		String subStringB2 = b.substring(b.indexOf("{") +1, b.indexOf("}"));
		
		StringBuilder sb = new StringBuilder();
		if(subStringA1.equals(subStringB1)){
			sb.append("[" + subStringA1 + "]");
			if(subStringA2.equals(subStringB2)){
				sb.append("{" + subStringA2 + "}");
			}else{
				Integer ai = Integer.valueOf(subStringA2);
				Integer bi = Integer.valueOf(subStringB2);
				String combined = ai<bi ? ai+","+bi : bi+","+ai;
				sb.append("{" + combined + "}");
			}
		} else{
			sb.append("(" + a + "|" + b + ")");
		}
		
		return sb.toString();
	}

}
