package pattern.observer.weatherstation1;

import java.util.HashSet;
import java.util.Set;

public class WeatherData implements Subject {
	Set<Observer> observersList = null;
	private float temp;
	private float humidity;
	private float pressure;

	public WeatherData() {
		observersList = new HashSet<Observer>();
	}

	public void registerObserver(Observer obsr) {
		observersList.add(obsr);

	}

	public void removeObserver(Observer obsr) {
		observersList.remove(obsr);
	}

	public void notifyObservers() {
		for (Observer obsr : observersList) {
			obsr.update(temp, humidity, pressure);
		}
	}

	void measurementsChanged() {
		notifyObservers();
	}

	void setMeasurements(float temp, float humidity, float presure) {
		this.temp = temp;
		this.humidity = humidity;
		this.pressure = presure;
		measurementsChanged();
	}

}
