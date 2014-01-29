package ca.ualberta.cs.lonelytwitter;

public class TweetSetModel {
		
	int count = 0;
	LonelyTweetModel[] lonelyTweetArray;

	public int countTweets() {
		
		return count;
	}

	public void addTweet(LonelyTweetModel lonelyTweetModel) throws IllegalArgumentException{
		count++;	
		
		if(count > 1){
			if(lonelyTweetArray[count-2].equals(lonelyTweetModel)){
				throw new IllegalArgumentException();
			}
		}
		lonelyTweetArray[count-1] = lonelyTweetModel;	
	}
	
	public LonelyTweetModel[] getTweets() {	
		return lonelyTweetArray;	
	}
	
	public TweetSetModel(){
		lonelyTweetArray = new LonelyTweetModel[10];
	}

}
