package com.thomasbiddle.vezign;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class VezignMain extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_layout);	
    }
    
    public void aboutClick(View v) {
    	Intent i = new Intent().setClass(this, AboutVezignActivity.class);
    	startActivity(i);
    }
    public void gRankClick(View v) {
    	Intent i = new Intent().setClass(this, GoogleRankActivity.class);
    	startActivity(i);
    }
    public void domainToolsClick(View v) {
    	Intent i = new Intent().setClass(this, DomainToolsActivity.class);
    	startActivity(i);
    }
    public void qQuoteClick(View v) {
    	Intent i = new Intent().setClass(this, QuoteActivity.class);
    	startActivity(i);
    }
}