package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

/**
 * Created by Andrew on 2016-01-28.
 */
public class TweetListTest extends ActivityInstrumentationTestCase2 {

    public TweetListTest() {
        super(LonelyTwitterActivity.class);
    }

    public void testAddTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("hello tweet");
        tweets.add(tweet);

        assertTrue(tweets.getCount() == 1);
    }

    public void testGetTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("hello tweet");
        Tweet tweet2 = new NormalTweet("hello tweet two");
        tweets.add(tweet);
        tweets.add(tweet2);

        assertTrue(tweets.getTweets().get(0).equals(tweet));
        assertTrue(tweets.getTweets().get(1).equals(tweet2));
    }

    public void testHasTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("hello tweet");
        tweets.add(tweet);

        assertTrue(tweets.hasTweet(tweet));

    }

    public void testRemoveTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("hello tweet");
        tweets.add(tweet);

        tweets.removeTweet(tweet);
        assertTrue(tweets.getCount() == 0);
    }

    public void testGetCount() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("hello tweet");
        tweets.add(tweet);

        assertTrue(tweets.getCount() == 1);
    }


}
