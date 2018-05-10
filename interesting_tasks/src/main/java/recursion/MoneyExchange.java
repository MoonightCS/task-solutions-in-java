package recursion;

public class MoneyExchange {

    public static void main(String[] args) {
        MoneyExchange moneyExchange = new MoneyExchange();
        System.out.println(moneyExchange.changeCoin(100));
        System.out.println(moneyExchange.changeCoin(5));
        System.out.println(moneyExchange.changeCoin(6));
        System.out.println(moneyExchange.changeCoin(10));
        System.out.println(moneyExchange.changeCoin(9));
    }

    private int changeCoin(int amount) {
        return coinsExchange(amount, 5);
    }

    private int coinsExchange(int amount, int kindsOfCoins) {

        int count = 0;

        if (amount == 0) {
            count = 1;
        }

        if (amount > 0 && kindsOfCoins != 0) {
            count = coinsExchange(amount, kindsOfCoins - 1) + coinsExchange(amount - firstDenomination(kindsOfCoins), kindsOfCoins);
        }

        return count;
    }

    private int firstDenomination(int kindsOfCoins) {
        int amount;
        switch (kindsOfCoins) {
            case 1:
                amount = 1;
                break;
            case 2:
                amount = 5;
                break;
            case 3:
                amount = 10;
                break;
            case 4:
                amount = 25;
                break;
            case 5:
                amount = 50;
                break;
            default:
                amount = 0;
                break;
        }
        return amount;
    }


}
