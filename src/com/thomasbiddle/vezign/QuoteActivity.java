package com.thomasbiddle.vezign;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class QuoteActivity extends Activity{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quickquote_main);
    }
    public void nextPage(View v) {
    	Intent i = new Intent().setClass(this, Quote1Activity.class);
    	startActivity(i);
    	finish();
    }
}