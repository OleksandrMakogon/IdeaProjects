package com.epam.training.restorant;

public class ChipsRestorantFactory extends RestorantFactory {
    @Override
    public Product createProduct(Client client) {
        return new Chips(client);
    }
}
