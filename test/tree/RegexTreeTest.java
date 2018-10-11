package tree;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import data.RegexSample;
import tree.RegexTree;

public class RegexTreeTest {

	@Test
	public void test() {
		for(RegexSample sample : RegexSample.values()){
			assertEquals(sample.getOutput(), new RegexTree(sample.getInput()).getRegex());
		}
	}

}
