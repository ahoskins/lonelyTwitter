package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class LonelyTwitterActivity extends Activity {

    private static final String FILENAME = "file.sav";
    private EditText bodyText;
    private ListView oldTweetsList;

    private ArrayList<NormalTweet> tweets = new ArrayList<NormalTweet>();
    private ArrayAdapter<NormalTweet> adapter;

    public ArrayAdapter<NormalTweet> getAdapter() {
        return adapter;
    }

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        bodyText = (EditText) findViewById(R.id.body);
        Button saveButton = (Button) findViewById(R.id.save);
        oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

        saveButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String text = bodyText.getText().toString();
                NormalTweet latestTweet = new NormalTweet(text);

                tweets.add(latestTweet);
                adapter.notifyDataSetChanged();

                // TODO: Replace with Elasticsearch
                ElasticsearchTweetController.AddTweetTask addTweetTask = new ElasticsearchTweetController.AddTweetTask();
                addTweetTask.execute(latestTweet);


                setResult(RESULT_OK);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        // Get latest tweets
        // TODO: Replace with Elasticsearch
        ElasticsearchTweetController.GetTweetsTask getTweetsTask=  new ElasticsearchTweetController.GetTweetsTask();
        getTweetsTask.execute("");

        try {
            tweets = getTweetsTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        // Binds tweet list with view, so when our array updates, the view updates with it
        adapter = new ArrayAdapter<NormalTweet>(this, R.layout.list_item, tweets);
        oldTweetsList.setAdapter(adapter);
    }
}