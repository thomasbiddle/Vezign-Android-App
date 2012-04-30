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

public class WhoisSearchActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.whois);	
    }
    
    public void checkWHOIS(View v) {
    	EditText et;
    	et = (EditText) findViewById(R.id.editText1);
    	String[] domainVal = { checkValidString(et.getText().toString()) };
    	new tryWhoisCheck().execute(domainVal);
    	InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
    	mgr.hideSoftInputFromWindow(et.getWindowToken(), 0);
    }
    
    public String checkValidString(String stringToCheck) {
    	String newString = stringToCheck.replaceAll(" ", "");
    	return newString;
    }
    
    public String stripBullets(String stringToCheck) {
    	String newString = stringToCheck.replaceAll("<br />", "\n");
    	return newString;
    }
    
    public String getResult(String domain){
		String line = null;

		try {

			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpPost httpPost = new HttpPost("http://thomasbiddle.com/vezign/domaintools/info.php?result=whois" + "&site=" + domain);

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
		return stripBullets(line);
    }	
    
    /* Run the check on another thread so the UI is not locked up. 
     * < String, Integer, String > Refers to what doInBG returns, what values the progress is in, and what what values onPostExe accepts - respectfully. */
    private class tryWhoisCheck extends AsyncTask< String, Integer, String > {
    	ProgressDialog dialog;
    	protected void onPreExecute() {
        	dialog = ProgressDialog.show(WhoisSearchActivity.this, "", 
                    "Hang tight - we'll get that for you right away!", true);
        	dialog.show();
    	}
        protected String doInBackground(String... whoisCheck) {
        	String result = getResult(whoisCheck[0]);
        	return result;
        }
        protected void onPostExecute(String result) {
        	dialog.dismiss();
        	TextView tv = (TextView) findViewById(R.id.textView2);
        	tv.setText(result);
        }
    }
}
