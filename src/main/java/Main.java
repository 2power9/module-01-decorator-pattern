import BeverageManager.BeverageManager;
import Helper.InputHelper;

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
            int op = Integer.parseInt(in.input());
            if (op == 1) break;
        }
        System.out.println("Goodbye!!!");
    }
}