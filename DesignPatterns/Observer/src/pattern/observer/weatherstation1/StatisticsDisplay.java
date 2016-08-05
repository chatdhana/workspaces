package pattern.observer.weatherstation1;

public class StatisticsDisplay implements DisplayElement, Observer {
	Subject sub;
	private float temp;
	private float humidity;
	private float pressure;

	public StatisticsDisplay(Subject sub) {
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
		System.out.print("Statistic- Temparature:" + temp + "F Degrees");
		System.out.print(" Humidity:" + humidity + "%");
		System.out.println(" Pressure: " + pressure);
	}

}
