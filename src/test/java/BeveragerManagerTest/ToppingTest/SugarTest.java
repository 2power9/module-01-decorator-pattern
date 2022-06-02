package ToppingTest;

import BeverageManager.Beverage.BaseBeverage;
import BeverageManager.Beverage.GreenTea;
import BeverageManager.Topping.Sugar;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.*;

@Timeout(3)
class SugarTest {
    @Test
    void getAmount() {
        // GIVEN
        Sugar obj = new Sugar();
        // WHEN & THEN
        assertTrue(obj.getAmount() > 0 && obj.getAmount() <= obj.getLimit());
    }

    @Test
    void setAmount() {
        // GIVEN
        Sugar obj = new Sugar();
        // WHEN
        obj.setAmount(2);
        // THEN
        assertEquals(2, obj.getAmount());
    }

    @Test
    void getLimit() {
        // GIVEN
        Sugar obj = new Sugar();
        // WHEN & THEN
        assertEquals(4, obj.getLimit());
    }

    @Test
    void getPriceBaseNull() {
        // GIVEN
        Sugar obj = new Sugar();
        // WHEN & THEN
        assertEquals(0, obj.getPrice());
    }

    @Test
    void getPriceBaseNotNull() {
        // GIVEN
        Sugar obj = new Sugar();
        BaseBeverage base = new GreenTea();
        int expect = base.getPrice() + obj.getPrice();
        // WHEN
        base = new Sugar(base);
        // THEN
        assertEquals(expect, base.getPrice());
    }

    @Test
    void testToString() {
        // GIVEN
        Sugar obj = new Sugar();
        // WHEN & THEN
        assertNotNull(obj.toString());
    }
}