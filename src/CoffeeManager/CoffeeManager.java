package CoffeeManager;

import Beverage.*;
import Topping.*;
import Factory.*;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.out;

public class CoffeeManager {
    private final Scanner sc;
    private ArrayList<BaseBeverage> list;

    public CoffeeManager() {
        sc = new Scanner(System.in);
        list = new ArrayList<>();
    }

    private void printMenuItem(BaseBeverage obj, int pos) {
        System.out.println(pos + " - " + obj + "\t\t" + obj.getPrice() + " 000");
    }
    private void showMenu() {
        BaseBeverage obj;
        System.out.println("Drinks");
        obj = new Espresso();
        printMenuItem(obj, 1);
        obj = new GreenTea();
        printMenuItem(obj, 2);
        obj = new MilkTea();
        printMenuItem(obj, 3);

        System.out.println("\nToppings:");
        obj = new Bubble(null);
        printMenuItem(obj, 1);
        obj = new Coffee(null);
        printMenuItem(obj, 2);
        obj = new Milk(null);
        printMenuItem(obj, 3);
        obj = new Fruit(null);
        printMenuItem(obj, 4);
    }

    BaseBeverage createBeverage() {
        int op;
        BeverageFactory controller;
        while (true) {
            out.print("Choose option for drink [1-3]: ");
            op = sc.nextInt();

            if (op == 1) controller = new EspressoFactory();
            else if (op == 2) controller = new GreenTeaFactory();
            else if (op == 3) controller = new MilkTeaFactory();
            else {
                out.println("Sorry, we don't have this option.");
                continue;
            }
            break;
        }

        return controller.createBeverage();
    }

    public void orderDrink(int pos) {
        System.out.println("===== #"+ pos +" =====");
        int op;
        while (true) {
            System.out.print("Choose option (0 - quit | 1 - show menu | 2 - order):");
            op = sc.nextInt();
            if (op == 0) return;
            if (op == 1) showMenu();
            if (op == 2) break;
            else out.println("Sorry, we don't have this option.");
        }

        System.out.print("How many beverages do you wanna add?: ");
        int n = sc .nextInt();
        for (int i = 0; i < n; ++i) {
            BaseBeverage obj = createBeverage();
            list.add(obj);
        }
    }

    public void printBill() {
        System.out.println("=================================");
        int ans = 0;
        for (BaseBeverage obj : list) {
            int price = obj.getPrice();
            out.println("Item: " + obj + "\t\t\tprice: " + price);
            ans += price;
        }
        System.out.println("Total: " + ans);
        System.out.println("=================================");
    }
}
