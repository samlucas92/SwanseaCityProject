package com.example.swanseacityproject;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class QuizResult extends Activity {
	Button startGame;
	TextView scored,correct;
	EditText first,last,email;
	Intent intent;
	int score;
	DBTools db = new DBTools(this);
	//String APP_ID = getString(R.string.APP_ID);

	protected void onCreate (Bundle savedInstantState){
		super.onCreate(savedInstantState);
		overridePendingTransition(R.anim.fadein, R.anim.fadeout);
		setContentView(R.layout.quizres_activity);
		initialise();
		startGame = (Button)findViewById(R.id.button_crossbar);
		startGame.setOnClickListener(new View.OnClickListener() {
        	
			@Override
			
			public void onClick(View v) {
				Intent gameIntent = new Intent(QuizResult.this, MainActivity.class);
				addNewContact();
				QuizResult.this.startActivity(gameIntent);
			}
				
        });


	}
	public void initialise(){
		
		scored = (TextView)findViewById(R.id.pointScored);
		correct = (TextView)findViewById(R.id.correctScore);
		first = (EditText)findViewById(R.id.first_name);
		last = (EditText)findViewById(R.id.last_name);
		email = (EditText)findViewById(R.id.email);
		final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
		int q1Answer = prefs.getInt("answer_value", 0);
		int q2Answer = prefs.getInt("answer_value2", 0);
		int q3Answer = prefs.getInt("answer_value3", 0);
		int q4Answer = prefs.getInt("answer_value4", 0);
		int q5Answer = prefs.getInt("answer_value5", 0);
		int q6Answer = prefs.getInt("answer_value6", 0);
		int q7Answer = prefs.getInt("answer_value7", 0);
		int q8Answer = prefs.getInt("answer_value8", 0);
		int q9Answer = prefs.getInt("answer_value9", 0);
		int q10Answer = prefs.getInt("answer_value10", 0);

		score = q1Answer + q2Answer + q3Answer + q4Answer + q5Answer + q6Answer + q7Answer + q8Answer + q9Answer + q10Answer;
		correct.setText(Integer.toString(score) + "/10");
		scored.setText(Integer.toString(score*100));	
	}
	public void addNewContact() {
		
		// Will hold the HashMap of values 
		
		HashMap<String, String> queryValuesMap =  new  HashMap<String, String>();

		// Get the values from the EditText boxes
		
		queryValuesMap.put("firstName", first.getText().toString());
		queryValuesMap.put("lastName", last.getText().toString());
		queryValuesMap.put("email", email.getText().toString());
		queryValuesMap.put("score", scored.getText().toString());

		// Call for the HashMap to be added to the database
		
		db.insertContact(queryValuesMap);
	}


}
