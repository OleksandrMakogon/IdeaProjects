package com.epam.training.restorant;

import org.w3c.dom.ls.LSInput;

import java.util.ArrayList;
import java.util.List;

public abstract class RestorantFactory {

    public abstract Product createProduct(Client client);

    public void releaseProduct(Product p){
        System.out.println(p.getName() + ". Effect:  " + p.getEffect() + " is prepared for " + p.getClient().Name);
        p.getClient().hapiness = p.getClient().hapiness + p.getEffect();
        System.out.println(p.getClient().Name + " happiness: " + p.getClient().hapiness);
    }

}
