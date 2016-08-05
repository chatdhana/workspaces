package mine.json.jackson.bean;

import java.util.Date;

public class MortgageLoan extends Loan {

	private boolean propertyAvailable;
	private String mortgageType;
	private Date[] disbursementDates;

	public boolean isPropertyAvailable() {
		return propertyAvailable;
	}

	public void setPropertyAvailable(boolean propertyAvailable) {
		this.propertyAvailable = propertyAvailable;
	}

	public String getMortgageType() {
		return mortgageType;
	}

	public void setMortgageType(String mortgageType) {
		this.mortgageType = mortgageType;
	}

	public Date[] getDisbursementDates() {
		return disbursementDates;
	}

	public void setDisbursementDates(Date[] disbursementDates) {
		this.disbursementDates = disbursementDates;
	}

}
