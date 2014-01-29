package ca.ualberta.cs.lonelytwitter.test;

import ca.ualberta.cs.lonelytwitter.ImportantTweetModel;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.NormalTweetModel;
import android.test.ActivityInstrumentationTestCase2;

public class ImportantTweetModelTest extends
		ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

	public ImportantTweetModelTest() {
		super(LonelyTwitterActivity.class);
	}
	
	public void testEquals() {
		
		ImportantTweetModel importantTest = new ImportantTweetModel("Test String");
		NormalTweetModel normalTest = new NormalTweetModel("Test String");
		
		assertEquals("Important should not equal normal", false, importantTest.equals(normalTest));
		
		assertEquals("Normal should not equal Important", false, normalTest.equals(importantTest));
		
		assertEquals("Important should equal Important", true, importantTest.equals(importantTest));
		
		assertEquals("Normal should equal normal", true, normalTest.equals(normalTest));
		
	}

}
