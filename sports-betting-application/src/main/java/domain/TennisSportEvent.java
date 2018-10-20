package domain;

import java.time.LocalDate;

public class TennisSportEvent extends SportEvent {

    public TennisSportEvent(String title, LocalDate startDate, LocalDate endDate) {
        this.endDate = endDate;
        this.startDate = startDate;
        this.title = title;
        setType();
    }

    @Override
    void setType() {
        type = "Tennis";
    }
}