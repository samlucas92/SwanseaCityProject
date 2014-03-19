package com.example.swanseacityproject;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBTools extends SQLiteOpenHelper {

	private final Context myContext;
	private static DBTools databaseHelper;
	public DBTools(Context context){
		
		super(context, "application.db", null, 4);
		this.myContext = context;
		
	}
	public static synchronized DBTools getInstance(Context c){
		if (databaseHelper == null){
			synchronized(DBTools.class){
				databaseHelper = new DBTools(c);
			}
		}
		return databaseHelper;
		
	}

	@Override
	public void onCreate(SQLiteDatabase database) {

		String queryLeader = "CREATE TABLE leader ( rankId INTEGER PRIMARY KEY, rankNo INTEGER , firstName TEXT, " +
		"lastName TEXT, email TEXT,  score TEXT)";
		String leaderBoardQuery = "CREATE TABLE leaderboard (rankId INTEGER PRIMARY KEY AUTOINCREMENT, firstName TEXT, " +
		"lastName TEXT, score TEXT)";
		String questionQuery = "CREATE TABLE questions (num INTEGER PRIMARY KEY AUTOINCREMENT, question, ansOne TEXT, ansTwo TEXT," +
				" ansThree TEXT, correct TEXT)";
				
		database.execSQL(questionQuery);
		database.execSQL(leaderBoardQuery);
		database.execSQL(queryLeader);
		
		
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
		
		
		database.execSQL("DROP TABLE IF EXISTS leader");
		database.execSQL("DROP TABLE IF EXISTS leaderboard");
		database.execSQL("DROP TABLE IF EXISTS questions");

		onCreate(database);
		
	}
	
	public void insertContact(HashMap<String, String> queryValues){
		
		SQLiteDatabase database = this.getWritableDatabase();
		
		ContentValues values = new ContentValues();

		
		values.put("firstName", queryValues.get("firstName"));
		values.put("lastName", queryValues.get("lastName"));
		values.put("email", queryValues.get("email"));
		values.put("score", queryValues.get("score"));
		
		database.insert("leader", null, values);

		
		database.close();
		
	}
	
	public int updateLeader(HashMap<String, String> queryValues){
		
		SQLiteDatabase database = this.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		
		values.put("firstName", queryValues.get("firstName"));
		values.put("lastName", queryValues.get("lastName"));
		values.put("email", queryValues.get("email"));
		values.put("score", queryValues.get("score"));

		
		return database.update("leader", values, 
				"rankId" + " = ?", new String[] {queryValues.get("rankId") });
		
	}
	
	public void deleteContact(){
		
		SQLiteDatabase database = this.getWritableDatabase();
		
		String deleteQuery = "DELETE FROM leader";
		
		database.execSQL(deleteQuery);
		
	}
	
	public ArrayList<HashMap<String, String>> getAllquestions(){
		

		ArrayList<HashMap<String, String>> questList = new ArrayList<HashMap<String, String>>();
		String selectQuery = "SELECT question,ansOne,ansTwo,ansThree,correct FROM questions";
		
		
		SQLiteDatabase database = this.getWritableDatabase();
		
		
		
		Cursor cursor = database.rawQuery(selectQuery, null);
		
		if(cursor.moveToFirst()){
			
			do{
				
				HashMap<String, String> questionMap = new HashMap<String, String>();
				
				
				questionMap.put("question", cursor.getString(0));
				questionMap.put("ansOne", cursor.getString(1));
				questionMap.put("ansTwo", cursor.getString(2));
				questionMap.put("ansThree", cursor.getString(3));
				questionMap.put("correct", cursor.getString(4));

				
				questList.add(questionMap);
				
			} while(cursor.moveToNext());
			
		}
		
		return questList;
		
	}
	public ArrayList<HashMap<String, String>> getLeader(){
		
		ArrayList<HashMap<String, String>> leaderList = new ArrayList<HashMap<String, String>>();
		//String selectQuery = "select firstName, lastName, score FROM leader ORDER BY score DESC LIMIT 10 ";
		SQLiteDatabase database = this.getWritableDatabase();
		
		 String leaderQuery = "SELECT rankId, firstName, lastName, score FROM leader ORDER BY score DESC LIMIT 10";
		 try 
		 {
			
			
			Cursor cursor = database.rawQuery(leaderQuery, null);
			
			if(cursor.moveToFirst()){
				
				do{
					
					HashMap<String, String> contactMap = new HashMap<String, String>();
					contactMap.put("rankId", cursor.getString(0));
					contactMap.put("firstName", cursor.getString(1));
					contactMap.put("lastName", cursor.getString(2));
					contactMap.put("score", cursor.getString(3));
					
					leaderList.add(contactMap);
					
				} while(cursor.moveToNext());
				
			}
		 }
		 catch (Exception e) 
		 {
		       Log.e("ERROR", e.toString());
		 }
		database.close();
		return leaderList;
		
		
	}	
	public HashMap<String, String> getUserInfo(String id){
		
		HashMap<String, String> leaderMap = new HashMap<String, String>();
		
		SQLiteDatabase database = this.getReadableDatabase();
		
		String selectQuery = "SELECT * FROM leader WHERE rankId='" + id + "'";
		
		Cursor cursor = database.rawQuery(selectQuery, null);
		
		if(cursor.moveToFirst()){
			
			do{
				
				leaderMap.put("rankId", cursor.getString(0));
				leaderMap.put("firstName", cursor.getString(1));
				leaderMap.put("lastName", cursor.getString(2));
				leaderMap.put("score", cursor.getString(3));
				leaderMap.put("email", cursor.getString(4));


				
			} while(cursor.moveToNext());
			
		}
		
		return leaderMap;
		
	}
	public void questionSetup(){
		SQLiteDatabase database = this.getReadableDatabase();
		ContentValues values = new ContentValues();

		
		values.put("question", R.string.question1_text);
		values.put("ansOne", R.string.q1a1);
		values.put("ansTwo", R.string.q1a2);
		values.put("ansThree", R.string.q1a3);
		values.put("correct", R.string.q1a1);
		
		values.put("question", R.string.question2_text);
		values.put("ansOne", R.string.q2a1);
		values.put("ansTwo", R.string.q2a2);
		values.put("ansThree", R.string.q2a3);
		values.put("correct", R.string.q2a2);
		
		values.put("question", R.string.question3_text);
		values.put("ansOne", R.string.q3a1);
		values.put("ansTwo", R.string.q3a2);
		values.put("ansThree", R.string.q3a3);
		values.put("correct", R.string.q3a2);
		
		values.put("question", R.string.question4_text);
		values.put("ansOne", R.string.q4a1);
		values.put("ansTwo", R.string.q4a2);
		values.put("ansThree", R.string.q4a3);
		values.put("correct", R.string.q4a3);
		
		values.put("question", R.string.question5_text);
		values.put("ansOne", R.string.q5a1);
		values.put("ansTwo", R.string.q5a2);
		values.put("ansThree", R.string.q5a3);
		values.put("correct", R.string.q5a2);
		
		values.put("question", R.string.question6_text);
		values.put("ansOne", R.string.q6a1);
		values.put("ansTwo", R.string.q6a2);
		values.put("ansThree", R.string.q6a3);
		values.put("correct", R.string.q6a3);
		
		values.put("question", R.string.question7_text);
		values.put("ansOne", R.string.q7a1);
		values.put("ansTwo", R.string.q7a2);
		values.put("ansThree", R.string.q7a3);
		values.put("correct", R.string.q7a3);
		
		values.put("question", R.string.question8_text);
		values.put("ansOne", R.string.q8a1);
		values.put("ansTwo", R.string.q8a2);
		values.put("ansThree", R.string.q8a3);
		values.put("correct", R.string.q8a1);
		
		values.put("question", R.string.question9_text);
		values.put("ansOne", R.string.q9a1);
		values.put("ansTwo", R.string.q9a2);
		values.put("ansThree", R.string.q9a3);
		values.put("correct", R.string.q9a3);
		
		values.put("question", R.string.question10_text);
		values.put("ansOne", R.string.q10a1);
		values.put("ansTwo", R.string.q10a2);
		values.put("ansThree", R.string.q10a3);
		values.put("correct", R.string.q10a3);
		
		
		database.insert("questions", null, values);

		
		database.close();
	}
	
}
