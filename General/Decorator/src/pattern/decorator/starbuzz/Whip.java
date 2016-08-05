package pattern.decorator.starbuzz;

public class Whip extends CondimentsDecorator {

	Beverage beverage;

	public Whip(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Whiped";
	}

	@Override
	public double cost() {
		return 0.10 + beverage.cost();
	}

}
