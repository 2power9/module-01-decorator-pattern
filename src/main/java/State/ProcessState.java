package State;

import BeverageManager.BeverageManager;

public class ProcessState extends State {
    public ProcessState(BeverageManager request) {
        super(request);
        status = "process";
    }

    @Override
    public void nextStatus() {
        request.nextStatus(new DeliverState(request));
    }
}
