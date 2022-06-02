package State;

import BeverageManager.BeverageManager;

public class DeliverState extends State {
    public DeliverState(BeverageManager request) {
        super(request);
        status = "deliver";
    }

    @Override
    public void nextStatus() {
        request.nextStatus(new DoneState(request));
    }
}
