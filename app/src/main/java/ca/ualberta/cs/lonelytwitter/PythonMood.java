package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by arhoskin on 1/14/16.
 */
public class PythonMood extends Mood {
    public PythonMood(Date date) {
        super(date);
    }

    public PythonMood() {
        super();
    }

    @Override
    public String getMood() {
        return "Python Mood";
    }
}
