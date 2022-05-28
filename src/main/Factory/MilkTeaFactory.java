package main.Factory;

import main.Beverage.BaseBeverage;
import main.Beverage.MilkTea;

import main.Topping.*;

import java.util.Arrays;

public class MilkTeaFactory extends BeverageFactory {
    public MilkTeaFactory() {
        numToppings = 4;
        pickedTopping = new boolean[numToppings];
        Arrays.fill(pickedTopping, false);
    }
    @Override
    public BaseBeverage createBeverage() {
        BaseBeverage obj = new MilkTea();
        int op, count = 0;
        int limit = Math.min(obj.getLimit(), numToppings);

        while (count < limit) {
            System.out.print("Pick available toppings (0 - no | 1 - bubble | 2 - milk | 3 - fruit | 4 - sugar): ");
            op = Integer.parseInt(in.input());
            if (op == 0) break;
            if (processOutOfRangeOption(op)) continue;

            pickedTopping[op - 1] = true;
            ++count;
            if (op == 1) obj = new Bubble(obj);
            else if (op == 2) obj = new Milk(obj);
            else if (op == 3) obj = new Fruit(obj);
            else if (op == 4) obj = new Sugar(obj);

            getAmount(obj);
        }
        return obj;
    }
}
