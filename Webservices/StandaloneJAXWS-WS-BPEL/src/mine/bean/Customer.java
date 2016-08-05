package mine.bean;

import java.util.Date;

public class Customer {
	private String name;
	private String aadhaarId;
	private Date dob;
	private String countryOfBirth;
	private Long annualIncome;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAadhaarId() {
		return aadhaarId;
	}

	public void setAadhaarId(String aadhaarId) {
		this.aadhaarId = aadhaarId;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getCountryOfBirth() {
		return countryOfBirth;
	}

	public void setCountryOfBirth(String countryOfBirth) {
		this.countryOfBirth = countryOfBirth;
	}

	public Long getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(Long annualIncome) {
		this.annualIncome = annualIncome;
	}
	@Override
	public String toString() {
		return "name:" + name + ";aadhaarId:" + aadhaarId + ";dob:" + dob
				+ ";annualIncome:" + annualIncome + ";countryOfBirth:"
				+ countryOfBirth;
	}
}
