package Topping;

import Beverage.BaseBeverage;

public class Milk extends Topping {
    private String name = "Milk";
    private int price = 10;
    private BaseBeverage base;

    public Milk(BaseBeverage base) {
        this.base = base;
    }

    @Override
    public int getPrice() {
        return (base != null ? base.getPrice() : 0) + this.price;
    }

    @Override
    public String toString() {
        return (base != null ? base + ", " : "") + name;
    }
}
