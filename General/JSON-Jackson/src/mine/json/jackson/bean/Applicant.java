package mine.json.jackson.bean;

import java.util.Date;


public class Applicant {
	private String name;
	private Date dateOfBirth;
	private String occupation;
	private String relationToPrimary;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getRelationToPrimary() {
		return relationToPrimary;
	}

	public void setRelationToPrimary(String relationToPrimary) {
		this.relationToPrimary = relationToPrimary;
	}

}
