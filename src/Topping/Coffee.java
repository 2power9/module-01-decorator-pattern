package Topping;

import Beverage.BaseBeverage;

public class Coffee extends Topping {
    private String name = "Coffee";
    private int price = 25;
    private BaseBeverage base;

    public Coffee(BaseBeverage base) {
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
