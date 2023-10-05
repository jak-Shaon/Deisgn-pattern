import java.util.ArrayList;
import java.util.List;

interface WeatherStation {
    void addObserver(WeatherObserver observer);
    void removeObserver(WeatherObserver observer);
    void notifyObservers();
    int getTemperature();
    void setTemperature(int temperature);
}

class WeatherData implements WeatherStation {
    private int temperature;
    private List<WeatherObserver> observers;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    @Override
    public void addObserver(WeatherObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(WeatherObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (WeatherObserver observer : observers) {
            observer.update();
        }
    }

    @Override
    public int getTemperature() {
        return temperature;
    }

    @Override
    public void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyObservers();
    }
}

interface WeatherObserver
{
    void update();
}

class TemperatureDisplay implements WeatherObserver
{
    private WeatherStation weatherStation;

    public TemperatureDisplay(WeatherStation weatherStation) {
        this.weatherStation = weatherStation;
        weatherStation.addObserver(this);
    }

    @Override
    public void update() {
        int temperature = weatherStation.getTemperature();
        System.out.println("Temperature Display: Temperature is now " + temperature + " degrees Celsius.");
    }
}
class WeatherApp {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherData();
        TemperatureDisplay tempDisplay = new TemperatureDisplay(weatherStation);

        weatherStation.setTemperature(25); // Weather data changes, and the temperature display is updated.
        weatherStation.setTemperature(30);
    }
}
