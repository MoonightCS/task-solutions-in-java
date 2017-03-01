package refactoring.car;

public class Truck extends Car {
    private final static int MAX_SPEED = 80;
    public Truck(int numberOfPassengers) {
        super(Car.TRUCK, numberOfPassengers);
    }

    @Override
    public int getMaxSpeed() {
        return MAX_SPEED;
    }
}
