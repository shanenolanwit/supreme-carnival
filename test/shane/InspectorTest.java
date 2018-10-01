package shane;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import poc.Inspector;

public class InspectorTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Inspector i = new Inspector();
		assertEquals("[a-z]+[0-9]+[a-zA-Z]+[^a-zA-Z0-9]+[A-Z]+", i.simplify("aaa09AbcDe-AZ"));
	}
	
}