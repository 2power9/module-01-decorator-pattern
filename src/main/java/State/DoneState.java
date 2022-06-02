package State;

import BeverageManager.BeverageManager;

public class DoneState extends State {
    public DoneState(BeverageManager request) {
        super(request);
        status = "done";
    }
}
