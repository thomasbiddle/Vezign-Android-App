package com.thomasbiddle.vezign;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Quote2Activity extends Activity{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quickquote_2);  
    }
    
    public void showForms(View v) {
    	EditText et;
    	et = (EditText) findViewById(R.id.editText1);
    	if (et.getVisibility() == 8) {
	    	et.setVisibility(0);
	    	et = (EditText) findViewById(R.id.editText2);
	    	et.setVisibility(0);
	    	et = (EditText) findViewById(R.id.editText3);
	    	et.setVisibility(0);
    	}
    	else {
    		et.setVisibility(8);
	    	et = (EditText) findViewById(R.id.editText2);
	    	et.setVisibility(8);
	    	et = (EditText) findViewById(R.id.editText3);
	    	et.setVisibility(8);
    	}
    }
    
    public void nextPage(View v) {
    	Intent i = new Intent().setClass(this, Quote3Activity.class);
    	RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup1);
    	RadioButton rb;
    	
    	/* Collect information from the previous activity, and this activity, and place it into the new bundle to be sent */
    	Bundle extras = getIntent().getExtras();
    	i.putExtras(extras);
    	
    	int val = rg.getCheckedRadioButtonId();
    	rb = (RadioButton) findViewById(val);
    	if ( rb.getText().equals("Yes, please!") ) {
    		i.putExtra("rebrandRB", "Yes");
    		i.putExtra("optionsTotal", 750);
    		
        	EditText et;
        	et = (EditText) findViewById(R.id.editText1);
        	i.putExtra("compName", et.getText().toString());
        	et = (EditText) findViewById(R.id.editText2);
        	i.putExtra("compIndus", et.getText().toString());
        	et = (EditText) findViewById(R.id.editText3);
        	i.putExtra("compInfo", et.getText().toString());	
    	}
    	else {
    		i.putExtra("rebrandRB", "No");
        	i.putExtra("compName", "");
        	i.putExtra("compIndus", "");
        	i.putExtra("compInfo", "");
    	}
    	
    	startActivity(i);
    	finish();
    }
}