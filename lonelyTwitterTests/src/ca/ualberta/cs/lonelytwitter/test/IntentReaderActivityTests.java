package ca.ualberta.cs.lonelytwitter.test;

import ca.ualberta.cs.lonelytwitter.IntentReaderActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.widget.TextView;

@SuppressLint("NewApi")
public class IntentReaderActivityTests extends
		ActivityInstrumentationTestCase2<IntentReaderActivity> {

	public IntentReaderActivityTests() {
		super(IntentReaderActivity.class);
	}
	
	public void testSendText() {
		Intent intent = new Intent();
		String text  = "Hello!";
		intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
		setActivityIntent(intent);
		IntentReaderActivity activity = getActivity();
		
		assertNotNull(activity);
		
		assertEquals("IntentReaderActivity should get text from intent",
					text, activity.getText());
	}
	
	public void testDoubleText() {
		Intent intent = new Intent();
		String text  = "Hello!";
		intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
		intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, IntentReaderActivity.DOUBLE);
		setActivityIntent(intent);
		IntentReaderActivity activity = getActivity();
		
		assertNotNull(activity);
		
		assertEquals("IntentReaderActivity should get text from intent",
					text + text, activity.getText());

	}
	
	public void testDisplayText() {
		Intent intent = new Intent();
		String text  = "Hello!";
		intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
		setActivityIntent(intent);
		IntentReaderActivity activity = getActivity();
		
		assertNotNull(activity);
		TextView textView = (TextView)activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);
		assertEquals("IntentReaderActivity should display text", 
				text, textView.getText().toString());
		}
	
	public void testActuallyDisplaying() {
		Intent intent = new Intent();
		String text  = "Hello!";
		intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
		setActivityIntent(intent);
		IntentReaderActivity activity = getActivity();
		
		assertNotNull(activity);
		TextView textView = (TextView)activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);
		
		ViewAsserts.assertOnScreen(activity.getWindow().getDecorView(), textView);
		}

	
	
	public void testReverseText() {
		Intent intent = new Intent();
		String text  = "Hello!";
		String text2  = "!olleH";
		intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
		intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, IntentReaderActivity.REVERSE);
		setActivityIntent(intent);
		IntentReaderActivity activity = getActivity();
		
		assertNotNull(activity);
		
		assertEquals("IntentReaderActivity should get REVERSE text from intent",
					text2, activity.getText());
	}
	
	public void testDefaultText() {
		Intent intent = new Intent();
		setActivityIntent(intent);
		IntentReaderActivity activity = getActivity();
		assertNotNull(activity);
		assertNotSame("IntentReaderActivity should check for a default null text",
				null, activity.getText());
	}
	

}
