package bag;

import java.util.Map;

public class ProductUtility {

	public static void main(String[] args) {
		Card card = new Card();
		card.setName("CC");
		card.setCode("1");
		card.setCardType("Master");
		card.x="C";
		Loan loan = new Loan();
		loan.setName("PL");
		loan.setCode("2");
		loan.setLoanType("PLoan");

		 processProduct(card);
		 processProduct(loan);

//		Product prod = card;
//		processProduct(prod);

	}

	static void processProduct(Product prod) {
		System.out.println(prod.getCode());
		System.out.println(prod.getName());
//		System.out.println(prod.x);
		System.out.println(((Card)prod).x);
		System.out.println(prod.x);

		// if(prod instanceof Card){
		// Card card = (Card) prod;
		// System.out.println(card.getCardType());
		// }
	}
}

abstract class Product {
	String code;
	String name;
	String x = "P";

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	 Object displayProd() throws Exception {
		System.out.println("From Prod");
		return null;
	}

}

class Card extends Product {
	String cardType;
	String x;
	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public Card displayProd() throws RuntimeException{
		System.out.println("From Card");
		return this;
	}
}

class Loan extends Product {
	String loanType;

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

}