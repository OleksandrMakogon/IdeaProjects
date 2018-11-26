package com.epam.training.restorant;

public class HotDog implements Product {
    public Client client;

    public HotDog(Client client) {
        this.client = client;
    }

    @Override
    public String getName() {
        return "Hot Dog";
    }

    @Override
    public double getEffect() { return 2.0; }

    @Override
    public Client getClient(){ return client;}
}
