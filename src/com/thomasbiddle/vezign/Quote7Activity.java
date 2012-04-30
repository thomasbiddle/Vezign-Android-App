package com.thomasbiddle.vezign;

import java.io.IOException;
import java.net.URLEncoder;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Quote7Activity extends Activity{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quickquote_7);
    }
    public void sendForm(View v) {
    	new TrySendForm().execute();
    }
    
    private class TrySendForm extends AsyncTask< Void, Integer, Boolean > {
    	ProgressDialog dialog;
    	protected void onPreExecute() {
        	dialog = ProgressDialog.show(Quote7Activity.this, "", 
                    "Just a second!", true);
        	dialog.show();
    	}
        protected Boolean doInBackground(Void...v) { // ToDo: Why in the hell does this need to be written this way?

    	    Bundle extras = getIntent().getExtras();
    	    EditText et1 = (EditText) findViewById(R.id.editText1);
    	    EditText et2 = (EditText) findViewById(R.id.editText2);
    	    EditText et3 = (EditText) findViewById(R.id.editText3);
       
    	    try {
    	    	// Execute HTTP Post Request    	    	
    	    	DefaultHttpClient httpclient = new DefaultHttpClient();
    	    	String info = "name=" + URLEncoder.encode(et1.getText().toString()) + 
    	    			"&number=" + URLEncoder.encode(et2.getText().toString()) + 
						"&email=" + URLEncoder.encode(et3.getText().toString()) + 
						"&pages=" + URLEncoder.encode(extras.getString("pageNumber")) +
						"&platform=" + URLEncoder.encode(extras.getString("platform")) +
						"&rebrand=" + URLEncoder.encode(extras.getString("rebrandRB")) +
						"&cname=" + URLEncoder.encode(extras.getString("compName")) +
						"&cindus=" + URLEncoder.encode(extras.getString("compIndus")) +
						"&cinfo=" + URLEncoder.encode(extras.getString("compInfo")) +
						"&emailopt=" + URLEncoder.encode(extras.getString("add1")) +
						"&smedia=" + URLEncoder.encode(extras.getString("add2")) +
						"&fbook=" + URLEncoder.encode(extras.getString("add3")) +
						"&twitter=" + URLEncoder.encode(extras.getString("add4")) +
						"&ecommerce=" + URLEncoder.encode(extras.getString("add5")) +
						"&seobasic=" + URLEncoder.encode(extras.getString("add6")) +
						"&mobile=" + URLEncoder.encode(extras.getString("add7")) +
						"&tablet=" + URLEncoder.encode(extras.getString("add8")) +
						"&seomanage=" + URLEncoder.encode(extras.getString("upgrade1")) +
						"&blogmanage=" + URLEncoder.encode(extras.getString("upgrade2")) +
						"&socialmanage=" + URLEncoder.encode(extras.getString("upgrade3")) +
						"&tcost=" + extras.getInt("totalCost");
        	    HttpPost httppost = new HttpPost("http://thomasbiddle.com/vezign/vezignMail.php?" + info);
    	    	
	            httpclient.execute(httppost);
	            return true;
            
	        } catch (ClientProtocolException e1) {
	        	return false;
	        } catch (IOException e) {
	        	return false;
	        }
        }
        protected void onPostExecute(Boolean result) {
        	if (result) {
	        	dialog.dismiss();
	        	Toast.makeText(Quote7Activity.this, "Thanks, we'll be in touch!", Toast.LENGTH_SHORT).show();
	        	Intent i = new Intent().setClass(Quote7Activity.this, VezignMain.class);
	        	startActivity(i);
	        	finish();
        	}
        	else {
        		Toast.makeText(Quote7Activity.this, "Looks like there was an error, do you have an internet connection?", Toast.LENGTH_SHORT).show();
        	}
        }
    }
    
}