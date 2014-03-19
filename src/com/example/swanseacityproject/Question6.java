package com.example.swanseacityproject;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Question6 extends Activity {
	TextView scored, answer;
	Button ansOne, ansTwo, ansThree;
	String score;
	
	protected void onCreate (Bundle savedInstantState){
		super.onCreate(savedInstantState);
		overridePendingTransition(R.anim.fadein, R.anim.fadeout);
		setContentView(R.layout.question6_activity);
		buttonClick();
	}
	public void buttonClick(){
		scored = (TextView)findViewById(R.id.scoreQ6);
		answer = (TextView)findViewById(R.id.answer6);
		
		final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
		
        ansOne = (Button)findViewById(R.id.button_q6a1);
        ansOne.setOnClickListener(new View.OnClickListener() {
        	String questionAnswer = answer.getText().toString();
			@Override
			
			public void onClick(View v) {
				SharedPreferences.Editor editor = prefs.edit();
				if (ansOne.getText() == questionAnswer){
					Intent Intent = new Intent(Question6.this, Question7.class);
					Question6.this.startActivity(Intent);
					ansOne.setBackgroundColor(Color.GREEN);
					editor.putInt("answer_value6", 1);					

				}else{
					Intent Intent = new Intent(Question6.this, Question7.class);
					Question6.this.startActivity(Intent);
					ansOne.setBackgroundColor(Color.RED);
					editor.putInt("answer_value6", 0);					

				}
				editor.commit();

			}
        });
        ansTwo = (Button)findViewById(R.id.button_q6a2);
        ansTwo.setOnClickListener(new View.OnClickListener() {
        	String questionAnswer = answer.getText().toString();
			@Override
			public void onClick(View v) {
				SharedPreferences.Editor editor = prefs.edit();
				if (ansTwo.getText() == questionAnswer){
					Intent Intent = new Intent(Question6.this, Question7.class);
					Question6.this.startActivity(Intent);
					ansTwo.setBackgroundColor(Color.GREEN);
					editor.putInt("answer_value6", 1);					

				}else{
					Intent Intent = new Intent(Question6.this, Question7.class);
					Question6.this.startActivity(Intent);
					ansTwo.setBackgroundColor(Color.RED);
					editor.putInt("answer_value6", 0);					

				}
				editor.commit();

			}
        });
        ansThree = (Button)findViewById(R.id.button_q6a3);
        ansThree.setOnClickListener(new View.OnClickListener() {
        	String questionAnswer = answer.getText().toString();
			@Override
			public void onClick(View v) {
				SharedPreferences.Editor editor = prefs.edit();
				if (ansThree.getText() == questionAnswer){
					Intent Intent = new Intent(Question6.this, Question7.class);
					Question6.this.startActivity(Intent);
					ansThree.setBackgroundColor(Color.GREEN);
					editor.putInt("answer_value6", 1);					


				}else{
					Intent Intent = new Intent(Question6.this, Question7.class);
					Question6.this.startActivity(Intent);
					ansThree.setBackgroundColor(Color.RED);
					editor.putInt("answer_value6", 0);					

				}
				editor.commit();
				
			}
        });

	}
}