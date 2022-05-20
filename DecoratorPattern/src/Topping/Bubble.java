package Topping;

import BaseDrink.BaseDrink;

public class Bubble extends Topping {
    private String name = "Bubble";
    private int price = 15;
    private BaseDrink base;
    public Bubble(BaseDrink base) {
        this.base = base;
    }

    @Override
    public int getPrice() {
        return base.getPrice() + this.price;
    }

    @Override
    public String toString() {
        return base + ", " + name;
    }
}
