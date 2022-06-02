package BeverageManager.Factory;

import BeverageManager.Beverage.BaseBeverage;
import BeverageManager.Beverage.GreenTea;

import Topping.Sugar;
import Topping.Fruit;

import java.util.Arrays;

public class GreenTeaFactory extends BeverageFactory {
    public GreenTeaFactory() {
        numToppings = 2;
        pickedTopping = new boolean[numToppings];
        Arrays.fill(pickedTopping, false);
    }
    @Override
    public BaseBeverage createBeverage() {
        BaseBeverage obj = new GreenTea();
        int op, count = 0;
        int limit = Math.min(obj.getLimit(), numToppings);

        while (count < limit) {
            System.out.print("Pick available toppings (0 - no | 1 - fruit | 2 - sugar): ");
            op = Integer.parseInt(in.input());
            if (op == 0) break;
            if (processOutOfRangeOption(op)) continue;
            pickedTopping[op - 1] = true;

            ++count;
            if (op == 1) obj = new Fruit(obj);
            else if (op == 2) obj = new Sugar(obj);

            getAmount(obj);
        }
        return obj;
    }
}
