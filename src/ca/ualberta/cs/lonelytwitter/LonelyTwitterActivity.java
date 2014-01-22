package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class LonelyTwitterActivity extends Activity implements Serializable{

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
	
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();		
				saveInFile(text, new Date(System.currentTimeMillis()));
				bodyText.setText("");
				onStart();			
			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		String[] tweets = loadFromFile();
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				R.layout.list_item, tweets);
		adapter.notifyDataSetChanged(); // Notify if the data has changed.
		oldTweetsList.setAdapter(adapter);
	}

	private String[] loadFromFile() {

		ArrayList<String> tweets = new ArrayList<String>();
		
		try {
			FileInputStream fis = openFileInput(FILENAME);	
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			//gson.fromJson(in, (Type) new InputStreamReader(fis));
			String line = in.readLine();
			while (line != null) {
				tweets.add(line);
				line = in.readLine();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tweets.toArray(new String[tweets.size()]);
	}
	
	private void saveInFile(String text, Date date) {
		Gson gson = new Gson();
		gson = deserialize(text);
		String string = serialize(text); // DOESN'T ALLOW FOR SPACES
		
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_APPEND);
			
			fos.write(new String(date.toString() + " | " + string + "\n")
					.getBytes());
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public JsonElement serialize(LonelyTwitterActivity arg0, Type arg1,
			JsonSerializationContext arg2) {
		return new JsonPrimitive(arg0.toString());
	}
	
	private String serialize(String text){
		Gson gson = new Gson();
		String text2 = gson.fromJson(text, String.class);
		return text2;
	}
	
	private Gson deserialize(String text){
		Gson gson = new Gson();
		gson.fromJson(text, String.class);
		return gson;
	}
	
	
	

}