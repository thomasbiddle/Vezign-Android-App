package com.thomasbiddle.vezign;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class DomainToolsActivity extends Activity{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.domaintools);
	} 
    public void keywordClick(View v) {
    	Intent i = new Intent().setClass(this, TopKeywordsActivity.class);
    	startActivity(i);
    }
    public void whoisClick(View v) {
    	Intent i = new Intent().setClass(this, WhoisSearchActivity.class);
    	startActivity(i);
    }
    public void domainClick(View v) {
    	Intent i = new Intent().setClass(this, DomainAvailabilityActivity.class);
    	startActivity(i);
    }
    public void backlinkClick(View v) {
    	Toast.makeText(getApplicationContext(), "Coming Soon!", Toast.LENGTH_SHORT).show();
    }
}
