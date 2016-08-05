package mine.json.jackson.overview;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mine.json.jackson.bean.Applicant;
import mine.json.jackson.bean.Loan;
import mine.json.jackson.bean.PersonalLoan;
import mine.json.jackson.bean.ProofDocument;

public class Utility {

	public static String DEFAULT_DATE_FORMAT_PATTERN = "dd-MM-yyyy";
	public static String DATE_FORMAT_PATTERN_DDMMYYYY = "dd MM yyyy";
	public static String DATE_FORMAT_PATTERN_DDMMMYYYY = "dd MMM yyyy";

	public static DateFormat getDefaultDateFormat() {
		return getDefaultDateFormat(null);
	}

	public static DateFormat getDefaultDateFormat(String pattern) {
		DateFormat dateFormat = null;

		if (pattern == null || pattern.trim().isEmpty()) {
			dateFormat = new SimpleDateFormat(DEFAULT_DATE_FORMAT_PATTERN);
		} else {
			dateFormat = new SimpleDateFormat(pattern);
		}
		return dateFormat;
	}

	public static Date getDate(String source) {
		return getDate(source, null);
	}

	public static Date getDate(String source, DateFormat dateFormat) {
		Date parsedDate = null;
		try {
			if (dateFormat == null) {
				parsedDate = getDefaultDateFormat().parse(source);
			} else {
				parsedDate = dateFormat.parse(source);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return parsedDate;
	}
	
	
	public static Loan buildPersonalLoanObject() {
		PersonalLoan pl = new PersonalLoan();

		Applicant primaryApp = new Applicant();
		primaryApp.setName("Primary App Name");
		primaryApp.setDateOfBirth(Utility.getDate("27-01-1987"));
		primaryApp.setOccupation("Software Engineer");

		Applicant coApp1 = new Applicant();
		coApp1.setName("Co-App 1 Name");
		coApp1.setRelationToPrimary("Father");
		coApp1.setDateOfBirth(Utility.getDate("20-05-1950"));
		coApp1.setOccupation("Farmer");

		Applicant coApp2 = new Applicant();
		coApp2.setName("Co-App 2 Name");
		coApp2.setRelationToPrimary("Mother");
		coApp2.setDateOfBirth(Utility.getDate("22-10-1955"));
		coApp2.setOccupation("Farmer");

		List<Applicant> coApplicants = new ArrayList<>();
		coApplicants.add(coApp1);
		coApplicants.add(coApp2);

		ProofDocument proofDoc1 = new ProofDocument();
		proofDoc1.setName("Pay Slip");
		proofDoc1.setType("Salaried Income");

		ProofDocument proofDoc2 = new ProofDocument();
		proofDoc2.setName("Patta of Land");
		proofDoc2.setType("Asset");

		Map<String, ProofDocument> docs = new HashMap<String, ProofDocument>();
		docs.put("Salaried Income", proofDoc1);
		docs.put("Asset", proofDoc2);

		pl.setApplicant(primaryApp);
		pl.setCoApplicants(coApplicants);
		pl.setDocuments(docs);

		pl.setLoanNum(1);
		pl.setPreApprovedAmt(new BigDecimal("100000.55"));
		pl.setLoanCategory("Secured");
		pl.setLoanNature("Personal");
		return pl;
	}
}
