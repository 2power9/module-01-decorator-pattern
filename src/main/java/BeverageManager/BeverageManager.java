package BeverageManager;

import BeverageManager.Beverage.*;
import BeverageManager.Factory.*;
import BeverageManager.Topping.Bubble;
import BeverageManager.Topping.Coffee;
import BeverageManager.Topping.Fruit;
import BeverageManager.Topping.Milk;
import Helper.Client;
import Helper.InputHelper;
import MessageStrategy.*;
import State.*;
import Topping.*;

import java.util.ArrayList;

import static java.lang.System.out;

public class BeverageManager {

    private InputHelper in;
    private ArrayList<BaseBeverage> list;

    private State status;

    private MessageStrategy message;
    public BeverageManager() {
        in = new InputHelper(System.in);
        list = new ArrayList<>();
    }

    public void nextStatus(State status) {
        this.status = status;
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
        obj = new Bubble();
        printMenuItem(obj, 1);
        obj = new Coffee();
        printMenuItem(obj, 2);
        obj = new Milk();
        printMenuItem(obj, 3);
        obj = new Fruit();
        printMenuItem(obj, 4);
    }

    private BaseBeverage createBeverage() {
        int op;
        BeverageFactory controller;
        while (true) {
            out.print("Choose option for beverage [1-3]: ");
            op = Integer.parseInt(in.input());

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

    private void orderBeverages() {
        int op;
        status = new ProcessState(this);
        while (true) {
            System.out.print("Choose option (0 - quit | 1 - show menu | 2 - order):");
            op = Integer.parseInt(in.input());
            if (op == 0) return;
            if (op == 2) break;
            if (op == 1) showMenu();
            else out.println("Sorry, we don't have this option.");
        }

        System.out.print("How many beverages do you wanna add?: ");
        int n = Integer.parseInt(in.input());
        for (int i = 0; i < n; ++i) {
            System.out.println("\n===============Beverage #" + i + "==============");
            BaseBeverage obj = createBeverage();
            list.add(obj);
        }
    }

    private Client getClient() {
        System.out.print("Type client's name: ");
        String name = in.input();
        System.out.print("Type telephone number: ");
        String tel = in.input();
        return new Client(name, tel);
    }

    private MessageStrategy getMessageMethod(Client client) {
        int op;
        while (true) {
            System.out.print("Get message method (0 - Telegram | 1 - Zalo): ");
            op = Integer.parseInt(in.input());
            if (op < 0 || op > 1) {
                System.out.println("Sorry, we don't have this option.");
                continue;
            }
            break;
        }
        if (op == 0) return new MessageTelegram(client);
        else return new MessageZalo(client);
    }

    public void order() {
        Client client = getClient();
        message = getMessageMethod(client);
        orderBeverages();
        message.sendMessage(status.getStatus());
        printBill();
        message.sendMessage(status.getStatus());
    }

    public void printBill() {
        System.out.println("=================================");
        int ans = 0;
        for (BaseBeverage obj : list) {
            int price = obj.getPrice();
            out.println("Item: " + obj + "\t\t\tprice: " + price + " 000");
            ans += price;
        }
        System.out.println("Total: " + ans + " 000");
        System.out.println("=================================");
        status.nextStatus();
    }
}
