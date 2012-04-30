package com.thomasbiddle.vezign;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class GoogleRankActivity extends Activity{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.googlerank);	
    }
    
    public void checkPage(View v) {
    	EditText et;
    	et = (EditText) findViewById(R.id.editText1);
    	String domain = checkValidString(et.getText().toString());
    	et = (EditText) findViewById(R.id.editText2);
    	String keywords = checkValidString(et.getText().toString());
    	String[] searchTerms = { domain, keywords };
    	InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
    	imm.hideSoftInputFromWindow(et.getWindowToken(), 0);
    	new TryRankCheck().execute(searchTerms);
    }
    
    public String checkValidString(String stringToCheck) {
    	String newString = stringToCheck.replaceAll(" ", "%20");
    	return newString;
    }

    public static String getXML(String domain, String keywords){
		String line = null;

		try {

			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpPost httpPost = new HttpPost("http://thomasbiddle.com/vezign/update_rankings.php?q=" + keywords + "&w=" + domain);

			HttpResponse httpResponse = httpClient.execute(httpPost);
			HttpEntity httpEntity = httpResponse.getEntity();
			line = EntityUtils.toString(httpEntity);


		} catch (UnsupportedEncodingException e) {
			line = "<results status=\"error\"><msg>Can't connect to server</msg></results>";
		} catch (MalformedURLException e) {
			line = "<results status=\"error\"><msg>Can't connect to server</msg></results>";
		} catch (IOException e) {
			line = "<results status=\"error\"><msg>Can't connect to server</msg></results>";
		}
		return line;
    }	
    
    /* Run the check on another thread so the UI is not locked up. 
     * < String, Integer, String > Refers to what doInBG returns, what values the progress is in, and what what values onPostExe accepts - respectfully. */
    private class TryRankCheck extends AsyncTask< String, Integer, String > {
    	ProgressDialog dialog;
    	protected void onPreExecute() {
        	dialog = ProgressDialog.show(GoogleRankActivity.this, "", 
                    "Hang tight - we'll get that for you right away!", true);
        	dialog.show();
    	}
        protected String doInBackground(String... rankCheck) {
        	String result = getXML(rankCheck[0], rankCheck[1]);
        	return result;
        }
        protected void onPostExecute(String result) {
        	dialog.dismiss();
        	TextView googleRank = (TextView) findViewById(R.id.textView2);
        	if ( Integer.parseInt(result) > 0) 
        		 googleRank.setText(result);
        	else googleRank.setText(">100");
        }
    }
}


