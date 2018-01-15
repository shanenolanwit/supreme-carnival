package dean.tree;

public class DeanBranch {

	private String stringSet;
	private String regex;
	private int index;
	
	public DeanBranch(String stringSet, String regex, int index) {
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
	
	public boolean isBranchEqual(DeanBranch otherBranch) {
		return this.stringSet.equals(otherBranch.getStringSet()) &&
			   this.regex.equals(otherBranch.getRegex())		 &&
			   this.index == otherBranch.getIndex();
	}
}