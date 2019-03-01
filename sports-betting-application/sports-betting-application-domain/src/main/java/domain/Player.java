package domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "player")
public class Player extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long player_id;

    private String player_name;
    private String player_login;

    private String account;
    private Double balance;
    @Enumerated(EnumType.STRING)
    private Currency currency;
    private String password;

    public Player(String name, String account, Double balance, Currency currency, Boolean enabled) {
        this.account = account;
        this.balance = balance;
        this.currency = currency;
        this.player_name = name;
        this.enabled = enabled;
    }

    public Player(){};

    @Override
    public String toString() {
        return "Player: " + player_name + ". Balance: " + balance + " " + currency;
    }

    @Override
    public void say(){
        System.out.println("I'm player. My name is " + player_name);
    }

    public Long getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(Long player_id) {
        this.player_id = player_id;
    }

    public String getPlayer_name() {
        return player_name;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
    }

    public String getPlayer_login() {
        return player_login;
    }

    public void setPlayer_login(String player_login) {
        this.player_login = player_login;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
