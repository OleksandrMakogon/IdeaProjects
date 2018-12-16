package domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player extends User {

    private String account;
    private Double balance;
    private Currency currency;

    public Player(String name, String account, Double balance, Currency currency, Boolean enabled) {
        this.account = account;
        this.balance = balance;
        this.currency = currency;
        this.name = name;
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "Player: " + name + ". Balance: " + balance + " " + currency;
    }

    @Override
    public void say(){
        System.out.println("I'm player. My name is " + name);
    }
}
