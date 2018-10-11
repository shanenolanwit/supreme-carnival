package tree;

public class RegexBranch {

	private String stringSet;
	private String regex;
	private int index;
	
	public RegexBranch(String stringSet, String regex, int index) {
		this.stringSet = stringSet;
		this.regex = regex;
		this.index = index;
	}
	
	public String getRegex() {
		return this.regex;
	}
	
	public int getIndex() {
		return this.index;
	}
	
	public String getStringSet() {
		return this.stringSet;
	}
	
	public boolean isBranchEqual(RegexBranch otherBranch) {
		return this.stringSet.equals(otherBranch.getStringSet()) &&
			   this.regex.equals(otherBranch.getRegex())		 &&
			   this.index == otherBranch.getIndex();
	}
}
