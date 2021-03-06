package pattern.observer.weatherstation2;

import java.util.Observable;
import java.util.Observer;

public class ForecastDisplay implements Observer, DisplayElement {
	Observable obs;
	private float temp;
	private float humidity;
	private float pressure;

	public ForecastDisplay(Observable obs) {
		this.obs = obs;
		obs.addObserver(this);
	}

	public void update(Observable obs, Object arg) {
		if (obs instanceof WeatherData) {
			WeatherData wd = (WeatherData) obs;
			this.temp = wd.getTemp();
			this.humidity = wd.getHumidity();
			this.pressure = wd.getPressure();
		}
		display();
	}

	public void display() {
		System.out.print("Forecast - Temparature:" + temp + "F Degrees");
		System.out.print(" Humidity:" + humidity + "%");
		System.out.println(" Pressure: " + pressure);
	}
}
