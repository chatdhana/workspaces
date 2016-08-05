package mine.json.jackson.databinding;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

import mine.json.jackson.bean.Loan;
import mine.json.jackson.bean.PersonalLoan;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MyLoanObjectMapper {
	private static ObjectMapper mapper = null;

	static {
		mapper = new ObjectMapper();
	}

	public static void main(String[] args) {
		serialize();
		deserialize();
	}

	private static void serialize() {
		try {
			PersonalLoan pl = new PersonalLoan();
			pl.setLoanNum(1);
			pl.setLoanNature("PersonalLoan");
			pl.setPreApprovedAmt(new BigDecimal("10000.01"));

			mapper.writeValue(new File("./io/serialize-out-loan.json"), pl);
			// System.out.println(mapper.writeValueAsString(pl));

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void deserialize() {
		try {
			PersonalLoan pl = mapper.readValue(new File("./io/serialize-out-loan.json"), PersonalLoan.class);
			System.out.println(pl.getLoanNature());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
