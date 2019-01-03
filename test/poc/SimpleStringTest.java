package poc;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SimpleStringTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		String sample1 = "abc123batman-999";		
		String sample2 = "abc123";		
		assertEquals("\\D{3}\\d{3}\\D{6}.{1}\\d{3}", SimpleString.analyse(sample1));
		assertEquals("\\D{3}\\d{3}", SimpleString.analyse(sample2));
	}
	
	@Test
	public void testTwo() {
		List<String> subsets = StringSims.getSubsets("abcd");
		assertEquals(10, subsets.size());
		assertEquals("abcd", subsets.get(0));
	}
	
	@Test
	public void testThree(){
		List<String> candidates = Arrays.asList("abcdBATMAN12w","BATMANxyz","911BATMAN","e1eBATMANyui","0BATMAN0");
		assertEquals(Arrays.asList("BATMAN","BATMAN","BATMAN","BATMAN","BATMAN"), StringSims.extractMatches(candidates, StringSims.lazyMatchRegex(candidates)));
		
		
		candidates = Arrays.asList("1234asdASD1","23redTT","oiugsoiugs898abcYO5"); 
		assertEquals("^(.*?)([0-9]{2}[a-z]{3}[A-Z]{2})(.*?)$", StringSims.lazyMatchRegex(candidates));
		assertEquals(Arrays.asList("34asdAS","23redTT","98abcYO"), StringSims.extractMatches(candidates, StringSims.lazyMatchRegex(candidates)));
		
		candidates = Arrays.asList("shanen@gmail.com","deanGaffney@yahoo.com","conor@junior.net","jimmy@wit.ie"); 
		System.out.println(StringSims.lazyMatchRegex(candidates));
//		assertEquals("^(.*?)([a-zA-Z]{5,11})(.*?)$", StringSims.lazyMatchRegex(candidates));
//		assertEquals(Arrays.asList("34asdAS","23redTT","98abcYO"), StringSims.extractMatches(candidates, StringSims.lazyMatchRegex(candidates)));
		
//		candidates = Arrays.asList("<iugiulg>EN104,jhndoe<xml>","<sometag>IE4548<gsp>","<blah>UK333<x<M>");
//		assertEquals(Arrays.asList("EN104","IE454","UK333"), StringSims.extractMatches(candidates, StringSims.lazyMatchRegex(candidates)));
		
		
	}
	
}
