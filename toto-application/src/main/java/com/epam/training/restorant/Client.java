package com.epam.training.restorant;

public class Client {
    public String Name;
    public double hapiness;

    public Client(String name, double hapiness) {
        Name = name;
        this.hapiness = hapiness;
        System.out.println("New client: " + name + ". Happiness: " + hapiness);
    }
}
