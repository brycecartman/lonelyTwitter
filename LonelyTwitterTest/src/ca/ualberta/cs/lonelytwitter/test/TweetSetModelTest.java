package ca.ualberta.cs.lonelytwitter.test;

import java.util.Arrays;

import ca.ualberta.cs.lonelytwitter.ImportantTweetModel;
import ca.ualberta.cs.lonelytwitter.LonelyTweetModel;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.NormalTweetModel;
import ca.ualberta.cs.lonelytwitter.TweetSetModel;
import android.test.ActivityInstrumentationTestCase2;

public class TweetSetModelTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

	public TweetSetModelTest() {
		super(LonelyTwitterActivity.class);
	}
	
	public void testCount() {
		TweetSetModel tweets = new TweetSetModel();
		
		assertEquals("tweet set should start empty", 0, tweets.countTweets());
		
		tweets.addTweet(new NormalTweetModel("test"));
		
		assertEquals("after adding tweet count should be 1", 1, tweets.countTweets());
	}
	
	public void testGetTweets(){
		
		TweetSetModel tweets = new TweetSetModel();
		
		LonelyTweetModel[] lonelyTweetArray = tweets.getTweets();
		
		LonelyTweetModel[] localTweetArray = new LonelyTweetModel[10];
		
		// Adds a Normal Tweet
		
		NormalTweetModel tweet = new NormalTweetModel("test");
		
		localTweetArray[0] = tweet;
		
		tweets.addTweet(tweet);
		
		// Adds a Important Tweet
		
		ImportantTweetModel tweet2 = new ImportantTweetModel("test2");
		
		localTweetArray[1] = tweet2;
		
		tweets.addTweet(tweet2);
		
		lonelyTweetArray = tweets.getTweets();
		
		assertEquals("Lonely Array equals Local Array", true, Arrays.equals(lonelyTweetArray, localTweetArray))	;
		
	}
	
	public void testAddingSameTweets(){

		TweetSetModel tweets = new TweetSetModel();
		
		// Adds a Normal Tweet
		
		NormalTweetModel tweet = new NormalTweetModel("test");
			
		tweets.addTweet(tweet);
		
	try {
		tweets.addTweet(tweet);
		fail("Added duplicate tweet failed");
	} catch (IllegalArgumentException e){
		
	}
		
	}
}
