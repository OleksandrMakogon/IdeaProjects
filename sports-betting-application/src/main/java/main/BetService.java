package main;

import domain.Odd;
import domain.Player;
import domain.Result;
import domain.Wager;

import java.util.List;

interface BetService {

    void calculateBalance(List<Wager> wagers, List<Result> results);
    Wager createWager(Player player, Double amount, Odd odd);

}
