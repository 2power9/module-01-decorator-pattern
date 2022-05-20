package Topping;

import BaseDrink.BaseDrink;

public class Sugar extends Topping {
    private String name = "Sugar";
    private int price = 0;
    private BaseDrink base;

    public Sugar(BaseDrink base) {
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