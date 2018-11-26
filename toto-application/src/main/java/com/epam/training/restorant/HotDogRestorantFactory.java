package com.epam.training.restorant;

public class HotDogRestorantFactory extends RestorantFactory {
    @Override
    public Product createProduct(Client client) {
        return new HotDog(client);
    }
}
