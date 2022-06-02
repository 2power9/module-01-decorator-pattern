package BeverageManager.Topping;

import BeverageManager.Beverage.BaseBeverage;

public class Bubble extends Topping {
    private String name = "Bubble";
    private int price = 15;
    private BaseBeverage base;
    private int limit = 4;
    private int amount = 1;
    public Bubble() {
        base = null;
    }
    public Bubble(BaseBeverage base) {
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
