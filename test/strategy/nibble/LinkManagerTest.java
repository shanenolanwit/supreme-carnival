package strategy.nibble;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
		assertEquals("[A-Z]{2}[a-z]{3}[A-Z]{3}[0-9]{3}[^a-zA-Z0-9]{2}[a-z]{3}", m.getRegex("BBasbAAA087--bbb"));
		assertEquals("[A-Z]{1}[0-9]{4}[^a-zA-Z0-9]{2}[0-9]{4}[a-z]{1}", m.getRegex("B1234--4321a"));
		assertEquals("[A-Z]{1}[a-z]{4}[A-Z]{2}[0-9]{2}", m.getRegex("HelloSN18"));
	}
	
}