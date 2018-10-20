package domain;

public class Player extends User {

    public String account;
    public Double balance;
    public Currency currency;

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
}
