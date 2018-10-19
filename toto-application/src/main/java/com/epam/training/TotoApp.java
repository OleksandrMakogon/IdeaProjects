package com.epam.training;

import com.epam.training.toto.service.TotoService;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class TotoApp {

    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "toto.csv";
        TotoService totoService = new TotoService();
        totoService.readData(fileName);
        //totoService.printRounds();
        System.out.println("Round Count: " + totoService.roundList.size());
        totoService.printRoundInfo(0);
        System.out.println("All round distribution:");
        totoService.printAllDistribution();
        System.out.println("Largest prize: " + totoService.getLargestPrize());
        totoService.printHits("2015.10.29", "1222121212X11");
        Scanner in = new Scanner(System.in);
        System.out.print("\nInput date (Year.month.day): ");
        String dateStr1 = in.nextLine();
        System.out.print("Input outcomes: ");
        String outcomes = in.nextLine();
        totoService.printHits(dateStr1, outcomes);

    }
}





