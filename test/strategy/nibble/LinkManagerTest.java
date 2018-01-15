package strategy.nibble;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.RegexSample;
import strategy.links.LinkManager;

public class LinkManagerTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		LinkManager m = new LinkManager();

		
		for(RegexSample sample : RegexSample.values()){
			assertEquals(sample.getOutput(),m.getRegex(sample.getInput()));
		}
	}
	
}