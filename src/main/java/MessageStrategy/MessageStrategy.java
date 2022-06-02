package MessageStrategy;

import Helper.Client;

public abstract class MessageStrategy {
    Client client;

    public MessageStrategy(Client client) {
        this.client = client;
    }

    public void sendMessage(String status) {
        System.out.println("Client's name: " + client.getName() + "\nClient's telephone: " + client.getTel() +
                "\nStatus: " + status);
    }

}
