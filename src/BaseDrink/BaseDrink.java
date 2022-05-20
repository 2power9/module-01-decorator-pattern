package BaseDrink;

public abstract class BaseDrink {
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
        return "Drink name: " + name;
    }
}