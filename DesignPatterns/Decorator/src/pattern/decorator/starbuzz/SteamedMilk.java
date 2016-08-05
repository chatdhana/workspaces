package pattern.decorator.starbuzz;

public class SteamedMilk extends CondimentsDecorator {

	Beverage beverage;

	public SteamedMilk(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Steamed Milk";
	}

	@Override
	public double cost() {
		return 0.10 + beverage.cost();
	}

}
