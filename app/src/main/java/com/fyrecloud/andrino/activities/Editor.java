package com.fyrecloud.andrino.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.fyrecloud.andrino.R;

/**
 * This Activity is the large text editor to enable convenient editing of
 * larger expressions.
 *
 * @author Thomas Radloff  bostontrader@gmail.com
 */
public class Editor extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.editor);

		EditText theText = (EditText) findViewById(R.id.theText);
		Intent incomingIntent = getIntent();
		String incomingText = incomingIntent.getStringExtra("com.fyrecloud.andrino.theText");
		theText.setText(incomingText);

		Button btnSubmit = (Button) this.findViewById(R.id.btnSubmit);
		btnSubmit.setOnClickListener(
			new OnClickListener() {
				public void onClick(View arg0) {
					EditText theText = (EditText) findViewById(R.id.theText);
					Bundle b = new Bundle();
					b.putString("com.fyrecloud.andrino.theText", theText.getText().toString());
					Intent myIntent = new Intent();
					myIntent.putExtras(b);
					setResult(RESULT_OK, myIntent);
					finish();
				}
			}
		);
	}

}