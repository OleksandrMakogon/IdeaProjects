import domain.*;
import main.TotoService;
import main.UI;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class TotoApp {
    private TotoApp(){

    }
    public static void main(String[] args) {

        TotoService totoService = new TotoService();
        List<Bet> bets = totoService.createData();

        final UI ui = new UI();

        System.out.println("Hi, what is your name?");
        String name = ui.getStringFromConsole();
        System.out.println("How much money do you have (more than 0)?");
        //Double balance = ui.getDoubleFromConsole();
        String balance = ui.getStringFromConsole();
        System.out.println("What is your currency? (EUR or USD)");
        String currency = ui.getStringFromConsole();

        //Player
        Player player = new Player(name, "111", Double.valueOf(balance), Currency.valueOf(currency), true);
        System.out.println("Welcome " + name + "! Your balance: " + balance + " " + currency);

        //Betting
        List<Wager> wagers = new ArrayList<>();
        System.out.println("Please choose an outcome to bet on! (choose a number or press q for quit)");
        totoService.printBets(bets);
        String input = ui.getStringFromConsole();
        while (!"q".equals(input)){
            Odd odd = null;
            Integer count = 0;
            for(Bet bet: bets){
                if ((Integer.parseInt(input) - count) <= bet.outcomes.size()){
                    odd = bet.outcomes.get(Integer.parseInt(input) - count - 1).odds.get(0);
                    break;
                }
                count = count + bet.outcomes.size();
            }
            System.out.println("How much do you want to bet on it?");
            Double amount = Double.valueOf(ui.getStringFromConsole());
            while (amount > player.getBalance()) {
                System.out.println("You don't have enough money, your balance is " + player.getBalance() + " " + player.getCurrency());
                System.out.println("How much do you want to bet on it?");
                amount = Double.valueOf(ui.getStringFromConsole());
            }
            wagers.add(totoService.createWager(player, amount, odd));
            for(Wager wager: wagers){
                System.out.println(wager.toString());
            }
            System.out.println("Your new balance is " + player.getBalance() + " " + player.getCurrency());
            if (player.getBalance().equals(0.0)){
                System.out.println("No more wagers due to empty balance.");
                ui.getStringFromConsole();
                break;
            }
            System.out.println("Please choose an outcome to bet on! (choose a number or press q for quit)");
            totoService.printBets(bets);
            input = ui.getStringFromConsole();
        }

        //Print wagers
        //for(Wager wager: wagers){System.out.println(wager.toString());}
        totoService.setRandom(new Random());
        List<Result> results = totoService.getResults(bets);
        totoService.calculateBalance(wagers, results);
        System.out.println(player.toString());

    }
}

