package Topping;

import Beverage.BaseBeverage;

public class Milk extends Topping {
    private String name = "Milk";
    private int price = 10;
    private BaseBeverage base;
    private int limit = 5;
    private int amount = 1;
    public Milk() {
        base = null;
    }
    public Milk(BaseBeverage base) {
        this.base = base;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    @Override
    public int getLimit() {
        return limit;
    }

    @Override
    public int getPrice() {
        return (base != null ? base.getPrice() : 0) + this.price * amount;
    }
    @Override
    public String toString() {
        return base != null ? base + ", " + name + ": " + amount : name;
    }
}
