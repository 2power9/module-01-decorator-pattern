package Topping;

import BaseDrink.BaseDrink;

public class Fruit extends Topping {
    private String name = "Fruit";
    private int price = 20;
    private BaseDrink base;

    public Fruit(BaseDrink base) {
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
