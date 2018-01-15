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
	private static final String NON_ALPHA = "[^a-zA-Z0-9]";


	private List<String> regexList;
	private List<DeanBranch> branches;

	private String sample;

	public DeanTree(String sample) {
		this.sample = sample;
		this.branches = new ArrayList<DeanBranch>();
		this.regexList = new ArrayList<String>(Arrays.asList(A_Z_LOWER, A_Z_UPPER, ZERO_TO_NINE, NON_ALPHA));
		generateRegex(this.sample, 0, this.sample.length());
	}

	/**
	 * Sorts the branches based on their indices, joins them by their regex and replaces all regex which is not needed
	 * @return regex that matches the sample member of theobject
	 */
	public String getRegex() {
		return this.branches.stream().sorted(Comparator.comparing(DeanBranch::getIndex))		//when all branches are created, we should be able to sort them by their index and join their regex to construct the full regex
									 .map(branch -> branch.getRegex())
									 .collect(Collectors.joining());		
	}

	/**
	 * Generates a regex using recursion by populating the branches of the tree
	 * @param str - the string to test 
	 * @param index - the index associated with the regex list to determine which pattern to try
	 * @param sampleSize - the size of the test string
	 */
	public void generateRegex(String str, int index, int sampleSize) {
		if(sampleSize <= 0)return;
		String regexToTry = this.regexList.get(index);
		Pattern pattern = Pattern.compile("(?<!" + regexToTry + ")(" + regexToTry + "{" + (sampleSize) + "})(?!" + regexToTry + ")");		//create the pattern using the sampleSize
		Matcher matcher = pattern.matcher(str);
		if(matcher.find()) {
			createBranches(pattern);		//create branches from the match
			generateRegex(Arrays.asList(str.split(pattern.pattern())));	//split the word on the first match to create word sets that need to be worked on
		}else {
			sampleSize = ((index + 1) % regexList.size() == 0) ? sampleSize - 1 : sampleSize;	//only reduce the sampleSize if we tried all of the regex in the regex list
			generateRegex(str, (index + 1) % regexList.size(), sampleSize);	//try again with the same string, different regex, and sample size
		}
	}
	
	/**
	 * Calls the other generateRegex method on remaining words after first major match
	 * @param splitWords - the words that were split
	 */
	private void generateRegex(List<String> splitWords) {
		if(splitWords.isEmpty())return;		//if a full match occurs this will be empty so return we are at the end
		for(String wordSet : splitWords) {
			generateRegex(wordSet, 0, wordSet.length());	//use the generateRegex method for each wordSet/branch
		}
	}
	
	/**
	 * Uses matcher and pattern to create branches for the tree based off the capture groups found
	 * @param matcher - matcher object used to test the string
	 * @param pattern - pattern used to create the matcher
	 */
	private void createBranches(Pattern pattern) {
		Matcher matcher = pattern.matcher(this.sample);
		String replacementPattern = pattern.pattern().replaceAll("(\\)?\\(\\?<?!\\[.{3,10}\\]\\)\\(?)","");
		while(matcher.find()) {
			for(int i = 1; i <= matcher.groupCount(); i++) {
				String group = matcher.group(i);	//loop over all capture groups that were matched and insert them as a branch if they are not already a branch
				if(!branchExists(group, replacementPattern, matcher.start())) {
					this.branches.add(new DeanBranch(group, replacementPattern, matcher.start()));
				}
			}
		}
	}
	
	/**
	 * Check to see if branch already exists in the tree
	 * @param str - the string to see if a branch already contains it in the tree
	 * @param regex - regex to see if branch already contains it in the tree
	 * @param index - index to see if there is a branch that already contains it in the tree
	 * @return
	 */
	private boolean branchExists(String str, String regex, int index) {
		return this.branches.stream()
							.anyMatch(branch -> branch.isBranchEqual(new DeanBranch(str, regex, index)));
	}
	
}
