package BeverageManager.Topping;

import BeverageManager.Beverage.BaseBeverage;
import BeverageManager.Beverage.Espresso;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.*;

class CoffeeTest {
    @Test
    void getAmount() {
        // GIVEN
        Coffee obj = new Coffee();
        // WHEN & THEN
        assertTrue(obj.getAmount() > 0 && obj.getAmount() <= obj.getLimit());
    }

    @Test
    void setAmount() {
        // GIVEN
        Coffee obj = new Coffee();
        obj.setAmount(2);
        assertEquals(2, obj.getAmount());
    }

    @Test
    void getLimit() {
        // GIVEN
        Coffee obj = new Coffee();
        // WHEN & THEN
        assertEquals(2, obj.getLimit());
    }

    @Test
    void getPriceBaseNull() {
        // GIVEN
        Coffee obj = new Coffee();
        // WHEN & THEN
        assertEquals(25, obj.getPrice());
    }

    @Test
    void getPriceBaseNotNull() {
        // GIVEN
        Coffee obj = new Coffee();
        BaseBeverage base = new Espresso();
        int expect = base.getPrice() + obj.getPrice();
        // WHEN
        base = new Coffee(base);
        // THEN
        assertEquals(expect, base.getPrice());
    }

    @Test
    void testToString() {
        // GIVEN
        Coffee obj = new Coffee();
        // WHEN & THEN
        assertNotNull(obj.toString());
    }
}
