package com.example.swanseacityproject;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	Button quiz, leader, help, settings;
	DBTools db = new DBTools(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_main);
        buttonClicks();


    }
    public void buttonClicks(){
        quiz = (Button)findViewById(R.id.startQuizButton);
        quiz.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent quizIntent = new Intent(MainActivity.this, QuizActivity.class);
				MainActivity.this.startActivity(quizIntent);				
			}
		});
        
        leader = (Button)findViewById(R.id.leaderboardButton);
        leader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent leaderIntent = new Intent (MainActivity.this, LeaderBActivity.class);
                MainActivity.this.startActivity(leaderIntent);
            }
        });
        
        help = (Button)findViewById(R.id.helpButton);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent helpIntent = new Intent(MainActivity.this, HelpActivity.class);
                MainActivity.this.startActivity(helpIntent);
            }
        });
        
        settings = (Button)findViewById(R.id.sButton);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent settingsIntent = new Intent(MainActivity.this, SettingsActivity.class);
                MainActivity.this.startActivity(settingsIntent);

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
