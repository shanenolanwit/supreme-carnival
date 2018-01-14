package dean.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class DeanTree {

	private static final String A_Z_LOWER = "[a-z]";
	private static final String A_Z_UPPER = "[A-Z]";
	private static final String ZERO_TO_NINE = "[0-9]";

	private List<String> regexList;

	private List<DeanBranch> branches;

	private String sample;

	public DeanTree(String sample) {
		this.sample = sample;
		this.branches = new ArrayList<DeanBranch>();
		this.regexList = new ArrayList<String>(Arrays.asList(A_Z_LOWER, A_Z_UPPER, ZERO_TO_NINE));
		generateRegex(this.sample, 0, this.sample.length());
	}

	public String getRegex() {
		return this.branches.stream().sorted(Comparator.comparing(DeanBranch::getIndex))		//when all branches are created, we should be able to sort them by their index and join their regex to construct the full regex
									 .map(branch -> branch.getRegex())
									 .collect(Collectors.joining());
	}

	public void generateRegex(String str, int index, int sampleSize) {
		if(sampleSize <= 0)return;
		Pattern pattern = Pattern.compile(this.regexList.get(index) + "{" + (sampleSize) + "}");		//create the pattern using the sampleSize
		Matcher matcher = pattern.matcher(str);
		Matcher sampleMatcher = pattern.matcher(this.sample);
		if(matcher.find() && sampleMatcher.find()) {
			//issue is this last param, because sampleMatcher.find() can pick up a pattern before the one we are searching for
			//eg '12abc12', while working on the last '12', the matcher is going to pick up on the first '12' and the sorting will not work correctly
			this.branches.add(new DeanBranch(str.substring(matcher.start(), matcher.end()), pattern.pattern(), sampleMatcher.start()));	
			generateRegex(Arrays.asList(str.split(pattern.pattern())));	//split the word on the first match to create word sets that need to be worked on
		}else {
			sampleSize = ((index + 1) % regexList.size() == 0) ? sampleSize - 1 : sampleSize;	//only reduce the sampleSize if we tried all of the regex in the regex list
			generateRegex(str, (index + 1) % regexList.size(), sampleSize);	//try again with the same string, different regex, and sample size
		}
	}
	
	private void generateRegex(List<String> splitWords) {
		if(splitWords.isEmpty())return;		//if a full match occurs this will be empty so return we are at the end
		for(String wordSet : splitWords) {
			generateRegex(wordSet, 0, wordSet.length());	//use the generateRegex method for each wordSet/branch
		}
	}
	
	
}
