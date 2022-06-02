package MessageStrategy;

import Helper.Client;

public abstract class MessageStrategy {
    Client client;

    public MessageStrategy(Client client) {
        this.client = client;
    }

    public void sendMessage() {
        System.out.println("Client's name: " + client.getName() + "\nClient's telephone: " + client.getTel());
    }

}
