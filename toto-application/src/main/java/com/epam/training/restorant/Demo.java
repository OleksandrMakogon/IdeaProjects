package com.epam.training.restorant;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        //create client
        Client vasya = new Client("Vasya", 10.0);

        //Chips and hodDog factories
        RestorantFactory chipsFact = new ChipsRestorantFactory();
        RestorantFactory hotDogsFact = new HotDogRestorantFactory();

        //hot dog with mustard
        Product hotDog = hotDogsFact.createProduct(vasya);
        Product hotDogMustard = new DecoratorMustard(hotDog);
        hotDogsFact.releaseProduct(hotDogMustard);

        //chips with ketchup
        Product chips = chipsFact.createProduct(vasya);
        Product chipsKatchup = new DecoratorKetchup(chips);
        chipsFact.releaseProduct(chipsKatchup);

        //System.out.println("Vasya happiness after order: " + (vasya.hapiness + chipsKatchup.getEffect() + hotDogMustard.getEffect()));



    }
}
