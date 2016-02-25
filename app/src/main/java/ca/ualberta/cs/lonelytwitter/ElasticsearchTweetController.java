package ca.ualberta.cs.lonelytwitter;

import android.os.AsyncTask;
import android.util.Log;

import com.searchly.jestdroid.DroidClientConfig;
import com.searchly.jestdroid.JestClientFactory;
import com.searchly.jestdroid.JestDroidClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.searchbox.core.DocumentResult;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;

/**
 * Created by esports on 2/17/16.
 */
public class ElasticsearchTweetController {
    private static JestDroidClient client;

    public static void verifyConfig() {
        DroidClientConfig.Builder builder = new DroidClientConfig.Builder("http://cmput301.softwareprocess.es:8080");
        DroidClientConfig config = builder.build();

        JestClientFactory factory = new JestClientFactory();
        factory.setDroidClientConfig(config);
        client = (JestDroidClient) factory.getObject();
    }

    //TODO: A function that adds a tweet
    public static void addTweet(NormalTweet tweet) {

    }

    public static ArrayList<NormalTweet> getTweets() {
        verifyConfig();
        // TODO:
        return null;
    }

    public static class GetTweetsTask extends AsyncTask<String, Void, ArrayList<NormalTweet>> {
        @Override
        protected ArrayList<NormalTweet> doInBackground(String ... params) {
            verifyConfig();

            ArrayList<NormalTweet> tweetsFromSearch = new ArrayList<NormalTweet>();

            String searchString  = params[0];
            Search search = new Search.Builder(searchString).addIndex("testing").addType("tweet").build();

            try {
                SearchResult res = client.execute(search);
                if (res.isSucceeded()) {
                    NormalTweet tweets = res.getSourceAsObject(NormalTweet.class);
                    tweetsFromSearch.add(tweets);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
    }

    public static class AddTweetTask extends AsyncTask<NormalTweet, Void, Void> {
        @Override
        protected Void doInBackground(NormalTweet... params) {
            verifyConfig();

            for (NormalTweet tweet : params) {

                Index index = new Index.Builder(tweet).index("testing").type("tweet").build();

                try {
                    DocumentResult execute = client.execute(index);
                    if (execute.isSucceeded()) {
                        tweet.setId(execute.getId());
                    } else {
                        Log.e("TODO", "failed");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return null;
        }
    }
}
