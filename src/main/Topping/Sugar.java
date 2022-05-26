package main.Topping;

import main.Beverage.BaseBeverage;

public class Sugar extends Topping {
    private String name = "Sugar";
    private int price = 0;
    private BaseBeverage base;
    private int limit = 4;
    private int amount = 1;
    public Sugar(BaseBeverage base) {
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
