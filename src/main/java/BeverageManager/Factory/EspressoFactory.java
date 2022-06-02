package BeverageManager.Factory;

import BeverageManager.Beverage.BaseBeverage;
import BeverageManager.Beverage.Espresso;

import BeverageManager.Topping.Coffee;
import BeverageManager.Topping.Sugar;

import java.util.Arrays;

public class EspressoFactory extends BeverageFactory {

    public EspressoFactory() {
        super();
        numToppings = 2;
        pickedTopping = new boolean[numToppings];
        Arrays.fill(pickedTopping, false);
    }

    @Override
    public BaseBeverage createBeverage() {
        BaseBeverage obj = new Espresso();
        int op, count = 0;
        int limit = Math.min(obj.getLimit(), numToppings);

        while (count < limit) {
            System.out.print("Pick available toppings (0 - no | 1 - coffee | 2 - sugar): ");
            op = Integer.parseInt(in.input());
            if (op == 0) break;
            if (op > numToppings) {
                System.out.println("Sorry, we don't have this option.");
                continue;
            }
            if (pickedTopping[op - 1]) {
                System.out.println("You've picked this topping.");
                continue;
            }

            pickedTopping[op - 1] = true;

            ++count;

            obj = (op == 1 ? new Coffee(obj) : new Sugar(obj));
            getAmount(obj);
        }
        return obj;
    }
}
