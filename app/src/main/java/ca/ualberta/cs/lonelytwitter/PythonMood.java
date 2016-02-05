package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Similar to javamood, python mood is a state a tweet can be associated with
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
