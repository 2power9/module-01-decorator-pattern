package BeverageManager.Factory;

import BeverageManager.Beverage.BaseBeverage;
import BeverageManager.Beverage.MilkTea;
import Helper.InputHelper;
import BeverageManager.Topping.Bubble;
import BeverageManager.Topping.Fruit;
import BeverageManager.Topping.Milk;
import BeverageManager.Topping.Sugar;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Timeout(3)
class MilkTeaFactoryTest {
    private PrintStream standardOut;
    private ByteArrayOutputStream outputStreamCaptor;

    @BeforeEach
    public void setUp() {
        standardOut = System.out;
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void createBeverageTestOption0() throws InterruptedException {
        // GIVEN
        MilkTeaFactory obj = new MilkTeaFactory();
        MilkTea expectBeverage = new MilkTea();
        InputHelper in = mock(InputHelper.class);
        obj.setInputHelper(in);

        // WHEN
        when(in.input()).thenReturn("0");
        TimeUnit.SECONDS.sleep(1);
        BaseBeverage ouputBeverage = obj.createBeverage();

        // THEN
        assertEquals(expectBeverage.getPrice(), ouputBeverage.getPrice());
    }

    @Test
    void createBeverageTestOption1() throws InterruptedException {
        // GIVEN
        MilkTeaFactory obj = new MilkTeaFactory();
        BaseBeverage expectBeverage = new MilkTea();
        expectBeverage = new Bubble(expectBeverage);
        InputHelper in = mock(InputHelper.class);
        obj.setInputHelper(in);

        // WHEN
        when(in.input()).thenReturn("1") // get topping 1
                .thenReturn("1") // get amount = 1
                .thenReturn("0"); // finish adding topping

        TimeUnit.SECONDS.sleep(1);
        BaseBeverage outputBeverage = obj.createBeverage();

        // THEN
        assertEquals(expectBeverage.getPrice(), outputBeverage.getPrice());
    }

    @Test
    void createBeverageTestOption2() throws InterruptedException {
        // GIVEN
        MilkTeaFactory obj = new MilkTeaFactory();
        BaseBeverage expectBeverage = new MilkTea();
        expectBeverage = new Milk(expectBeverage);
        InputHelper in = mock(InputHelper.class);
        obj.setInputHelper(in);

        // WHEN
        when(in.input()).thenReturn("2") // get topping 2
                .thenReturn("1") // get amount = 1
                .thenReturn("0"); // finish adding topping

        TimeUnit.SECONDS.sleep(1);
        BaseBeverage ouputBeverage = obj.createBeverage();

        // THEN
        assertEquals(expectBeverage.getPrice(), ouputBeverage.getPrice());
    }
    @Test
    void createBeverageTestOption3() throws InterruptedException {
        // GIVEN
        MilkTeaFactory obj = new MilkTeaFactory();
        BaseBeverage expectBeverage = new MilkTea();
        expectBeverage = new Fruit(expectBeverage);
        InputHelper in = mock(InputHelper.class);
        obj.setInputHelper(in);

        // WHEN
        when(in.input()).thenReturn("3") // get topping 3
                .thenReturn("1") // get amount = 1
                .thenReturn("0"); // finish adding topping

        TimeUnit.SECONDS.sleep(1);
        BaseBeverage ouputBeverage = obj.createBeverage();

        // THEN
        assertEquals(expectBeverage.getPrice(), ouputBeverage.getPrice());
    }
    @Test
    void createBeverageTestOption4() throws InterruptedException {
        // GIVEN
        MilkTeaFactory obj = new MilkTeaFactory();
        BaseBeverage expectBeverage = new MilkTea();
        expectBeverage = new Sugar(expectBeverage);
        InputHelper in = mock(InputHelper.class);
        obj.setInputHelper(in);

        // WHEN
        when(in.input()).thenReturn("4") // get topping 4
                .thenReturn("1") // get amount = 1
                .thenReturn("0"); // finish adding topping

        TimeUnit.SECONDS.sleep(1);
        BaseBeverage ouputBeverage = obj.createBeverage();

        // THEN
        assertEquals(expectBeverage.getPrice(), ouputBeverage.getPrice());
    }

    @Test
    void createBeverageTestAmountOutOfBounds() throws InterruptedException {
        // GIVEN
        MilkTeaFactory obj = new MilkTeaFactory();
        InputHelper in = mock(InputHelper.class);
        obj.setInputHelper(in);
        String expectText = "Amount out of bound!";
        Bubble topping = new Bubble();

        // WHEN
        when(in.input()).thenReturn("1") // get topping 1
                .thenReturn(Integer.toString(topping.getLimit() + 1)) // get amount out of bound
                .thenReturn("1") // get valid amount
                .thenReturn("0"); // finish adding topping

        TimeUnit.SECONDS.sleep(1);
        obj.createBeverage();

        // THEN
        assertTrue(outputStreamCaptor.toString().trim().contains(expectText));

    }

    @Test
    void createBeverageTestRepeatOption() throws InterruptedException {
        // GIVEN
        GreenTeaFactory obj = new GreenTeaFactory();
        InputHelper in = mock(InputHelper.class);
        obj.setInputHelper(in);
        String expectText = "You've picked this topping.";

        // WHEN
        when(in.input()).thenReturn("1") // get topping 2
                .thenReturn("1") // get valid amount
                .thenReturn("1") // get repeat option
                .thenReturn("0"); // finish adding topping

        TimeUnit.SECONDS.sleep(1);
        obj.createBeverage();

        // THEN
        assertTrue(outputStreamCaptor.toString().trim().contains(expectText));

    }

    @Test
    void createBeverageTestOptionOutOfRange() throws InterruptedException {
        // GIVEN
        GreenTeaFactory obj = new GreenTeaFactory();
        InputHelper in = mock(InputHelper.class);
        obj.setInputHelper(in);
        String expectText = "Sorry, we don't have this option.";

        // WHEN
        when(in.input()).thenReturn("-1") // get out of range option
                .thenReturn("0"); // finish adding topping

        TimeUnit.SECONDS.sleep(1);
        obj.createBeverage();

        // THEN
        assertTrue(outputStreamCaptor.toString().trim().contains(expectText));
    }


    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}