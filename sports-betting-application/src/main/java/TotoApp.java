import domain.*;

import java.util.ArrayList;
import java.util.List;

public class TotoApp {
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
        while (!input.equals("q")){
            Odd odd = null;
            Integer Count = 0;
            for(Bet bet: bets){
                if ((Integer.valueOf(input) - Count) > bet.outcomes.size()){
                    Count = Count + bet.outcomes.size();
                }
                else{
                    odd = bet.outcomes.get(Integer.valueOf(input) - Count - 1).odds.get(0);
                    break;
                }
            }
            System.out.println("How much do you want to bet on it?");
            Double amount = Double.valueOf(ui.getStringFromConsole());
            while (!totoService.checkBalance(player, amount)) {
                System.out.println("You don't have enough money, your balance is " + player.balance + " " + player.currency);
                System.out.println("How much do you want to bet on it?");
                amount = Double.valueOf(ui.getStringFromConsole());
            }
            wagers.add(totoService.createWager(player, amount, odd));
            for(Wager wager: wagers){System.out.println(wager.toString());}
            System.out.println("Your new balance is " + player.balance + " " + player.currency);
            if (player.balance.equals(0.0)){
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

        List<Result> results = totoService.getResults(bets);
        totoService.calculateBalance(wagers, results);
        System.out.println(player.toString());

    }
}

