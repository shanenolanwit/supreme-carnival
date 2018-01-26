package strategy.nibble;

import static org.junit.Assert.*;

import java.util.Arrays;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.RegexSample;
import strategy.links.LinkManager;
import strategy.links.SubstringLinkManager;
import strategy.stacks.StackManager;

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

		
		for(RegexSample sample : RegexSample.values()){
			assertEquals(sample.getOutput(),m.getRegex(sample.getInput()));
		}
	}
	
	@Test
	public void testTwo() {
		StackManager m = new StackManager();
		String regexA = "[a-z]{6}[0-9]{3}[A-Z]{3}[0-9]{3}";
		String regexB = "[a-z]{8}[0-9]{3}[A-Z]{3}[0-9]{4}";
		String regexNormalised = m.normalise(regexA, regexB);
		assertEquals("[a-z]{6,8}[0-9]{3}[A-Z]{3}[0-9]{3,4}",regexNormalised);
		String normSectionA = m.normaliseSection("[a-z]{8}", "[a-z]{6}");
		assertEquals("[a-z]{6,8}", normSectionA);
		String normSectionB = m.normaliseSection("[a-z]{8}", "[0-9]{7}");
		assertEquals("([a-z]{8}|[0-9]{7})", normSectionB);
		//assertEquals("[a-z]{6,8}[0-9]{3}[A-Z]{3}[0-9]{3,4}",m.normaliseSections(regexA,regexB));
	}
	
	@Test
	public void testSubstringsAndRegexes(){
		
		assertEquals("[a-z]{3,4}BATMAN[0-9]{2,3}", 
				SubstringLinkManager.getRegex(Arrays.asList("abcdBATMAN123","xyzBATMAN456","defBATMAN45")));
		assertEquals("(.*?)BATMAN[0-9]{2,3}", 
				SubstringLinkManager.getRegex(Arrays.asList("BATMAN123","xyzBATMAN456","defBATMAN45")));
		assertEquals("[a-z]{3,4}BATMAN(.*?)", 
				SubstringLinkManager.getRegex(Arrays.asList("abcdBATMAN","xyzBATMAN456","defBATMAN45")));
		assertEquals("[a-z]{3,4}BATMAN[^a-zA-Z0-9]{2,3}", 
				SubstringLinkManager.getRegex(Arrays.asList("abcdBATMAN@#","xyzBATMAN#=!","defBATMAN##")));
		
		assertEquals("[a-z]{3,4}(.*?)BATMAN[0-9]{2,3}", 
				SubstringLinkManager.getRegex(Arrays.asList("abcd88BATMAN123","xyzBATMAN456","defBATMAN45")));
		assertEquals("[a-z]{3,4}BATMAN[0-9]{2,3}XXX[0-9]{1,1}", 
				SubstringLinkManager.getRegex(Arrays.asList("abcdBATMAN123XXX1","xyzBATMAN45XXX7","defBATMAN451XXX0")));

	}
	
}