package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

public class TweetListController {
	private static TweetListModel tweetListModel;

	public TweetListController() {
		super();
		if(tweetListModel == null){
			tweetListModel = new TweetListModel();
		}
	}
	
	public void addTweet(String text){
		LonelyTweetModel lt = new NormalTweetModel(text);
		ArrayList<LonelyTweetModel> list = tweetListModel.getList();
		list.add(lt);
	}
	
}
