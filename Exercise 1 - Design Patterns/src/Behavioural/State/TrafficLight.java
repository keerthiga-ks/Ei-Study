package Behavioural.State;

public class TrafficLight {
    public enum LightState { RED, GREEN, YELLOW }
    private LightState state = LightState.RED;

    public void nextState() {
        switch(state) {
            case RED: state = LightState.GREEN; break;
            case GREEN: state = LightState.YELLOW; break;
            case YELLOW: state = LightState.RED; break;
        }
    }

    public LightState getState() { return state; }
}
