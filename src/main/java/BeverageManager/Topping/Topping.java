package BeverageManager.Topping;

import BeverageManager.Beverage.BaseBeverage;

public abstract class Topping extends BaseBeverage {
    public abstract int getPrice();
    public abstract void setAmount(int num);
}