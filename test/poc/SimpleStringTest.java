package poc;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.RegexSample;

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
		
		
	}
	
	@Test
	public void testOptimisation(){
//		assertEquals("[a-zA-Z]{5}", StringSims.optimiseRegex("[a-z]{3}[A-Z]{2}"));		
//		assertEquals("[a-zA-Z]{5}", StringSims.optimiseRegex("[A-Z]{3}[a-z]{2}"));
		assertTrue(StringSims.optimiseRegex("[A-Z]{3}[a-z]{2}[A-Z]{3}[a-z]{2}").contains("[A-Z]{3}[a-zA-Z]{5}[a-z]{2}"));
		assertTrue(StringSims.optimiseRegex("[A-Z]{3}[a-z]{2}[A-Z]{3}[a-z]{2}").contains("[a-zA-Z]{8}[a-z]{2}"));
		assertTrue(StringSims.optimiseRegex("[A-Z]{3}[a-z]{2}[A-Z]{3}[a-z]{2}").contains("[a-zA-Z]{10}"));
		
		
		
		assertTrue(StringSims.optimiseRegex("[a-z]{1}[A-Z]{3}").contains("[a-zA-Z]{4}"));
		assertTrue(StringSims.optimiseRegex("[A-Z]{1}[a-z]{3}").contains("[a-zA-Z]{4}"));
		assertTrue(StringSims.optimiseRegex("[a-z]{1}[a-zA-Z]{4}").contains("[a-zA-Z]{5}"));
		assertTrue(StringSims.optimiseRegex("[A-Z]{1}[a-zA-Z]{4}").contains("[a-zA-Z]{5}"));
		assertTrue(StringSims.optimiseRegex("[a-zA-Z]{3}[A-Z]{4}").contains("[a-zA-Z]{7}"));
		assertTrue(StringSims.optimiseRegex("[a-zA-Z]{3}[a-z]{4}").contains("[a-zA-Z]{7}"));
		
		assertTrue(StringSims.optimiseRegex("[a-z]{4}[0-9]{4}").contains("[a-z0-9]{8}"));
		assertTrue(StringSims.optimiseRegex("[A-Z]{4}[0-9]{4}").contains("[A-Z0-9]{8}"));
		assertTrue(StringSims.optimiseRegex("[0-9]{4}[A-Z]{4}").contains("[A-Z0-9]{8}"));
		assertTrue(StringSims.optimiseRegex("[0-9]{5}[a-z]{4}").contains("[a-z0-9]{9}"));
		
		assertTrue(StringSims.optimiseRegex("[a-zA-Z]{11}[0-9]{1}").contains("[a-zA-Z0-9]{12}"));
		assertTrue(StringSims.optimiseRegex("[0-9]{11}[a-zA-Z]{21}").contains("[a-zA-Z0-9]{32}"));
		
		assertTrue(StringSims.optimiseRegex("[a-zA-Z0-9]{8}[a-z]{1}").contains("[a-zA-Z0-9]{9}"));
		assertTrue(StringSims.optimiseRegex("[a-zA-Z0-9]{8}[A-Z]{2}").contains("[a-zA-Z0-9]{10}"));
		assertTrue(StringSims.optimiseRegex("[a-zA-Z0-9]{5}[0-9]{2}").contains("[a-zA-Z0-9]{7}"));
		assertTrue(StringSims.optimiseRegex("[0-9]{2}[a-zA-Z0-9]{5}").contains("[a-zA-Z0-9]{7}"));
		assertTrue(StringSims.optimiseRegex("[a-z]{3}[a-zA-Z0-9]{5}").contains("[a-zA-Z0-9]{8}"));
		assertTrue(StringSims.optimiseRegex("[A-Z]{4}[a-zA-Z0-9]{5}").contains("[a-zA-Z0-9]{9}"));
		
		
		
	}
	
}
