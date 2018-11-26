package com.epam.training.restorant;

public class DecoratorProduct implements Product{

    private Product wrappee;

    DecoratorProduct(Product source) {
        this.wrappee = source;
    }

    @Override
    public String getName() {
        return wrappee.getName();
    }

    @Override
    public double getEffect() {
        return wrappee.getEffect();
    }

    @Override
    public Client getClient(){ return wrappee.getClient();}
}