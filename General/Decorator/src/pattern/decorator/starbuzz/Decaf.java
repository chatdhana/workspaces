package pattern.decorator.starbuzz;

public class Decaf extends Beverage {

	public Decaf() {
		description = "Decf Coffee";
	}

	@Override
	public double cost() {
		return 1.05;
	}

}
