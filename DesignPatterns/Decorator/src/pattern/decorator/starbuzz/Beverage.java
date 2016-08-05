package pattern.decorator.starbuzz;

public abstract class Beverage {
	public String description = "Description Not Found";

	public String getDescription() {
		return description;
	}

	public abstract double cost();
}
