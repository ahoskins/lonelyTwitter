package ca.ualberta.cs.lonelytwitter;

/**
 * Created by arhoskin on 1/14/16.
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
