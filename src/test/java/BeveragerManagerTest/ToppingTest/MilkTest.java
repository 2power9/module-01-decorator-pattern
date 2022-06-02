package ToppingTest;

import BeverageManager.Beverage.BaseBeverage;
import BeverageManager.Beverage.MilkTea;
import BeverageManager.Topping.Milk;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.*;

@Timeout(3)
class MilkTest {
    @Test
    void getAmount() {
        // GIVEN
        Milk obj = new Milk();
        // WHEN & THEN
        assertTrue(obj.getAmount() > 0 && obj.getAmount() <= obj.getLimit());
    }

    @Test
    void setAmount() {
        // GIVEN
        Milk obj = new Milk();
        // WHEN
        obj.setAmount(2);
        // THEN
        assertEquals(2, obj.getAmount());
    }

    @Test
    void getLimit() {
        // GIVEN
        Milk obj = new Milk();
        // WHEN & THEN
        assertEquals(5, obj.getLimit());
    }

    @Test
    void getPriceBaseNull() {
        // GIVEN
        Milk obj = new Milk();
        // WHEN & THEN
        assertEquals(10, obj.getPrice());
    }

    @Test
    void getPriceBaseNotNull() {
        // GIVEN
        Milk obj = new Milk();
        BaseBeverage base = new MilkTea();
        int expect = base.getPrice() + obj.getPrice();
        // WHEN
        base = new Milk(base);
        // THEN
        assertEquals(expect, base.getPrice());
    }

    @Test
    void testToString() {
        // GIVEN
        Milk obj = new Milk();
        // WHEN & THEN
        assertNotNull(obj.toString());
    }
}