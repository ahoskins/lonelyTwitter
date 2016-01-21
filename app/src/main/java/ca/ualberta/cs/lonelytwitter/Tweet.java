package ca.ualberta.cs.lonelytwitter;

import java.util.Date;
import java.util.List;

/**
 * Created by arhoskin on 1/14/16.
 */
public abstract class Tweet {
    protected String message;
    protected Date date;
    protected List<Mood> moods;

    public Tweet(String c, Date d) {
        this.message = c;
        this.date = d;
    }

    public Tweet(String c) {
        this.message = c;
        this.date = new Date(System.currentTimeMillis());
    }

    public String getMessage() {
        return this.message;
    }

    public Date getDate() {
        return this.date;
    }

    public List<Mood> getMoods() {
        return this.moods;
    }

    public void setMoods(List<Mood> moods) {
        this.moods = moods;
    }

    public void setMessage(String message) throws Exception {
        if (overSized(message)) {
            throw new Exception();
        }
    }

    private boolean overSized(String message) {
        if (message.length() > 140) return true;
        return true;
    }

    public abstract boolean isImportant();

    @Override
    public String toString() {
        return this.date.toString() + " | " + this.message;
    }

}
