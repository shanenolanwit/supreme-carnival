package strategy;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import strategy.simple.SimpleRegexiser;
import data.RegexSample;

public class SimpleRegexiserTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBasicMatchers() {
		for(RegexSample sample : RegexSample.values()){
			assertEquals(sample.getOutput(),SimpleRegexiser.getSimpleRegex(sample.getInput()));
		}
	}

}
