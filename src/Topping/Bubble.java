package Topping;

import Beverage.BaseBeverage;

public class Bubble extends Topping {
    private String name = "Bubble";
    private int price = 15;
    private BaseBeverage base;
    public Bubble(BaseBeverage base) {
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
