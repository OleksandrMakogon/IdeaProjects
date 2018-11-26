package domain;

import java.time.LocalDate;

public class FootballSportEvent extends SportEvent {


    public FootballSportEvent(String title, LocalDate startDate, LocalDate endDate) {
        this.endDate = endDate;
        this.startDate = startDate;
        this.title = title;
        setType();
    }

    @Override
    void setType() {
        type = "Football event";
    }

}
