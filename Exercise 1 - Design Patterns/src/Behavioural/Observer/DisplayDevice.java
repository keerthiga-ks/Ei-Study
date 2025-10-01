package Behavioural.Observer;

public class DisplayDevice {
    private String name;

    public DisplayDevice(String name) { this.name = name; }

    public void update(float temperature, float humidity) {
        System.out.println(name + " Display -> Temperature: " + temperature + "°C, Humidity: " + humidity + "%");
    }

    public String getName() { return name; }
}
