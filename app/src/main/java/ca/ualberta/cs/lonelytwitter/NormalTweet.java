package ca.ualberta.cs.lonelytwitter;

/**
 * A normal kind of tweet
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
