package dean;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DeanStrategyTest {
	

	@Test
	public void test() {
		String sample1 = "abc123BatMan999AZ";
		String sample2 = "abc123BatMan-999AZ";
		String sample3 = "abc123abc123abcd1234";
		
		DeanStrategy dean = new DeanStrategy();

		assertEquals("[a-z]{3}[0-9]{3}[a-zA-Z]{6}[0-9]{3}[A-Z]{2}", dean.analyse(sample1));
		assertEquals("[a-z]{3}[0-9]{3}[a-zA-Z]{6}[^a-zA-Z0-9]{1}[0-9]{3}[A-Z]{2}", dean.analyse(sample2));
		assertEquals("[a-z]{3}[0-9]{3}[a-z]{3}[0-9]{3}[a-z]{4}[0-9]{4}", dean.analyse(sample3));

	}


}
