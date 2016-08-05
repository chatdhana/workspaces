package pattern.observer.weatherstation1;

/**
 * The Observer, all our weather components implement this interface to become
 * an observer.
 * 
 * @author dhana
 */
public interface Observer {
	void update(float temp, float humidity, float pressure);
}
