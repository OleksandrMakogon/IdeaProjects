package totoBetApp;

import domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class TotoAppController {

    @Autowired
    private BetService totoService;

    @Autowired
    private View view;

    private Player player;
    private List<Bet> bets;

    /*public TotoAppController(TotoService totoService, View view) {
        this.totoService = totoService;
        this.view = view;
    }*/

    public void createData() {
        bets = totoService.createData();
    }

    public Boolean createPlayer() {
        view.write("Hi, what is your name?");
        String name = view.read();
        view.write("How much money do you have (please, enter > 0)?");

        String balance = view.read();
        //view.write("What is your currency? (EUR or USD)");
        Currency currency = Currency.EUR;

        //Player
        player = new Player(name, "111", Double.valueOf(balance), currency, true);
        if (player != null){
            view.write("Welcome " + name + "! Your balance: " + balance + " " + currency);
            return true;
        }
        view.write("Cannot create player with entered data!");
        return false;
    }

    public void betting(){
        //Betting
        List<Wager> wagers = new ArrayList<>();
        view.write("Please choose an outcome to bet on! (choose a number or press q for quit)");
        totoService.printBets(bets);
        String input = view.read();
        while (!"q".equals(input)){
            Odd odd = null;
            int count = 0;
            for(Bet bet: bets){
                if ((Integer.parseInt(input) - count) <= bet.outcomes.size()){
                    odd = bet.outcomes.get(Integer.parseInt(input) - count - 1).odds.get(0);
                    break;
                }
                count = count + bet.outcomes.size();
            }
            view.write("How much do you want to bet on it?");
            Double amount = Double.valueOf(view.read());
            while (amount > player.getBalance()) {
                view.write("You don't have enough money, your balance is " + player.getBalance() + " " + player.getCurrency());
                view.write("How much do you want to bet on it?");
                amount = Double.valueOf(view.read());
            }
            wagers.add(totoService.createWager(player, amount, odd));
            for(Wager wager: wagers){
                view.write(wager.toString());
            }
            view.write("Your new balance is " + player.getBalance() + " " + player.getCurrency());
            if (player.getBalance().equals(0.0)){
                view.write("No more wagers due to empty balance.");
                view.read();
                break;
            }
            view.write("Please choose an outcome to bet on! (choose a number or press q for quit)");
            totoService.printBets(bets);
            input = view.read();
        }

        totoService.setRandom(new Random());
        List<Result> results = totoService.getResults(bets);
        totoService.calculateBalance(wagers, results);
        view.write(player.toString());
    }
}
