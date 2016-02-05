package ca.ualberta.cs.lonelytwitter;

/**
 * Class representing a tweet of special kind
 */
public class ImportantTweet extends Tweet implements Tweetable {

    public ImportantTweet(String message) throws Exception {
        super(message);
    }

    public String getMessage() {
        return this.message;
    }

    @Override
    public boolean isImportant() {
        return true;
    }

}
