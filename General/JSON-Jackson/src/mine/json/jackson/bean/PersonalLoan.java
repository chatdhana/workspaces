package mine.json.jackson.bean;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class PersonalLoan extends Loan {
	private BigDecimal preApprovedAmt;
	private Date drawdownDate;
	private Applicant applicant;
	private List<Applicant> coApplicants;
	private Map<String, ProofDocument> documents;

	public BigDecimal getPreApprovedAmt() {
		return preApprovedAmt;
	}

	public void setPreApprovedAmt(BigDecimal preApprovedAmt) {
		this.preApprovedAmt = preApprovedAmt;
	}

	public Date getDrawdownDate() {
		return drawdownDate;
	}

	public void setDrawdownDate(Date drawdownDate) {
		this.drawdownDate = drawdownDate;
	}

	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}

	public List<Applicant> getCoApplicants() {
		return coApplicants;
	}

	public void setCoApplicants(List<Applicant> coApplicants) {
		this.coApplicants = coApplicants;
	}

	public Map<String, ProofDocument> getDocuments() {
		return documents;
	}

	public void setDocuments(Map<String, ProofDocument> documents) {
		this.documents = documents;
	}

}
