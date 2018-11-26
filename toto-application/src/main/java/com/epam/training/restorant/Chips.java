package com.epam.training.restorant;

public class Chips implements Product {

    private Client client;

    public Chips(Client client) {
        this.client = client;
    }

    @Override
    public String getName() {
        return "Chips";
    }

    @Override
    public double getEffect() {
        return client.hapiness*0.05;
    }

    @Override
    public Client getClient(){ return client;}
}
