package com.thomasbiddle.vezign;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Quote6Activity extends Activity{
	
	private int totalCost = 0;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quickquote_6);
        TextView tv;
        
        
        Bundle extras = getIntent().getExtras();
        tv = (TextView) findViewById(R.id.textView2);
        tv.append(extras.getString("pageNumber"));
        tv = (TextView) findViewById(R.id.textView3);
        int base = Integer.parseInt(extras.getString("pageNumber")) * 70;
        totalCost += base;
        tv.append(Integer.toString(base));
        tv = (TextView) findViewById(R.id.textView4);
        String plat = extras.getString("platform");
        if (plat.equals("Wordpress (Recommended)")) {
        	tv.append("900");
        	totalCost += 900;
        }
        else {
        	tv.append("2200");
        	totalCost += 2200;
        }
        tv = (TextView) findViewById(R.id.textView5);
        tv.append(Integer.toString(extras.getInt("optionsTotal")));
        totalCost += extras.getInt("optionsTotal", 0);
        tv = (TextView) findViewById(R.id.textView6);
        tv.append(Integer.toString(extras.getInt("totalUpgrades")));
        totalCost += extras.getInt("totalUpgrades", 0);
        tv = (TextView) findViewById(R.id.textView7);
        tv.append(Integer.toString(totalCost));      
    }
    
    public void signUp(View v) {
    	Intent i = new Intent().setClass(this,Quote7Activity.class);
    	Bundle extras = getIntent().getExtras();
    	i.putExtras(extras);
    	i.putExtra("totalCost",totalCost);
    	startActivity(i);
    	finish();
    }
    public void finished(View v) {
    	Intent i = new Intent().setClass(this,VezignMain.class);
    	/* Collect information from the previous activity, and this activity, and place it into the new bundle to be sent */
    	Bundle extras = getIntent().getExtras();
    	i.putExtras(extras);
    	
    	startActivity(i);
    	finish();
    }
}