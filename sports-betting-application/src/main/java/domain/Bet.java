package domain;

import java.util.ArrayList;
import java.util.List;

public class Bet {
    public SportEvent sportEvent;
    public String description;
    public List<Outcome> outcomes = new ArrayList<>();
    public BetType betType;

    public Bet(SportEvent sportEvent, BetType betType, String description) {
        this.sportEvent = sportEvent;
        this.description = description;
        this.betType = betType;
    }
}

