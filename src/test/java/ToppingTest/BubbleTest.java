package ToppingTest;

import Beverage.BaseBeverage;
import Beverage.MilkTea;
import Topping.Bubble;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.*;

@Timeout(3)
class BubbleTest {
    @Test
    void getAmount() {
        // GIVEN
        Bubble obj = new Bubble();
        // WHEN & THEN
        assertTrue(obj.getAmount() > 0 && obj.getAmount() <= obj.getLimit());
    }

    @Test
    void setAmount() {
        // GIVEN
        Bubble obj = new Bubble();
        // WHEN
        obj.setAmount(3);
        // THEN
        assertEquals(3, obj.getAmount());
    }

    @Test
    void getLimit() {
        // GIVEN
        Bubble obj = new Bubble();
        // WHEN & THEN
        assertEquals(4, obj.getLimit());
    }

    @Test
    void getPriceBaseNull() {
        // GIVEN
        Bubble obj = new Bubble();
        // WHEN & THEN
        assertEquals(15, obj.getPrice());
    }

    @Test
    void getPriceBaseNotNull() {
        // GIVEN
        Bubble obj = new Bubble();
        BaseBeverage base = new MilkTea();
        int expect = base.getPrice() + obj.getPrice();
        // WHEN
        base = new Bubble(base);
        // THEN
        assertEquals(expect, base.getPrice());
    }

    @Test
    void testToString() {
        // GIVEN
        Bubble obj = new Bubble();
        // WHEN & THEN
        assertNotNull(obj.toString());
    }
}