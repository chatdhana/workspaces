package pattern.observer.weatherstation1;

/**
 * The Subject, implement me to create Observable/Publisher, objects or
 * subscribers use this interface for register/remove themselves from being
 * Observers.
 * 
 * @author dhana
 */
public interface Subject {
	void registerObserver(Observer obsr);
	void removeObserver(Observer obsr);
	void notifyObservers();
}
