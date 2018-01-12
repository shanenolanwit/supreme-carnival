package dean;

import static org.junit.Assert.*;

import org.junit.Test;

public class DeanStrategyTest {
	

	@Test
	public void test() {
		System.out.println(DeanStrategy.analyse("abc123abc123"));
	}
	
	@Test
	public void matcherCountTest() {
		assertEquals(3, DeanStrategy.getMatchedCount("abc123abc123"));	
	}

}
