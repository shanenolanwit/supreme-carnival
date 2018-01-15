package dean.tree;

import static org.junit.Assert.*;

import org.junit.Test;

import data.RegexSample;

public class DeanTreeTest {

	@Test
	public void test() {
		for(RegexSample sample : RegexSample.values()){
			assertEquals(sample.getOutput(), new DeanTree(sample.getInput()).getRegex());
		}
	}

}
