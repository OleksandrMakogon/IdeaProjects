import com.sun.org.apache.xpath.internal.operations.Bool;
import domain.*;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.*;

public class TotoService {


    public List<Result> getResults(List<Bet> bets) {

        //Generate results
        List<Result> results = new ArrayList<>();
        for (Bet bet : bets) {
            Random random = new Random();
            int pos = random.nextInt(bet.outcomes.size());
            results.add(new Result(bet.outcomes.get(pos), bet.sportEvent, bet.description));
        }
        for (Result result : results) {
            System.out.println("Result for '" + result.event.title + "' " + result.event.getType() + ". " + result.description + ": " + result.outcome.value);
        }
        return results;
    }

    public void calculateBalance(List<Wager> wagers, List<Result> results) {
        for (Wager wager : wagers) {
            for (Result result : results) {
                if (wager.odd.outcome.equals(result.outcome)) {
                    Double prize = wager.odd.oddValue * wager.amount;
                    System.out.println("Wager has played. " + wager.toString() + ". Prize: " + prize + " " + wager.currency);
                    wager.player.balance = wager.player.balance + prize;
                    break;
                }
            }
        }
    }
    public Wager createWager(Player player, Double amount, Odd odd){
        player.balance = player.balance - amount;
        return new Wager(player, odd, amount);
    }
    public Boolean checkBalance(Player player, Double amount){
        if (amount > player.balance) {
            return false;
        }
        else {
            return true;
            }
    }

    public List<Bet> createData(){
        FootballSportEvent fManUtdChelsea = new FootballSportEvent("ManUtd - Chelsea",
                LocalDate.of(2018, 10, 20),
                LocalDate.of(2018, 10, 21));

        TennisSportEvent tFedererNadal = new TennisSportEvent("Federer - Nadal",
                LocalDate.of(2018, 10, 20),
                LocalDate.of(2018, 10, 21));

        //create Bets
        Bet winnerManUtdChelsea = new Bet(fManUtdChelsea, BetType.Winner, "Winner");
        Bet goalsManUtdChelsea = new Bet(fManUtdChelsea, BetType.Goals, "Goals");
        Bet scoreAzar = new Bet(fManUtdChelsea, BetType.Player_Score, "Eden Azar score");

        //create Outcomes and Odds for winner MU-Chelsea
        Outcome manUntWinner = new Outcome("ManUnt", winnerManUtdChelsea);
        Odd manUntWinnerOdd = new Odd(manUntWinner, LocalDate.now(), LocalDate.now(), 1.9);
        manUntWinner.odds.add(manUntWinnerOdd);
        Outcome chelseaWinner = new Outcome("Chelsea", winnerManUtdChelsea);
        Odd chelseaWinnerOdd = new Odd(chelseaWinner, LocalDate.now(), LocalDate.now(), 2.0);
        chelseaWinner.odds.add(chelseaWinnerOdd);
        Outcome draw = new Outcome("Draw", winnerManUtdChelsea);
        Odd drawOdd = new Odd(draw, LocalDate.now(), LocalDate.now(), 1.7);
        draw.odds.add(drawOdd);

        //create Outcomes and Odds for goals MU-Chelsea
        Outcome goals0 = new Outcome("1", goalsManUtdChelsea);
        Odd goals0Odd = new Odd(goals0, LocalDate.now(), LocalDate.now(), 2.0);
        goals0.odds.add(goals0Odd);
        Outcome goals1 = new Outcome("2", goalsManUtdChelsea);
        Odd goals1Odd = new Odd(goals1, LocalDate.now(), LocalDate.now(), 1.8);
        goals1.odds.add(goals1Odd);
        Outcome goals2More = new Outcome(">=3", goalsManUtdChelsea);
        Odd goals2MoreOdd = new Odd(goals2More, LocalDate.now(), LocalDate.now(), 1.9);
        goals2More.odds.add(goals2MoreOdd);

        //create Outcomes and Odds for Player scores
        Outcome scoresAzar1 = new Outcome("0", scoreAzar);
        Odd scoresAzar1Odd = new Odd(scoresAzar1, LocalDate.now(), LocalDate.now(), 3.0);
        scoresAzar1.odds.add(scoresAzar1Odd);
        Outcome scoresAzar2 = new Outcome("1", scoreAzar);
        Odd scoresAzar2Odd = new Odd(scoresAzar2, LocalDate.now(), LocalDate.now(), 4.0);
        scoresAzar2.odds.add(scoresAzar2Odd);

        //Fill bets with outcomes
        winnerManUtdChelsea.outcomes.add(manUntWinner);
        winnerManUtdChelsea.outcomes.add(chelseaWinner);
        winnerManUtdChelsea.outcomes.add(draw);
        goalsManUtdChelsea.outcomes.add(goals0);
        goalsManUtdChelsea.outcomes.add(goals1);
        goalsManUtdChelsea.outcomes.add(goals2More);
        scoreAzar.outcomes.add(scoresAzar1);
        scoreAzar.outcomes.add(scoresAzar2);

        //All bets
        List<Bet> bets = new ArrayList<>();
        Collections.addAll(bets, winnerManUtdChelsea, goalsManUtdChelsea, scoreAzar );
        return bets;
    }

    public void printBets(List<Bet> bets) {
        //Print Bets

        int count = 1;
        for (Bet bet : bets) {
            for (Outcome outcome : bet.outcomes) {
                System.out.println(count + ": Bet on " + bet.sportEvent.title + "; " + bet.description + " will be " +
                        outcome.value + ". The odd is: " + outcome.odds.get(0).oddValue);
                count++;
            }
        }
    }
}


