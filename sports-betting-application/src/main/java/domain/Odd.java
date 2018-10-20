package domain;

import java.time.LocalDate;

public class Odd {
    public Outcome outcome;
    public LocalDate validFrom;
    public LocalDate validTo;
    public Double oddValue;

    public Odd(Outcome outcome, LocalDate validFrom, LocalDate validTo, Double oddValue) {
        this.outcome = outcome;
        this.validFrom = validFrom;
        this.validTo = validTo;
        this.oddValue = oddValue;
    }
}
