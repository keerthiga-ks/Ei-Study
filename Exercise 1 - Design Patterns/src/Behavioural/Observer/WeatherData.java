package Behavioural.Observer;

import java.util.*;

public class WeatherData {
    private List<DisplayDevice> observers = new ArrayList<>();
    private float temperature;
    private float humidity;

    public void registerObserver(DisplayDevice o) { observers.add(o); }
    public void removeObserver(DisplayDevice o) { observers.remove(o); }

    public void notifyObservers() {
        for (DisplayDevice o : observers) o.update(temperature, humidity);
    }

    public void setMeasurements(float temperature, float humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
        notifyObservers();
    }

    public List<DisplayDevice> getObservers() { return observers; }
}
