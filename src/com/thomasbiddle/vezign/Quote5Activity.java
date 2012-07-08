package com.thomasbiddle.vezign;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Quote5Activity extends Activity{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quickquote_5);     
    }
    public void nextPage(View v) {
    	Intent i = new Intent().setClass(this, Quote6Activity.class);
    	RadioGroup rg;
    	RadioButton rb;
    	int totalUpgrades = 0;
    	
    	/* Collect information from the previous activity, and this activity, and place it into the new bundle to be sent */
    	Bundle extras = getIntent().getExtras();
    	i.putExtras(extras);
    	
    	rg = (RadioGroup) findViewById(R.id.radioGroup3);
    	int val = rg.getCheckedRadioButtonId();
    	rb = (RadioButton) findViewById(val);
    	if ( rb.getText().equals("Yes") ) {
    		i.putExtra("upgrade3", "Yes");
    		totalUpgrades += 347;
    	}
    	else i.putExtra("upgrade3", "No");
    	
    	totalUpgrades += extras.getInt("totalUpgrades");
    	i.putExtra("totalUpgrades", totalUpgrades);
    	startActivity(i);
    	finish();
    }
}