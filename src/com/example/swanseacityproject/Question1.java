package com.example.swanseacityproject;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.SharedPreferences;

public class Question1 extends Activity {
	Button ansOne,ansTwo,ansThree;
	TextView scored,answer;
	Intent var;
	
	
	protected void onCreate (Bundle savedInstantState){
		super.onCreate(savedInstantState);
		
		overridePendingTransition(R.anim.fadein, R.anim.fadeout);
		setContentView(R.layout.question1_activity);
		ansOne = (Button)findViewById(R.id.button_q1a1); 
		ansTwo = (Button)findViewById(R.id.button_q1a2);
		ansThree = (Button)findViewById(R.id.button_q1a3);
		setQuestions();
		buttonClick();

	}
	public void setQuestions(){
		DBTools db = new DBTools(this);
		ArrayList<HashMap<String, String>> questionList =  db.getAllquestions();
		if(questionList.isEmpty()){
			db.questionSetup();
			questionList = db.getAllquestions();
		}
		try{
			Random r = new Random();
			int index = r.nextInt(questionList.size());
			
		
			if(questionList.size() != 0){
				String val = questionList.get(index).toString();
				ansOne.setText(val);
			}else{
				//ansOne.setText(Integer.toString(index));
			}
		}catch(Exception e){
			Log.e("ERROR", e.toString());
		}
	}
	public void buttonClick(){

		final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
		scored = (TextView)findViewById(R.id.scoreQ1);		
		
		answer = (TextView)findViewById(R.id.answer);
        ansOne.setOnClickListener(new View.OnClickListener() {
        String ansOneText = ansOne.getText().toString();
        String questionAnswer = answer.getText().toString();
			@Override
			public void onClick(View v) {
				SharedPreferences.Editor editor = prefs.edit();
				if (ansOneText == questionAnswer){
					Intent Intent = new Intent(Question1.this, Question2.class);
					Question1.this.startActivity(Intent);
					ansOne.setBackgroundColor(Color.GREEN);
					editor.putInt("answer_value", 1);

				}else{
					Intent Intent = new Intent(Question1.this, Question2.class);
					Question1.this.startActivity(Intent);
					ansOne.setBackgroundColor(Color.RED);
					editor.putInt("answer_value", 0);
				}
				editor.commit();
			

			}
        });
        
        
        
        ansTwo.setOnClickListener(new View.OnClickListener() {
        String ansTwoText = ansTwo.getText().toString();
        String questionAnswer = answer.getText().toString();
			@Override
			public void onClick(View v) {
				SharedPreferences.Editor editor = prefs.edit();
				if (ansTwoText == questionAnswer){
					Intent Intent = new Intent(Question1.this, Question2.class);
					Question1.this.startActivity(Intent);
					ansTwo.setBackgroundColor(Color.GREEN);
					editor.putInt("answer_value", 1);
				}else{
					Intent Intent = new Intent(Question1.this, Question2.class);
					Question1.this.startActivity(Intent);
					ansTwo.setBackgroundColor(Color.RED);
					editor.putInt("answer_value", 0);					
				}
				editor.commit();
			}
        });
        
        ansThree.setOnClickListener(new View.OnClickListener() {
        String ansThreeText = ansThree.getText().toString();
        String questionAnswer = answer.getText().toString();
			@Override
			public void onClick(View v) {
				SharedPreferences.Editor editor = prefs.edit();
				if (ansThreeText == questionAnswer){
					Intent Intent = new Intent(Question1.this, Question2.class);
					Question1.this.startActivity(Intent);
					ansThree.setBackgroundColor(Color.GREEN);
					editor.putInt("answer_value", 1);

				}else{
					Intent Intent = new Intent(Question1.this, Question2.class);
					Question1.this.startActivity(Intent);
					ansThree.setBackgroundColor(Color.RED);
					editor.putInt("answer_value", 0);
				}
				editor.commit();

			}
        });
	}
}
