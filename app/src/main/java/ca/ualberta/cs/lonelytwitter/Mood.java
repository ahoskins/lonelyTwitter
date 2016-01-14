package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by arhoskin on 1/14/16.
 */
public abstract class Mood {
    private Date date;

    public Mood(Date date) {
        this.date = date;
    }

    public Mood() {
        this.date = new Date(System.currentTimeMillis());
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public abstract String getMood();
}
