package FactoryTest;

import Beverage.BaseBeverage;
import Beverage.Espresso;
import Factory.EspressoFactory;
import Helper.InputHelper;
import Topping.Coffee;
import Topping.Sugar;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class EspressoFactoryTest {
    private PrintStream standardOut;
    private ByteArrayOutputStream outputStreamCaptor;

    @BeforeEach
    public void setUp() {
        standardOut = System.out;
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void createBeverageTestOption0() {
        // GIVEN
        EspressoFactory obj = new EspressoFactory();
        Espresso expectBeverage = new Espresso();
        InputHelper in = mock(InputHelper.class);
        obj.setInputHelper(in);

        // WHEN
        when(in.input()).thenReturn("0");

        // THEN
        BaseBeverage ouputBeverage = obj.createBeverage();
        assertEquals(expectBeverage.getPrice(), ouputBeverage.getPrice());
    }

    @Test
    void createBeverageTestOption1() {
        // GIVEN
        EspressoFactory obj = new EspressoFactory();
        BaseBeverage expectBeverage = new Espresso();
        expectBeverage = new Coffee(expectBeverage);
        InputHelper in = mock(InputHelper.class);
        obj.setInputHelper(in);

        // WHEN
        when(in.input()).thenReturn("1") // get topping 1
                .thenReturn("1") // get amount = 1
                .thenReturn("0"); // finish adding topping

        BaseBeverage ouputBeverage = obj.createBeverage();

        // THEN
        assertEquals(expectBeverage.getPrice(), ouputBeverage.getPrice());
    }

    @Test
    void createBeverageTestOption2() {
        // GIVEN
        EspressoFactory obj = new EspressoFactory();
        BaseBeverage expectBeverage = new Espresso();
        expectBeverage = new Sugar(expectBeverage);
        InputHelper in = mock(InputHelper.class);
        obj.setInputHelper(in);

        // WHEN
        when(in.input()).thenReturn("2") // get topping 2
                .thenReturn("1") // get amount = 1
                .thenReturn("0"); // finish adding topping

        BaseBeverage ouputBeverage = obj.createBeverage();

        // THEN
        assertEquals(expectBeverage.getPrice(), ouputBeverage.getPrice());
    }

    @Test
    void createBeverageTestAmountOutOfBounds() {
        // GIVEN
        EspressoFactory obj = new EspressoFactory();
        InputHelper in = mock(InputHelper.class);
        obj.setInputHelper(in);
        String expectText = "Amount out of bound!";
        Sugar topping = new Sugar();

        // WHEN
        when(in.input()).thenReturn("2") // get topping 2
                .thenReturn(Integer.toString(topping.getLimit() + 1)) // get amount out of bound
                .thenReturn("1") // get valid amount
                .thenReturn("0"); // finish adding topping

        obj.createBeverage();

        // THEN
        assertTrue(outputStreamCaptor.toString().trim().contains(expectText));

    }

    @Test
    void createBeverageTestRepeatOption() {
        // GIVEN
        EspressoFactory obj = new EspressoFactory();
        InputHelper in = mock(InputHelper.class);
        obj.setInputHelper(in);
        String expectText = "You've picked this topping.";

        // WHEN
        when(in.input()).thenReturn("2") // get topping 2
                .thenReturn("1") // get valid amount
                .thenReturn("2") // get repeat option
                .thenReturn("0"); // finish adding topping

        obj.createBeverage();

        // THEN
        assertTrue(outputStreamCaptor.toString().trim().contains(expectText));

    }

    @Test
    void createBeverageTestOptionOutOfRange() {
        // GIVEN
        EspressoFactory obj = new EspressoFactory();
        InputHelper in = mock(InputHelper.class);
        obj.setInputHelper(in);
        String expectText = "Sorry, we don't have this option.";

        // WHEN
        when(in.input()).thenReturn("3") // get out of range option
                .thenReturn("0"); // finish adding topping

        obj.createBeverage();

        // THEN
        assertTrue(outputStreamCaptor.toString().trim().contains(expectText));
    }


    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}