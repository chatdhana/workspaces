package mine.bean;

public class Transaction {
	private String transAmount;
	private String accountNumber;
	private String currencyCode;
	private String creditDebitFlag;
	private String creditNarration;

	public String getTransAmount() {
		return transAmount;
	}

	public void setTransAmount(String transAmount) {
		this.transAmount = transAmount;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getCreditDebitFlag() {
		return creditDebitFlag;
	}

	public void setCreditDebitFlag(String creditDebitFlag) {
		this.creditDebitFlag = creditDebitFlag;
	}

	public String getCreditNarration() {
		return creditNarration;
	}

	public void setCreditNarration(String creditNarration) {
		this.creditNarration = creditNarration;
	}
}
