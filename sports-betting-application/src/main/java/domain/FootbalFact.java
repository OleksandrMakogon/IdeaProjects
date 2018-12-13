package domain;

import java.time.LocalDate;

public class FootbalFact extends EventFactory {
    @Override
    public SportEvent createEvent(String title, LocalDate startDate, LocalDate endDate) {//NOPMD
        SportEvent event = new FootballSportEvent(title, startDate, endDate);
        event.setType();
        return event;
    }
}
