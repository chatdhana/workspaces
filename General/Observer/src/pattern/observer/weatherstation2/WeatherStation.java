package pattern.observer.weatherstation2;

import java.util.Observer;

public class WeatherStation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WeatherData wd = new WeatherData();
		Observer currentCondion = new CurrentConditionsDisplay(wd);
		Observer forecast = new ForecastDisplay(wd);
		Observer statistics = new StatisticsDisplay(wd);
		wd.setMeasurements(81, 60, 30);
		wd.setMeasurements(82, 60, 30);
		wd.setMeasurements(83, 60, 30);
		wd.setMeasurements(84, 60, 30);


	}

}
