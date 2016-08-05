package pattern.decorator.starbuzz;

public class StarbuzzCoffee {
	public static void main(String[] args) {
		System.out.println("Welcome to Starbuzz Coffee!");

		// order 1: Simply Dark Roast coffee
		Beverage order1 = new DarkRoast();
		System.out.println("Order 1: " + order1.getDescription() + " | Cost: "
				+ order1.cost());
		
		// order 2: Espresso mocha whip
		Beverage order2 = new Espresso();
		order2 = new Mocha(order2);
		order2 = new Whip(order2);
		System.out.println("Order 2: "+ order2.getDescription()+" |  Cost: "+ order2.cost());
		
		// order 3: Espresso double mocha whip
		Beverage order3 = new Whip(new Mocha(new Mocha(new Espresso())));
		System.out.println("Order 3: "+ order3.getDescription()+" |  Cost: "+ order3.cost());
		
	}
}
