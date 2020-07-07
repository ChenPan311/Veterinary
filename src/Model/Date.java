package Model;

import java.io.Serializable;

public class Date implements Serializable {
    private String day,hour;

    public Date() {
    }

    public Date(String day, String hour) {
        this.day = day;
        this.hour = hour;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    @Override
    public String toString() {
        return day + " "+ hour;
    }
}
