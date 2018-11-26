package com.epam.training.restorant;

public class DecoratorMustard extends DecoratorProduct {
    DecoratorMustard(Product source) {
        super(source);
    }

    @Override
    public String getName(){
        return super.getName() + " with Mustard;";
    }

    @Override
    public double getEffect(){
        return 1.0;
    }

}
