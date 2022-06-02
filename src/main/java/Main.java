import BeverageManager.BeverageManager;
import Helper.InputHelper;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        InputHelper in = new InputHelper(System.in);
        while (true) {
            BeverageManager manager = new BeverageManager();
            manager.order();
            System.out.println("======================================================");
            System.out.println("======================================================");
            System.out.println("======================================================");
            System.out.print("New order? (0 - yes | 1 - no): ");
            String op = in.input();
            if (Objects.equals(op, "1")) break;
        }
        System.out.println("Goodbye!!!");
    }
}