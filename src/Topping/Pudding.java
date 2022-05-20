package Topping;

import BaseDrink.BaseDrink;

public class Pudding extends Topping {
    private String name = "Pudding";
    private int price = 20;
    private BaseDrink base;

    public Pudding(BaseDrink base) {
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
