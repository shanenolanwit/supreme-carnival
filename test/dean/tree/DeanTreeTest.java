package dean.tree;

import static org.junit.Assert.*;

import org.junit.Test;

import data.RegexSample;

public class DeanTreeTest {

	@Test
	public void test() {
//		String sample1 = "aaBBBBBabc";
//		String sample2 = "BBBBBaaaaa";
//		String sample3 = "123abABCD12";
//		String sample4 = "abc123abc";
//		String sample5 = "123-123-123";
//		String sample6 = "20/03/1996";
//		String sample7 = "dean@gmail.com";
//		
//		assertEquals("([a-z]{2})([A-Z]{5})([a-z]{3})", new DeanTree(sample1).getRegex());				//this passes
//		assertEquals("([A-Z]{5})([a-z]{5})", new DeanTree(sample2).getRegex());							//this passes
//		assertEquals("([0-9]{3})([a-z]{2})([A-Z]{4})([0-9]{2})", new DeanTree(sample3).getRegex());		//this passes
//		assertEquals("([a-z]{3})([0-9]{3})([a-z]{3})", new DeanTree(sample4).getRegex());				//this passes
//		assertEquals("([0-9]{3})([^a-zA-Z0-9]{1})([0-9]{3})([^a-zA-Z0-9]{1})([0-9]{3})", new DeanTree(sample5).getRegex());				//this passes
//		assertEquals("([0-9]{2})([^a-zA-Z0-9]{1})([0-9]{2})([^a-zA-Z0-9]{1})([0-9]{4})", new DeanTree(sample6).getRegex());				//this passes
//		assertEquals("([a-z]{4})([^a-zA-Z0-9]{1})([a-z]{5})([^a-zA-Z0-9]{1})([a-z]{3})", new DeanTree(sample7).getRegex());				//this passes
	
			
		for(RegexSample sample : RegexSample.values()){
			assertEquals(sample.getOutput(), new DeanTree(sample.getInput()).getRegex());
		}
	}

}
