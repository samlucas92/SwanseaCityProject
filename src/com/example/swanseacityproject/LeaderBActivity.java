package com.example.swanseacityproject;


import java.util.ArrayList;

import java.util.HashMap;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.ListAdapter;

import android.widget.SimpleAdapter;
import android.widget.TextView;

import android.app.ListActivity;
import android.content.Intent;




/**
 * Created by Sam Lucas on 24/12/13.
 */

	
public class LeaderBActivity extends ListActivity {
	DBTools db = new DBTools(this);	
	Intent intent = new Intent();
	TextView firstLabel,lastLabel,scoreLabel;
	Button delete;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_l);
       
        createLeader(); 
        firstLabel = (TextView)findViewById(R.id.firstNameLabel);
        lastLabel = (TextView)findViewById(R.id.lastNameLabel);
        scoreLabel = (TextView)findViewById(R.id.scoreLabel);
        firstLabel.setVisibility(View.GONE);
        lastLabel.setVisibility(View.GONE);
        scoreLabel.setVisibility(View.GONE);
		delete = (Button)findViewById(R.id.del);
		//delete.setVisibility(View.GONE);
		delete.setOnClickListener(new View.OnClickListener() {
        	
			@Override
			
			public void onClick(View v) {
				db.deleteContact();
			}
				
        });
     
    }
    public void createLeader(){
    DBTools.getInstance(this.getApplicationContext());
    ArrayList<HashMap<String, String>> leaderList =  db.getLeader();
   

	if(leaderList.size()!=0) {
				ListAdapter adapter = new SimpleAdapter( LeaderBActivity.this,leaderList, R.layout.contact_entry, new String[] { 
						"rankId","firstName", "lastName", "score"}, new int[] {R.id.rankId, R.id.firstName, R.id.lastName,R.id.score});				
				setListAdapter(adapter);
				
			}
		}

}
