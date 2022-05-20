package CoffeeManager;

import BaseDrink.*;
import Topping.*;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.out;

public class CoffeeManager {
    private final Scanner sc;
    private ArrayList<BaseDrink> list;

    public CoffeeManager() {
        sc = new Scanner(System.in);
        list = new ArrayList<>();
    }

    private void printMenuItem(BaseDrink obj, int pos) {
        System.out.println(pos + " - " + obj + "\t\t" + obj.getPrice() + " 000");
    }
    private void showMenu() {
        BaseDrink obj;
        System.out.println("Drinks");
        obj = new Espresso();
        printMenuItem(obj, 1);
        obj = new Cappuccino();
        printMenuItem(obj, 2);
        obj = new Latte();
        printMenuItem(obj, 3);
        obj = new GreenTea();
        printMenuItem(obj, 4);
        obj = new MilkTea();
        printMenuItem(obj, 5);

        System.out.println("\nToppings:");
        obj = new Bubble(null);
        printMenuItem(obj, 1);
        obj = new Coffee(null);
        printMenuItem(obj, 2);
        obj = new Milk(null);
        printMenuItem(obj, 3);
        obj = new Pudding (null);
        printMenuItem(obj, 4);
        obj = new Fruit(null);
        printMenuItem(obj, 5);
        obj = new Sugar(null);
        printMenuItem(obj, 6);
    }

    BaseDrink createDrink() {
        BaseDrink obj;
        int op;


        out.print("Choose option for drink [1-5]: ");

        op = sc.nextInt();
        while (true) {
            if (op == 1) obj = new Espresso();
            else if (op == 2) obj = new Cappuccino();
            else if (op == 3) obj = new Latte();
            else if (op == 4) obj = new GreenTea();
            else if (op == 5) obj = new MilkTea();
            else {
                out.println("Sorry, we don't have this option.");
                continue;
            }
            break;
        }

        while (true) {
            out.print("Do you wanna pick topping? (0 - no | [1-6] topping): ");
            op = sc.nextInt();
            if (op == 0) break;

            if (op == 1) obj = new Bubble(obj);
            else if (op == 2) obj = new Coffee(obj);
            else if (op == 3) obj = new Milk(obj);
            else if (op == 4) obj = new Pudding(obj);
            else if (op == 5) obj = new Fruit(obj);
            else if (op == 6) obj = new Sugar(obj);
            else out.println("Sorry, we don't have this option.");
        }
        return obj;
    }

    public void orderDrink(int pos) {
        System.out.println("===== #"+ pos +" =====");
        int op;
        while (true) {
            System.out.print("Choose option (0 - quit | 1 - show menu | 2 - order):");
            op = sc.nextInt();
            if (op == 0) return;

            if (op == 1) showMenu();
            else if (op == 2) {
                BaseDrink obj = createDrink();
                list.add(obj);
                break;
            }
            else out.println("Sorry, we don't have this option.");
        }
    }

    public void printBill() {
        System.out.println("=================================");
        int ans = 0;
        for (BaseDrink obj : list) {
            int price = obj.getPrice();
            out.println("Item: " + obj + "\t\t\tprice: " + price);
            ans += price;
        }
        System.out.println("Total: " + ans);
        System.out.println("=================================");
    }
}
