package utils;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class RegexFinderTest {
	
	List<String> names;
	
	@Before
	public void setup() {
		this.names = Arrays.asList("michaelangelo", "donatello", "shredder", "splinter");
	}

	@Test
	public void test() {
		List<List<String>> regexLists = Arrays.asList(
											Arrays.asList(this.names.get(0)),
											Arrays.asList(this.names.get(1), this.names.get(0))
										);
		
		assertEquals(this.names.get(0), RegexFinder.compareRegexes(regexLists));
	}

}
