import CoffeeManager.CoffeeManager;

public class Main {
    public static void main(String[] args) {
        CoffeeManager manager = new CoffeeManager();
        manager.orderDrink(1);
        manager.printBill();
    }
}