package com.epam.training.restorant;

public class DecoratorKetchup extends DecoratorProduct {
    DecoratorKetchup(Product source) {
        super(source);
    }

    @Override
    public String getName(){
        return super.getName() + " with Ketchup;";
    }

    @Override
    public double getEffect(){
        return super.getEffect()*2;
    }

}
