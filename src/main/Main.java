package main;

import main.CoffeeManager.CoffeeManager;
import main.Factory.*;

public class Main {
    public static void main(String[] args) {
//        CoffeeManager manager = new CoffeeManager();
//        manager.orderBeverages();
//        manager.printBill();
        BeverageFactory obj = new EspressoFactory();
        System.out.println(obj.createBeverage());

    }
}