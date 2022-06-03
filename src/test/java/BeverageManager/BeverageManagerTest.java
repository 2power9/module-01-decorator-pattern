package BeverageManager;

import BeverageManager.Beverage.Espresso;
import BeverageManager.Beverage.MilkTea;
import BeverageManager.Topping.Bubble;
import Helper.InputHelper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Timeout(3)
class BeverageManagerTest {
    private PrintStream standardOut;
    private ByteArrayOutputStream outputStreamCaptor;

    @BeforeEach
    public void setUp()  {
        standardOut = System.out;
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void printBillTest() throws FileNotFoundException, InterruptedException {
        // GIVEN
        BeverageManager manager = new BeverageManager();
        File f = new File(System.getProperty("user.dir") + "/src/test/java/BeverageManager/OuputSample/printBillSample.txt");
        Scanner sc = new Scanner(f);
        String expectText = "";
        while (sc.hasNextLine()) {
            expectText += sc.nextLine() + "\n";
        }

        // WHEN
        TimeUnit.SECONDS.sleep(1);
        manager.addBeverage(new Espresso());
        manager.addBeverage(new Bubble(new MilkTea()));
        manager.printBill();

        // THEN
        assertEquals(expectText.trim(), outputStreamCaptor.toString().trim());
    }

    @Test
    void orderTest() throws FileNotFoundException, InterruptedException {
        // GIVEN
        InputHelper in = mock(InputHelper.class);
        BeverageManager manager = new BeverageManager();
        manager.setInputHelper(in);
        File f = new File(System.getProperty("user.dir") + "/src/test/java/BeverageManager/OuputSample/orderSample.txt");
        Scanner sc = new Scanner(f);
        String expectText = "";
        while (sc.hasNextLine()) {
            expectText += sc.nextLine() + "\n";
        }
        TimeUnit.SECONDS.sleep(4);

        // WHEN
        when(in.input())
                .thenReturn("Andrena") // get user's name
                .thenReturn("01234") // get user's telephone number
                .thenReturn("1") // choose Zalo message method
                .thenReturn("1") // show menu
                .thenReturn("2") // order
                .thenReturn("2") // choose number of beverages
                .thenReturn("2") // choose beverage
                .thenReturn("1") // pick topping 1
                .thenReturn("3") // choose amount (out of bound)
                .thenReturn("1") // choose amount valid
                .thenReturn("1") // choose picked topping
                .thenReturn("0"); // quit

        manager.order();


        // THEN
        assertEquals(expectText.trim(), outputStreamCaptor.toString().trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}