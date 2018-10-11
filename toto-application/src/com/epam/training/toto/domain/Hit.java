package com.epam.training.toto.domain;

public class Hit {
    private int hits;
    private String gamesCount;
    private String prize;

    public Hit(int hits, String gamesCount, String prize) {
        this.hits = hits;
        this.gamesCount = gamesCount;
        this.prize = prize;
    }

    @Override
    public String toString(){
        return "Hits: " + hits + "; games: " + gamesCount + "; prize: " + prize;
    }

    public Integer getPrizeInt() {
        return Integer.valueOf(prize.replace("UAH", "").trim().replaceAll(" ", ""));
    }

    public String getPrize() {
        return this.prize;
    }

    public int getHits() {
        return hits;
    }

}
