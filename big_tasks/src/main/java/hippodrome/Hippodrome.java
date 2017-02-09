package hippodrome;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Hippodrome {

    private ArrayList<Horse> horses = new ArrayList<>();
    public static Hippodrome game;

    public ArrayList<Horse> getHorses() {
        return horses;
    }

    public Horse getWinner() {
        return Collections.max(getHorses(), new Comparator<Horse>() {
            @Override
            public int compare(Horse o1, Horse o2) {
                return Double.compare(o1.getDistance(), o2.getDistance());
            }
        });
    }

    public void printWinner() {
        System.out.printf("Winner is %s!", getWinner().getName());
    }

    public void print() {
        for (Horse horse : getHorses()) {
            horse.print();
            System.out.printf("\n\n");
        }
    }

    public void move() {
        for (Horse horse : getHorses()) {
            horse.move();
        }
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome();
        for (int i = 0; i < 3; i++) {
            game.getHorses().add(new Horse("Horse" + i, 3, 0));
        }
        game.run();
        game.printWinner();
    }
}