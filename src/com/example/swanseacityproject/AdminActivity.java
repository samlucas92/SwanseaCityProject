package com.example.swanseacityproject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

public class AdminActivity {
	public class MainActivity extends Activity {
		Button quiz, leader, help, settings;
		DBTools db = new DBTools(this);

	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
			overridePendingTransition(R.anim.fadein, R.anim.fadeout);
	        setContentView(R.layout.activity_admin);
	        initialise();

	    }
	    public void initialise(){
	    	
	    }
	}
}
