package com.fyrecloud.andrino;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * This Activity is the about box.
 *
 * @author Thomas Radloff  bostontrader@gmail.com
 */
public class About extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);

		// 1. Hook the URL button
		((Button) findViewById(R.id.btnURL)).setOnClickListener(
			new View.OnClickListener() {
				public void onClick(View view){
					String url = About.this.getString(R.string.url);
					Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse(url));
					try {
						startActivity(viewIntent);  
					} catch(Exception ignore) {
					}
				}
			}
		);

		// 2. Hook the send email button
		((Button)findViewById(R.id.btnSendEmail)).setOnClickListener(
			new View.OnClickListener() {
				public void onClick(View view){
					Intent i = new Intent(Intent.ACTION_SEND);
					i.setType(About.this.getString(R.string.text_plain));
					i.putExtra(Intent.EXTRA_EMAIL, new String[]{About.this.getString(R.string.myemail)});
					i.putExtra(Intent.EXTRA_SUBJECT, About.this.getString(R.string.regarding_andrino));
					i.putExtra(Intent.EXTRA_TEXT   , About.this.getString(R.string.body_of_email));
					try {
						startActivity(Intent.createChooser(i, About.this.getString(R.string.send_email)));
					} catch (android.content.ActivityNotFoundException ex) {
						Toast.makeText(About.this, About.this.getString(R.string.there_are_no_email_clients_installed), Toast.LENGTH_SHORT).show();
					}
				}
			}
		);

	}

}