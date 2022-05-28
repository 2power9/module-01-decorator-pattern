package main.Factory;

import main.Beverage.*;
import main.Helper.InputHelper;

import java.util.Scanner;

public abstract class BeverageFactory {
    protected InputHelper in;
    protected int numToppings;
    protected boolean[] pickedTopping;
    BeverageFactory() {
        in = new InputHelper(System.in);
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
    protected void getAmount(BaseBeverage obj) {
        while (true) {
            System.out.print("Choose amount of topping (limit: " + obj.getLimit() + ") : ");
            int num = Integer.parseInt(in.input());
            if (num > 0 && num <= obj.getLimit()) {
                obj.setAmount(num);
                break;
            }
            System.out.println("Amount out of bound!");

        }
    }
    public abstract BaseBeverage createBeverage();
}
