package ca.ualberta.cs.lonelytwitter;

/**
 * Created by arhoskin on 1/14/16.
 */
public class NormalTweet extends Tweet {
    public NormalTweet(String message) {
        super(message);
    }

    public String getMessage() {
        return this.message;
    }

    @Override
    public boolean isImportant() {
        return false;
    }
}
