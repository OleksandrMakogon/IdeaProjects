package com.epam.training.toto.service;

import com.epam.training.toto.domain.Hit;
import com.epam.training.toto.domain.Round;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class TotoService {
    public ArrayList<Round> roundList = new ArrayList<>();

    private static void accept(Round x) {
        System.out.println(x.getRoundDistribution());
    }

    public String getLargestPrize(){
        DecimalFormat myFormatter = new DecimalFormat("##,###,### UAH");

        return  myFormatter.format(roundList.stream().map(X -> X.hits.stream().map(y->y.getPrizeInt()).
                                    max(Integer::compare).get()).max(Integer::compare).get());
    }

    public void printHits(String dateStr, String hits){
        LocalDate date = Round.parseDate(dateStr);
        Boolean bFound = false;
        for (Round round : roundList){
            if (round.date.isEqual(date)){
                for (Hit hit : round.hits){
                    if (hit.getHits() == hits.length()){
                        System.out.printf("Hits: %s; Prize: %s", hits.length(), hit.getPrize());
                        bFound = true;
                        break;
                    }
                }
            }
        }
        if (!bFound){
            System.out.println("Date or hit is not found.");
        }
    }

    public void printRoundInfo(int index){
        System.out.printf("Round %d Info: \n%s", index+1, roundList.get(index).toString());
        System.out.println(roundList.get(index).getRoundDistribution());
        //System.out.println(roundList.get(index).getMaxPrize());
    }

    public void printAllDistribution(){
        roundList.stream().forEach(TotoService::accept);
    }


    public void printRounds(){
        roundList.stream().forEach(x -> System.out.println(x.getRound()));
    }

    public void readData(String fileName) throws FileNotFoundException {
        File textFile = new File(fileName);
        Scanner in = new Scanner(textFile);

        while (in.hasNextLine()) {
            roundList.add(new Round(in.nextLine()));
        }
        in.close();
    }

}
