package domain;

    import java.time.LocalDate;

    abstract class EventFactory {

        public abstract SportEvent createEvent(String title, LocalDate startDate, LocalDate endDate);
    }
