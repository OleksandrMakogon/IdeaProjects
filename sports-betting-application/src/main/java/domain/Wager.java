package domain;

import java.time.LocalDate;

public class Wager {

    public Player player;
    public Odd odd;
    public Double amount;
    public Currency currency;
    public LocalDate timestamp;
    public Boolean isProcessed;
    public Boolean isWin;

    public Wager(Player player, Odd odd, Double amount) {
        this.player = player;
        this.odd = odd;
        this.amount = amount;
        this.currency = player.currency;
        this.isProcessed = false;
    }

    @Override
    public String toString() {
        return "Wager for '" + odd.outcome.bet.sportEvent.title + "'. " + odd.outcome.bet.description +
                " will be " + odd.outcome.value + ". Amount: " + amount + " " + currency + ". Odd is " + odd.oddValue + ". Player: " + player.name;
    }
}

