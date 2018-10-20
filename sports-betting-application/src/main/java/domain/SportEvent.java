package domain;

import java.time.LocalDate;

public abstract class SportEvent {

    protected String type;
    abstract void setType();
    public String getType() {
        return this.type;
    }

    public String title;
    public LocalDate startDate;
    public LocalDate endDate;

}
