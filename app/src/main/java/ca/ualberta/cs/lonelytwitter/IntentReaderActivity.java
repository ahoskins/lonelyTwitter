package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.TextView;

public class IntentReaderActivity extends Activity {

    public static final String TEXT_TO_TRANSFORM_KEY = "TEXT";
    public static final String MODE_OF_TRANSFORM_KEY = "TRANSFORM";

    public static final int NORMAL = 1;
    public static final int REVERSE = 2;
    public static final int DOUBLE = 3;

    private String text;
    private int mode;

    public String getText() {
        return text;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_reader);

        Intent i = getIntent();
        mode = i.getIntExtra(MODE_OF_TRANSFORM_KEY, NORMAL);
        text = i.getStringExtra(TEXT_TO_TRANSFORM_KEY) != null ? i.getStringExtra(TEXT_TO_TRANSFORM_KEY) : "default";

        if (mode == DOUBLE) {
            text = transformText(text);
        } else if (mode == REVERSE) {
            text = reverse(text);
        }

        ((TextView) findViewById(R.id.intentText)).setText(text);
    }

    public String transformText(String str) {
        switch (mode) {
            case REVERSE:
                char[] str2 =  str.toCharArray();
                for (int i = 0; i < str2.length / 2; i++) {
                    char tmp = str2[i];
                    str2[i] = str2[str2.length - i -1];
                    str2[str2.length - i - 1] = tmp;
                }//for.
                return new String(str2);
            case DOUBLE:
                return str + str;
            default:
                return str;
        }
    }

    public String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}
