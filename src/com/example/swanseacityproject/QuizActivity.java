package com.example.swanseacityproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;



public class QuizActivity extends Activity{
	Button quiz;
	protected void onCreate (Bundle savedInstantState){
		super.onCreate(savedInstantState);
		overridePendingTransition(R.anim.fadein, R.anim.fadeout);
		setContentView(R.layout.activity_quiz);
		buttonClick();
	}
	public void buttonClick(){
        quiz = (Button)findViewById(R.id.startQuiz);
        quiz.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent quizIntent = new Intent(QuizActivity.this, Question1.class);
				QuizActivity.this.startActivity(quizIntent);
				
			}
        });
	}
}
