package mine.json.jackson.bean;


public abstract class Loan {

	private int loanNum;
	private String loanCategory;
	private String loanNature;

	public int getLoanNum() {
		return loanNum;
	}

	public void setLoanNum(int loanNum) {
		this.loanNum = loanNum;
	}

	public String getLoanCategory() {
		return loanCategory;
	}

	public void setLoanCategory(String loanCategory) {
		this.loanCategory = loanCategory;
	}

	public String getLoanNature() {
		return loanNature;
	}

	public void setLoanNature(String loanNature) {
		this.loanNature = loanNature;
	}

}
