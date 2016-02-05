package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * A tweet can have a mood and this class represents one of those
 */
public class JavaMood extends Mood {
    public JavaMood(Date date) {
        super(date);
    }

    public JavaMood() {
        super();
    }

    @Override
    public String getMood() {
        return "Java Mood";
    }

}
