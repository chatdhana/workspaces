package pattern.observer.weatherstation2;

import java.util.Observable;

public class WeatherData extends Observable {
	private float temp;
	private float humidity;
	private float pressure;

	void measurementsChanged() {
		setChanged();
		notifyObservers();
	}

	void setMeasurements(float temp, float humidity, float presure) {
		this.temp = temp;
		this.humidity = humidity;
		this.pressure = presure;
		measurementsChanged();
	}

	public float getTemp() {
		return temp;
	}

	public float getHumidity() {
		return humidity;
	}

	public float getPressure() {
		return pressure;
	}

}
