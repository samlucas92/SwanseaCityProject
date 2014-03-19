package com.example.swanseacityproject;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Sam Lucas on 24/12/13.
 */
public class SettingsActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_settings);

    }
}
