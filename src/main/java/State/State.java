package State;

import BeverageManager.BeverageManager;

public class State {
    BeverageManager request;
    String status;

    public State(BeverageManager request) {
        this.request = request;
    }

    public String getStatus() {
        return status;
    }

    public void notifyClient() {
        System.out.println("Order status: " + status);
    }
    public void nextStatus() {}
}
