package BeverageManager.Beverage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@Timeout(3)
class BaseBeverageTest {
    private PrintStream standardOut;
    private ByteArrayOutputStream outputStreamCaptor;

    @BeforeEach
    public void setUp() {
        standardOut = System.out;
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    @Test
    void getPrice() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
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
    void getName() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
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
    void testToString() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
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
    void testGetLimit() throws InterruptedException {
        BaseBeverage obj;
        // GIVEN
        TimeUnit.SECONDS.sleep(1);
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

    @Test
    void setAmountForDefaultBeverage() throws InterruptedException {
        // GIVEN
        BaseBeverage obj = new Espresso();
        TimeUnit.SECONDS.sleep(1);

        // WHEN
        obj.setAmount(3);

        // THEN
        assertEquals("", outputStreamCaptor.toString().trim());

    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);

    }
}