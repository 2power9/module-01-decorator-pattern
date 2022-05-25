package Topping;

import Beverage.BaseBeverage;

public class Fruit extends Topping {
    private String name = "Fruit";
    private int price = 20;
    private BaseBeverage base;
    private int limit = 2;
    private int amount = 1;

    public Fruit(BaseBeverage base) {
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
