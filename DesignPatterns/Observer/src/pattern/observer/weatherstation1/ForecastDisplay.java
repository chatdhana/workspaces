package pattern.observer.weatherstation1;

public class ForecastDisplay implements Observer, DisplayElement {
	Subject sub;
	private float temp;
	private float humidity;
	private float pressure;

	public ForecastDisplay(Subject sub) {
		this.sub = sub;
		sub.registerObserver(this);
	}
	public void update(float temp, float humidity, float pressure) {
		this.temp = temp;
		this.humidity = humidity;
		this.pressure = pressure;
		display();
	}

	public void display() {
		System.out.print("Forecast - Temparature:" + temp + "F Degrees");
		System.out.print(" Humidity:" + humidity + "%");
		System.out.println(" Pressure: " + pressure);
	}
}
