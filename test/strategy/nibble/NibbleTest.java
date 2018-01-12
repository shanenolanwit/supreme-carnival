package strategy.nibble;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NibbleTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		String sample1 = "abc123BatMan999AZ";
		String sample2 = "abc123BatMan-999AZ";
				
		assertEquals("[a-z]{3}[0-9]{3}[a-zA-Z]{6}[0-9]{3}[A-Z]{2}", new Nibbler(sample1).getRegex());
		assertEquals("[a-z]{3}[0-9]{3}[a-zA-Z]{6}[^a-zA-Z0-9]{1}[0-9]{3}[A-Z]{2}", new Nibbler(sample2).getRegex());

	}
	
}
