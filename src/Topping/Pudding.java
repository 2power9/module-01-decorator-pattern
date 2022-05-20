package Topping;

import Beverage.BaseBeverage;

public class Pudding extends Topping {
    private String name = "Pudding";
    private int price = 20;
    private BaseBeverage base;

    public Pudding(BaseBeverage base) {
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
