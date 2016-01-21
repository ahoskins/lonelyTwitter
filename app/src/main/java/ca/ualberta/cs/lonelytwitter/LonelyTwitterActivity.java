package ca.ualberta.cs.lonelytwitter;

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
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav";

	// UI Elements
	private EditText mBodyText;
	private ListView mTweetList;
	private Button mSaveButton;
	private Button mClearButton;

	// List and Adapter
	private ArrayList<Tweet> mTweets;
	private ArrayAdapter<Tweet> mTweetAdapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main);

		mBodyText = (EditText) findViewById(R.id.body);
		mSaveButton = (Button) findViewById(R.id.save);
		mClearButton = (Button) findViewById(R.id.clear);
		mTweetList = (ListView) findViewById(R.id.oldTweetsList);

		mSaveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = mBodyText.getText().toString();
				Tweet twt = new NormalTweet(text);
				mTweets.add(twt);
				mTweetAdapter.notifyDataSetChanged();
				saveInFile();
			}
		});

		mClearButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				mTweets.clear();
				mTweetAdapter.notifyDataSetChanged();
				saveInFile();
			}
		});
	}

	@Override
	protected void onStart() {
		super.onStart();

		loadFromFile();
		mTweetAdapter = new ArrayAdapter<Tweet>(this, R.layout.list_item, mTweets);
		mTweetList.setAdapter(mTweetAdapter);
	}

	private void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));

			Gson gson = new Gson();
			Type listType = new TypeToken<ArrayList<NormalTweet>>() {}.getType();
			mTweets = gson.fromJson(in, listType);

		} catch (FileNotFoundException e) {
			mTweets = new ArrayList<Tweet>();
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME, 0);

			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
			Gson gson = new Gson();
			gson.toJson(mTweets, out);
			out.flush();

			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}