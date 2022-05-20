package Topping;

import BaseDrink.BaseDrink;

public class Coffee extends Topping {
    private String name = "Coffee";
    private int price = 25;
    private BaseDrink base;

    public Coffee(BaseDrink base) {
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