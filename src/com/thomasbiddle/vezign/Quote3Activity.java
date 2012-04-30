package com.thomasbiddle.vezign;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class Quote3Activity extends Activity{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quickquote_3);      
    }
    public void nextPage(View v) {
    	Intent i = new Intent().setClass(this, Quote4Activity.class);
    	CheckBox cb;
    	int totalAddCost = 0;
    	
    	/* Collect information from the previous activity, and this activity, and place it into the new bundle to be sent */
    	Bundle extras = getIntent().getExtras();
    	i.putExtras(extras);
    	
    	cb = (CheckBox) findViewById(R.id.checkBox1);
	    	if (cb.isChecked()) {
	    		i.putExtra("add1", "Yes");
	    		totalAddCost += 75;
	    	}
	    	else i.putExtra("add1", "No");
	    cb = (CheckBox) findViewById(R.id.checkBox2);
	    	if (cb.isChecked()) {
	    		i.putExtra("add2", "Yes");
	    		totalAddCost += 75;
	    	}
	    	else i.putExtra("add2", "No");
	    cb = (CheckBox) findViewById(R.id.checkBox3);
	    	if (cb.isChecked()) {
	    		i.putExtra("add3", "Yes");
	    		totalAddCost += 350;
	    	}
	    	else i.putExtra("add3", "No");
	    cb = (CheckBox) findViewById(R.id.checkBox4);
	    	if (cb.isChecked()) {
	    		i.putExtra("add4", "Yes");
	    		totalAddCost += 180;
	    	}
	    	else i.putExtra("add4", "No");
	    cb = (CheckBox) findViewById(R.id.checkBox5);
	    	if (cb.isChecked()) {
	    		i.putExtra("add5", "Yes");
	    		totalAddCost += 1200;
	    	}
	    	else i.putExtra("add5", "No");
	    cb = (CheckBox) findViewById(R.id.checkBox6);
	    	if (cb.isChecked()) {
	    		i.putExtra("add6", "Yes");
	    		totalAddCost += 465;
	    	}
	    	else i.putExtra("add6", "No");
		cb = (CheckBox) findViewById(R.id.checkBox7);
	    	if (cb.isChecked()) {
	    		i.putExtra("add7", "Yes");
	    		totalAddCost += 240;
	    	}
	    	else i.putExtra("add7", "No");
	    cb = (CheckBox) findViewById(R.id.checkBox7);
	    	if (cb.isChecked()) {
	    		i.putExtra("add8", "Yes");
	    		totalAddCost += 240;
	    	}
	    	else i.putExtra("add8", "No");

		totalAddCost += extras.getInt("optionsTotal");
	    i.putExtra("optionsTotal", totalAddCost);

    	startActivity(i);
    	finish();
    }
}