package main.Helper;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class InputHelper {
    private final Scanner in;
    public InputHelper(InputStream in) {
        this.in = new Scanner(System.in);
    }
    public String input() {
        return in.next();
    }
}
