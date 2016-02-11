package ca.ualberta.cs.lonelytwitter;

import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by sajediba on 2/8/16.
 */
public class IntentReaderActivityTest extends ActivityInstrumentationTestCase2{

    public IntentReaderActivityTest() {
        super(IntentReaderActivity.class);
    }

    //
    //

    //
    public void testSendText() {
        Intent i = new Intent();
        i.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, "Text mess 2");
        setActivityIntent(i);

        IntentReaderActivity ira = (IntentReaderActivity) getActivity();
        assertEquals("ira should get the text from intent", "Text mess 2", ira.getText());
    }

    public void testDisplayTest() {
        Intent i = new Intent();
        i.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, "Test");
        setActivityIntent(i);

        IntentReaderActivity a = (IntentReaderActivity) getActivity();
        assertEquals("Test", a.getText());
    }

    public void testDoubleText() {
        Intent i = new Intent();
        i.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, "Test");
        i.putExtra(IntentReaderActivity.MODE_OF_TRANSFORM_KEY, IntentReaderActivity.DOUBLE);
        setActivityIntent(i);

        IntentReaderActivity a = (IntentReaderActivity) getActivity();
        assertEquals("TestTest", a.getText());
    }

    public void testReveseText() {
        Intent i = new Intent();
        i.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, "Test");
        i.putExtra(IntentReaderActivity.MODE_OF_TRANSFORM_KEY, IntentReaderActivity.REVERSE);
        setActivityIntent(i);

        IntentReaderActivity a = (IntentReaderActivity) getActivity();
        assertEquals("tseT", a.getText());
    }

    public void testDefault() {
        Intent i = new Intent();
        i.putExtra(IntentReaderActivity.MODE_OF_TRANSFORM_KEY, IntentReaderActivity.NORMAL);
        setActivityIntent(i);

        IntentReaderActivity a = (IntentReaderActivity) getActivity();
        assertEquals("default", a.getText());
    }

    public void testVisibleOnScreen() {
        Intent i = new Intent();
        i.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, "Test");
        i.putExtra(IntentReaderActivity.MODE_OF_TRANSFORM_KEY, IntentReaderActivity.DOUBLE);
        setActivityIntent(i);

        IntentReaderActivity a = (IntentReaderActivity) getActivity();
        assertEquals("TestTest", a.getText());
        ViewAsserts.assertOnScreen(a.getWindow().getDecorView(), a.findViewById(R.id.intentText));
    }
}
