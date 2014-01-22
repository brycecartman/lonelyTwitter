package ca.ualberta.cs.lonelytwitter;

import java.io.Serializable;
import java.util.Date;

import com.google.gson.Gson;

import android.widget.ArrayAdapter;

public abstract class LonelyTweetModel implements Serializable{
	
	protected String text;
	protected Date timestamp;
	protected boolean important;
	private Gson gson = new Gson();
	
	
	public String getText() {
		return text;
	}
	
	public abstract void setText(String text);
	
	public Date getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public LonelyTweetModel(String text, Date timestamp) {
		super();
		this.text = text;
		this.timestamp = timestamp;
	}
	
	public LonelyTweetModel(String text) {
		super();
		this.text = text;
		this.timestamp = new Date();
	}
	
	public boolean getImportant() {
        return important;
}
	public abstract void setImportant(boolean important) throws Exception;
}
