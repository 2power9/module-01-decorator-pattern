package BeverageTest;

import Beverage.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.*;

@Timeout(3)
class BaseBeverageTest {
    @Test
    void getPrice() {
        BaseBeverage obj;
        // GIVEN
        obj = new Espresso();
        // WHEN & THEN
        assertEquals(30, obj.getPrice());

        // GIVEN
        obj = new GreenTea();
        // WHEN & THEN
        assertEquals(35, obj.getPrice());

        // GIVEN
        obj = new MilkTea();
        // WHEN & THEN
        assertEquals(45, obj.getPrice());
    }

    @Test
    void getName() {
        BaseBeverage obj;
        // GIVEN
        obj = new Espresso();
        // WHEN & THEN
        assertEquals("Espresso", obj.getName());

        // GIVEN
        obj = new GreenTea();
        // WHEN & THEN
        assertEquals("Green Tea", obj.getName());

        // GIVEN
        obj = new MilkTea();
        // WHEN & THEN
        assertEquals("Milk Tea", obj.getName());
    }

    @Test
    void testToString() {
        BaseBeverage obj;
        // GIVEN
        obj = new Espresso();
        // WHEN & THEN
        assertEquals("Espresso", obj.toString());

        // GIVEN
        obj = new GreenTea();
        // WHEN & THEN
        assertEquals("Green Tea", obj.toString());

        // GIVEN
        obj = new MilkTea();
        // WHEN & THEN
        assertEquals("Milk Tea", obj.toString());
    }

    @Test
    void testGetLimit() {
        BaseBeverage obj;
        // GIVEN
        obj = new Espresso();
        // WHEN & THEN
        assertEquals(5, obj.getLimit());

        // GIVEN
        obj = new GreenTea();
        // WHEN & THEN
        assertEquals(5, obj.getLimit());

        // GIVEN
        obj = new MilkTea();
        // WHEN & THEN
        assertEquals(5, obj.getLimit());
    }
}