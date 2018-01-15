package poc;

import static org.junit.Assert.*;

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
	
}
