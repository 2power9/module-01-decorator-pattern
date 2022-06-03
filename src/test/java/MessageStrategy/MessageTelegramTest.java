package MessageStrategy;

import Helper.Client;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@Timeout(3)
class MessageTelegramTest {
    private PrintStream standardOut;
    private ByteArrayOutputStream outputStreamCaptor;

    @BeforeEach
    public void setUp() {
        standardOut = System.out;
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void sendMessageTest() throws InterruptedException {
        // GIVEN
        Client client = new Client("nhutnh3", "01234");
        MessageStrategy message = new MessageTelegram(client);
        String expectText ="====Status Message====\n" + "[Telegram] Client's name: " + client.getName() + "\nClient's telephone: " +
                client.getTel() + "\nStatus: done";
        // WHEN
        TimeUnit.SECONDS.sleep(1);
        message.sendMessage("done");
        // THEN
        assertEquals(expectText, outputStreamCaptor.toString().trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);

    }

}