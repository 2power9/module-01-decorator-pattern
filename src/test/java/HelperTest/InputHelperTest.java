package HelperTest;

import Helper.InputHelper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

@Timeout(3)
class InputHelperTest {

    @Test
    void inputTest() {
        String input = "2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        InputHelper inHelper = new InputHelper(System.in);

        String output = inHelper.input();
        assertEquals(input, output);
    }
}