package ca.ualberta.cs.lonelytwitter;

public class TweetSetModel {
		
	int count = 0;
	LonelyTweetModel[] lonelyTweetArray;

	public int countTweets() {
		
		return count;
	}

	public void addTweet(LonelyTweetModel lonelyTweetModel) {
		count++;	
	}
	
	public LonelyTweetModel[] getTweets() {	
		return lonelyTweetArray;	
	}
	
	public TweetSetModel(){
		lonelyTweetArray = new LonelyTweetModel[10];
	}

}
