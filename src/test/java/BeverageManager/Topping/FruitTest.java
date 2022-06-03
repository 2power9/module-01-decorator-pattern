package BeverageManager.Topping;

import BeverageManager.Beverage.BaseBeverage;
import BeverageManager.Beverage.GreenTea;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.*;

class FruitTest {
    @Test
    void getAmount() {
        // GIVEN
        Fruit obj = new Fruit();
        // WHEN & THEN
        assertTrue(obj.getAmount() > 0 && obj.getAmount() <= obj.getLimit());
    }

    @Test
    void setAmount() {
        // GIVEN
        Fruit obj = new Fruit();
        // WHEN
        obj.setAmount(2);
        // THEN
        assertEquals(2, obj.getAmount());
    }

    @Test
    void getLimit() {
        // GIVEN
        Fruit obj = new Fruit();
        // WHEN & THEN
        assertEquals(2, obj.getLimit());
    }

    @Test
    void getPriceBaseNull() {
        // GIVEN
        Fruit obj = new Fruit();
        // WHEN & THEN
        assertEquals(20, obj.getPrice());
    }

    @Test
    void getPriceBaseNotNull() {
        // GIVEN
        Fruit obj = new Fruit();
        BaseBeverage base = new GreenTea();
        int expect = base.getPrice() + obj.getPrice();
        // WHEN
        base = new Fruit(base);
        // THEN
        assertEquals(expect, base.getPrice());
    }

    @Test
    void testToString() {
        // GIVEN
        Fruit obj = new Fruit();
        // WHEN & THEN
        assertNotNull(obj.toString());
    }
}
