package Beverage;

public abstract class BaseBeverage {
    protected String name;
    protected int price;

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
}