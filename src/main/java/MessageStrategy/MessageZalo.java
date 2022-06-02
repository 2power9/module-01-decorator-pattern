package MessageStrategy;

import Helper.Client;

public class MessageZalo extends MessageStrategy {
    public MessageZalo(Client client) {
        super(client);
    }

    @Override
    public void sendMessage(String status) {
        System.out.println("====Status Message====");
        System.out.print("[Zalo] ");
        super.sendMessage(status);
    }
}
