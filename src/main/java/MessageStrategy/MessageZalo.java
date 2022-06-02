package MessageStrategy;

import Helper.Client;

public class MessageZalo extends MessageStrategy {
    public MessageZalo(Client client) {
        super(client);
    }

    @Override
    public void sendMessage() {
        System.out.print("[Zalo] ");
        super.sendMessage();
    }
}
