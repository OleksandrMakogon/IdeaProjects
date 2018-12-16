package domain;

import java.util.ArrayList;
import java.util.List;

public class Outcome {

    public String value;
    public Bet bet;
    public List<Odd> odds = new ArrayList<>();

    public Outcome(String value, Bet bet) {
        this.value = value;
        this.bet = bet;
    }
}
