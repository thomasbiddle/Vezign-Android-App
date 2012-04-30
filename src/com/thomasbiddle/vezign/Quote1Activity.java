package com.thomasbiddle.vezign;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Quote1Activity extends Activity{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quickquote_1);
        
        /* Setup our Spinner to contain our Pages list */
        Spinner spinnerPages = (Spinner) findViewById(R.id.pagesSpinner);
        ArrayAdapter<CharSequence> adapterPages = ArrayAdapter.createFromResource(
                this, R.array.pages_array, android.R.layout.simple_spinner_item);
        adapterPages.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPages.setAdapter(adapterPages);
        
        /* Setup our Spinner to contain our Platform list */
        Spinner spinnerPlatform = (Spinner) findViewById(R.id.platformSpinner);
        ArrayAdapter<CharSequence> adapterPlatform = ArrayAdapter.createFromResource(
                this, R.array.platform_array, android.R.layout.simple_spinner_item);
        adapterPlatform.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPlatform.setAdapter(adapterPlatform);
        
    }
    public void nextPage(View v) {
    	Intent i = new Intent().setClass(this, Quote2Activity.class); 
    	Spinner spinnerPages = (Spinner) findViewById(R.id.pagesSpinner);
    	Spinner spinnerPlatform = (Spinner) findViewById(R.id.platformSpinner);
    	
    	/* Collect our forms information to send to the next activity. */
    	String pgvalue = spinnerPages.getSelectedItem().toString();
    	String platvalue = spinnerPlatform.getSelectedItem().toString();
    	i.putExtra("pageNumber", pgvalue);
    	i.putExtra("platform", platvalue);
    	
    	startActivity(i);

    	finish();
    }
}