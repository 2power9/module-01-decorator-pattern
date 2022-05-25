package Beverage;

public abstract class BaseBeverage {
    protected String name;
    protected int price;
    protected int limitToppings = 5;

    public int getPrice() {
        return price;
    }

    String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    public int getLimit() {
        return limitToppings;
    }
    public void setAmount(int num) {}
}