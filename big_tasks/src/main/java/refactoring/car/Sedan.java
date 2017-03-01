package refactoring.car;

public class Sedan extends Car {

    private final static int MAX_SPEED = 120;
    public Sedan(int numberOfPassengers) {
        super(Car.SEDAN, numberOfPassengers);

    }

    @Override
    public int getMaxSpeed() {
        return MAX_SPEED;
    }
}
