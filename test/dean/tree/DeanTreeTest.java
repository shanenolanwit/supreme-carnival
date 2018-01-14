package dean.tree;

import static org.junit.Assert.*;

import org.junit.Test;

public class DeanTreeTest {

	@Test
	public void test() {
		String sample1 = "aaBBBBBabc";
		String sample2 = "BBBBBaaaaa";
		String sample3 = "123abABCD12";
		
		assertEquals("[a-z]{2}[A-Z]{5}[a-z]{3}", new DeanTree(sample1).getRegex());		//this passes
		assertEquals("[A-Z]{5}[a-z]{5}", new DeanTree(sample2).getRegex());				//this passes
		assertEquals("[0-9]{3}[a-z]{2}[A-Z]{4}[0-9]{2}", new DeanTree(sample3).getRegex());		//this is a sorting issue, see the generateRegex method for detailed comment
	}

}
