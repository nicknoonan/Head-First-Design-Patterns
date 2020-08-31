package headfirst.designpatterns.observer.weatherobservable;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class ArchiveDisplay implements Observer, DisplayElement {
    ArrayList<Float> temperatureArchive;
	public ArchiveDisplay(Observable observable) {
        observable.addObserver(this);
        temperatureArchive = new ArrayList<Float>();
	}
	public void update(Observable observable, Object arg) {
		if (observable instanceof WeatherData) {
            WeatherData weatherData = (WeatherData)observable;
            if (arg == null) {
                // pull implementation
                temperatureArchive.add(weatherData.getTemperature());
            } else {
                // push implementation
            }
		}
	}
	public void display() {
        System.out.println("Temperatures");
        for (int i = 0; i < temperatureArchive.size(); i++){
            System.out.println(temperatureArchive.get(i));
        }
	}
}
