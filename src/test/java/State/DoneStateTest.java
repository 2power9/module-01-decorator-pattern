package State;

import BeverageManager.BeverageManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@Timeout(3)
class DoneStateTest {
    private PrintStream standardOut;
    private ByteArrayOutputStream outputStreamCaptor;

    @BeforeEach
    public void setUp() {
        standardOut = System.out;
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void getStatusTest() throws InterruptedException {
        // GIVEN
        BeverageManager request = new BeverageManager();

        // WHEN
        TimeUnit.SECONDS.sleep(1);
        request.nextStatus(new DoneState(request));
        // THEN
        assertEquals("done", request.getStatus());
    }

    @Test
    void notifyClientTest() throws InterruptedException {
        // GIVEN
        BeverageManager request = new BeverageManager();
        State status = new DoneState(request);

        // WHEN
        TimeUnit.SECONDS.sleep(1);
        status.notifyClient();

        // THEN
        assertEquals("Order status: done", outputStreamCaptor.toString().trim());
    }

    @Test
    void nextStatusTest() throws InterruptedException {
        // GIVEN
        BeverageManager request = new BeverageManager();
        State status = new DoneState(request);

        // WHEN
        TimeUnit.SECONDS.sleep(1);
        status.nextStatus();

        // THEN
        assertEquals("", outputStreamCaptor.toString().trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);

    }

}