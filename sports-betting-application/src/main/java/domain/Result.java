package domain;

public class Result {
    public Outcome outcome;
    public SportEvent event;
    public String description;


    public Result(Outcome outcome, SportEvent event, String description) {
        this.outcome = outcome;
        this.event = event;
        this.description = description;
    }
}
