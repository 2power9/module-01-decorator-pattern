package Factory;

import Beverage.*;

import java.util.Scanner;

public abstract class BeverageFactory {
    protected Scanner sc;
    protected int numToppings;
    protected boolean[] pickedTopping;
    BeverageFactory() {
        sc = new Scanner(System.in);
    }

    protected boolean processOutOfRangeOption(int op) {
        if (op > numToppings) {
            System.out.println("Sorry, we don't have this option.");
            return true;
        }
        else if (pickedTopping[op - 1]) {
            System.out.println("You've picked this topping.");
            return true;
        }
        return false;
    }
    protected void getAmount(BaseBeverage obj, int i) {
        while (true) {
            System.out.print("Choose amount of topping (limit: " + obj.getLimit() + ") : ");
            int num = i;
            if (num > 0 && num <= obj.getLimit()) {
                obj.setAmount(num);
                break;
            }
            System.out.println("Amount out of bound!");

        }
    }
    public abstract BaseBeverage createBeverage();
}
