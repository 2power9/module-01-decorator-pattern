package Factory;

import Beverage.BaseBeverage;
import Beverage.Espresso;

import Topping.Coffee;
import Topping.Sugar;

import java.util.Arrays;
import java.util.Scanner;

public class EspressoFactory extends BeverageFactory {

    public EspressoFactory() {
        sc = new Scanner(System.in);
        numToppings = 2;
    }

    @Override
    public BaseBeverage createBeverage() {
        BaseBeverage obj = new Espresso();
        boolean[] pickedTopping = new boolean[numToppings];
        Arrays.fill(pickedTopping, false);
        int op, count = 0;
        int limit = Math.min(obj.getLimit(), numToppings);

        while (count < limit) {
            System.out.print("Pick available toppings (0 - no | 1 - coffee | 2 - sugar): ");
            op = sc.nextInt();
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
            getAmount(obj, sc.nextInt());
        }
        return obj;
    }
}
