package ca.ualberta.cs.lonelytwitter.test;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.NormalTweetModel;

/*
 * generate this class with new.. JUnit Test Case
 * set superclass to ActivityInstrumentationTestCase2
 */
@SuppressLint("NewApi")
public class LonelyTwitterActivityUITest extends
		ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

	Instrumentation instrumentation;
	Activity activity;
	EditText textInput;
	ListView listView;
	
	public LonelyTwitterActivityUITest() {
		super(LonelyTwitterActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		instrumentation = getInstrumentation();
		activity = getActivity();
		listView = (ListView)activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.oldTweetsList);
		
		textInput = ((EditText) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.body));
	}
	
	public void testAddTweet() throws Throwable {
		runTestOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				int x = listView.getAdapter().getCount();
				makeTweet("hi there #testing");
				int xPlusOne = listView.getAdapter().getCount();
				assertEquals("The adapters count should be incremented by one", (x + 1), xPlusOne);
				
				NormalTweetModel ntm = new NormalTweetModel();
				
				assertEquals("New thing in adapter ia a" +
						"normal tweet model", ntm.getClass(), listView.getAdapter().getItem(xPlusOne - 1).getClass());
				
				
				
				String original = "hi there #testing";
			
				assertEquals("New thing in list is correct", original, ((NormalTweetModel) listView.getAdapter().getItem(xPlusOne - 1)).getText());
		
			}
			
			
		});

	}
	
	/*
	 * fills in the input text field and clicks the 'save'
	 * button for the activity under test
	 */
	private void makeTweet(String text) {
		assertNotNull(activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.save));
		textInput.setText(text);
		((Button) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.save)).performClick();
	}
	
}
