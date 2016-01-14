package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by arhoskin on 1/14/16.
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
