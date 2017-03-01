package refactoring.car;

import java.util.Date;

/*
12.1.2. Перепиши метод getNumberOfPassengersCanBeTransferred(), объединив условные
операторы (используй метод canPassengersBeTransferred()).
12.2. Объединение дублирующихся фрагментов в условных операторах. Перепиши метод
startMoving(), чтобы в нем не было повторяющихся вызовов функций.
12.3. Замена магического числа символьной константой. Замени магические числа в методе
getMaxSpeed() на константные переменные метода: MAX_TRUCK_SPEED,
MAX_SEDAN_SPEED и MAX_CABRIOLET_SPEED.
12.4. Замена условного оператора полиморфизмом.
12.4.1. Переопредели метод getMaxSpeed() в подклассах, избавившись от условного оператора.
12.4.2. Метод getMaxSpeed() в классе Car сделай абстрактным.
 */

public abstract class Car {
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;

    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private int type;

    private boolean driverAvailable;
    private int numberOfPassengers;

    protected Car(int type, int numberOfPassengers) {
        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }

    public boolean isSummer(Date date, Date summerStart, Date summerEnd) {
        return (date.before(summerEnd) && date.after(summerStart));
    }

    public double getWinterConsumption(int length) {
        return length * winterFuelConsumption + winterWarmingUp;
    }

    public double getSummerConsumption(int length) {
        return length * summerFuelConsumption;
    }

    public static Car create(int type, int numberOfPassengers) {
        switch (type) {
            case TRUCK:
                return new Truck(numberOfPassengers);
            case SEDAN:
                return new Sedan(numberOfPassengers);
            case CABRIOLET:
                return new Cabriolet(numberOfPassengers);
            default:
                return null;
        }
    }

    public void fill(double numberOfLiters) throws Exception {
        if (numberOfLiters < 0) throw new Exception();
        fuel += numberOfLiters;
    }


    public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd) {
        if (isSummer(date, SummerStart, SummerEnd)) {
            return getSummerConsumption(length);
        } else {
            return getWinterConsumption(length);
        }
    }

    public int getNumberOfPassengersCanBeTransferred() {
        if (!canPassengersBeTransferred())
            return 0;
        return numberOfPassengers;
    }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    public void startMoving() {
        if (numberOfPassengers > 0) {
            fastenPassengersBelts();

        }
        fastenDriverBelt();
    }


    public void fastenPassengersBelts() {
    }

    public void fastenDriverBelt() {
    }

    public abstract int getMaxSpeed();

    private boolean canPassengersBeTransferred() {
        return isDriverAvailable() && fuel > 0;
    }
}