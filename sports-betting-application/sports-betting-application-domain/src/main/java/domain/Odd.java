package domain;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Odd {
    private final Outcome outcome;
    private LocalDate validFrom;
    private LocalDate validTo;
    private Double oddValue;

    public Odd(Outcome outcome, LocalDate validFrom, LocalDate validTo, Double oddValue) {
        this.outcome = outcome;
        this.validFrom = validFrom;
        this.validTo = validTo;
        this.oddValue = oddValue;
    }
}
