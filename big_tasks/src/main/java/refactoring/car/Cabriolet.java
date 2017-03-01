package refactoring.car;

public class Cabriolet extends Car {

    private final static int MAX_SPEED = 90;

    public Cabriolet(int numberOfPassengers) {
        super(Car.CABRIOLET, numberOfPassengers);
    }

    @Override
    public int getMaxSpeed() {
        return MAX_SPEED;
    }
}
