package com.epam.training.toto.domain;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class Round {
    private String round;
    public String[] roundSplit;
    public String[] outcomes = new String[14];
    public String year;
    public String week;
    public String roundNumber;
    public LocalDate date;
    public ArrayList<Hit> hits = new ArrayList<>();

    @Override
    public String toString(){
        String hitString = "";
        for (Hit hit : hits) hitString = hitString + hit.toString() + "\n";
        //String hitString = String.join("\n", hits.stream().map(x -> x.toString()));

        return String.format("Year: %s; week: %s; number:%s; date: %s\nOutcomes: %s\n%s",
                year, week, roundNumber, date.toString(), String.join("|", outcomes), hitString);
    }

    public Round(String round) {
        this.round = round;
        this.round = this.round.replace("+", "");
        getHits();
    }

    public String getRoundDistribution(){
        int count = 14;
        double team1 = Arrays.stream(outcomes).filter(x -> x.equals("1")).count()*1.0/count;
        double team2 = Arrays.stream(outcomes).filter(x -> x.equals("2")).count()*1.0/count;
        double draw = Arrays.stream(outcomes).filter(x -> x.toUpperCase().equals("X")).count()*1.0/count;
        DecimalFormat myFormatter = new DecimalFormat("##.## %");
        return String.format("team #1 won: %s, team #2 won: %s, draw: %s",
                myFormatter.format(team1), myFormatter.format(team2), myFormatter.format(draw));
    }

    public String getRound() {
        return round;
    }

    public Integer getMaxPrize(){
        return hits.stream().map(x -> x.getPrizeInt()).max(Integer::compare).get();
    }

    public void setRound(String round) {
        this.round = round;
    }

    private void getHits(){
        roundSplit = this.round.split(";");
        year = roundSplit[0];
        week = roundSplit[1];
        roundNumber = roundSplit[2];
        date = parseDate(roundSplit[3]);
        hits.add(new Hit(14, roundSplit[4], roundSplit[5]));
        hits.add(new Hit(13, roundSplit[6], roundSplit[7]));
        hits.add(new Hit(12, roundSplit[8], roundSplit[9]));
        hits.add(new Hit(11, roundSplit[10], roundSplit[11]));
        hits.add(new Hit(10, roundSplit[12], roundSplit[13]));
        System.arraycopy(roundSplit, 14, outcomes, 0, 14);

    }

    public static LocalDate parseDate(String dateStr){
        String[] splitDate = dateStr.split("\\.");
        if (splitDate.length < 2) {
            //System.out.println("Not expected round date: " + dateStr);
            return LocalDate.of(1900, 1, 1);
        }
        return LocalDate.of(Integer.valueOf(splitDate[0]), Integer.valueOf(splitDate[1]), Integer.valueOf(splitDate[2]));
    }


}
