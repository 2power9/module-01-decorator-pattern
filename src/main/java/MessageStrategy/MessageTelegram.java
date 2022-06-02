package MessageStrategy;

import Helper.Client;

public class MessageTelegram extends MessageStrategy {
    public MessageTelegram(Client client) {
        super(client);
    }

    @Override
    public void sendMessage() {
        System.out.print("[Telegram] ");
        super.sendMessage();
    }
}
