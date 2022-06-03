package Helper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    @Test
    void getNameTest() {
        // GIVEN & WHEN
        String expectName = "Tran Nguyen Hue Nhu";
        Client obj = new Client(expectName, "0123456789");
        // THEN
        assertEquals(expectName, obj.getName());
    }

    @Test
    void setNameTest() {
        // GIVEN
        String expectName = "Andrena";
        Client obj = new Client("Tran Nguyen Hue Nhu", "0123456789");
        // WHEN
        obj.setName(expectName);
        // THEN
        assertEquals(expectName, obj.getName());
    }

    @Test
    void getTelTest() {
        // GIVEN & WHEN
        String expectTel = "0123456789";
        Client obj = new Client("Tran Nguyen Hue Nhu", expectTel);
        // THEN
        assertEquals(expectTel, obj.getTel());
    }

    @Test
    void setTelTest() {
        // GIVEN
        String expectTel = "0123456799";
        Client obj = new Client("Tran Nguyen Hue Nhu", "0123456789");
        // WHEN
        obj.setTel(expectTel);
        // THEN
        assertEquals(expectTel, obj.getTel());
    }
}