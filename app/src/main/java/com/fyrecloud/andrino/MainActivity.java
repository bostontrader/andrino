package com.fyrecloud.andrino;

//import java.util.Vector;

//import org.mozilla.javascript.Scriptable;

//import com.fyrecloud.andrino.R;

import android.app.Activity;
//import android.content.Context;
//import android.content.Intent;
//import android.media.MediaPlayer;
import android.os.Bundle;
//import android.view.KeyEvent;
//import android.view.LayoutInflater;
//import android.view.Menu;
//import android.view.MenuInflater;
//import android.view.MenuItem;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.ViewGroup;
//import android.widget.AdapterView;
//import android.widget.BaseAdapter;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ListView;
//import android.widget.TextView;
//import android.widget.Toast;
//import android.widget.AdapterView.OnItemClickListener;
//import android.widget.TextView.OnEditorActionListener;

/**
 * This Activity is the entry point to the application.
 *
 * @author Thomas Radloff  bostontrader@gmail.com
 */
public class MainActivity extends Activity {
    //private ListView lvInteractions;
    //private Vector<Interaction> interactions;
    //InteractionAdapter ia;

    // We need these for Rhino
    //private org.mozilla.javascript.Context cx;
    //private Scriptable scope;
    //private String source;
    //private String lineno;

    // A new java expression instead of an additional line
    //private boolean fNewJava = true;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

		/*ListView lvInteractions = (ListView) findViewById(R.id.theInteractions);
		ia = new InteractionAdapter(this);
		interactions = new Vector<Interaction>();
		ia.DI(interactions);
		lvInteractions.setAdapter(ia);

		cx = org.mozilla.javascript.Context.enter();
		cx.setOptimizationLevel(-1);
		scope = cx.initStandardObjects();

		Button btnEdit = (Button) this.findViewById(R.id.btnEdit);
		btnEdit.setOnClickListener(
			new OnClickListener() {

				@Override
				public void onClick(View arg0) {

					MediaPlayer mp = MediaPlayer.create(Andrino.this, R.raw.tos_computer_3);
					mp.start();

					EditText thePrompt = (EditText) findViewById(R.id.thePrompt);
					String theText = thePrompt.getText().toString();
					thePrompt.setText(""); // blank to reuse

					Intent myIntent = new Intent();
					myIntent.setClassName("com.fyrecloud.andrino", "com.fyrecloud.andrino.Editor");
					myIntent.setAction(Intent.ACTION_MAIN);
					myIntent.putExtra("com.fyrecloud.andrino.theText",theText);
					startActivityForResult(myIntent,0);
				}
			}
		);

		EditText et = (EditText) this.findViewById(R.id.thePrompt);
		et.setText("");
		et.setOnEditorActionListener(
			new OnEditorActionListener() {
				//@Override
				public boolean onEditorAction(TextView arg0, int arg1, KeyEvent arg2) {

					// For whatever reason, each enter triggers this twice.  I only
					// want to use it once.  This is how I pick only one
					if (arg2.getDownTime() == arg2.getEventTime()) {
						// 1. First, figure out what the newly entered text is
						String newLine = arg0.getText().toString();

						feedRhino(newLine);

						// 2. Then erase the EditText so we may use it again
						arg0.setText("");

					}
					return true;	// event consumed
				}
			}
		);

		lvInteractions.setOnItemClickListener(
			new OnItemClickListener() {
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					//MaterialDetail selectedMaterialDetail = (MaterialDetail) mda.getItem(position);
					Interaction interaction = (Interaction) ia.getItem(position);

					//EditDialog editDialog = new EditDialog(P5_Materials.this);
					//myDialog = editDialog;
					//editDialog.DI(getString(R.string.title_EditMaterialDetail), selectedMaterialDetail);
					//editDialog.show();

					Intent myIntent = new Intent();
					myIntent.setClassName("com.fyrecloud.andrino", "com.fyrecloud.andrino.Editor");
					myIntent.setAction(Intent.ACTION_MAIN);
					myIntent.putExtra("com.fyrecloud.andrino.theText",interaction.theText);
					startActivityForResult(myIntent,0);
				}
			}
		);*/

    }

    /**
     * Callback 2 of 7 of the Activity lifecycle
     * Lifecycle loop 2, "visible lifetime" from onStart to onStop
     */
    //@Override
    //protected void onStart() {super.onStart();}

    /**
     * Callback 3 of 7 of the Activity lifecycle
     * Lifecycle loop 3, "foreground lifetime" from onResume to onPause
     * Activity state now = active aka running
     */
    //@Override
    //protected void onResume() {super.onResume();
    //this.invalidateView();
    //}

    /**
     * Callback 4 of 7 of the Activity lifecycle
     * Lifecycle loop 3, "foreground lifetime" from onResume to onPause
     * commit unsaved changes to persistent data,
     * Activity state now = paused
     */
    //@Override
    //protected void onPause() {super.onPause();}

    /**
     * Callback 5 of 7 of the Activity lifecycle
     * Lifecycle loop 2, "visible lifetime" from onStart to onStop
     * Activity state now = stopped
     */
    //@Override
    //protected void onStop() {super.onStop();}

    /**
     * Callback 6 of 7 of the Activity lifecycle
     * Lifecycle loop 1, "entire lifetime" from onCreate to onDestroy
     * Release any resources
     */
    //@Override
    //protected void onDestroy() {super.onDestroy();}

    /**
     * Callback 7 of 7 of the Activity lifecycle
     */
    //@Override
    //protected void onRestart() {super.onRestart();}

    /**
     * Before the system will destroy this activity, it will call this
     * method to save the state.
     */
    //protected void onSaveInstanceState (Bundle outState) {

    //}

    // The menu only goes into ShowOrders
    //@Override
	/*public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
	}

	//@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch(item.getItemId()) {

			case R.id.about:
				startActivity(new Intent(this, About.class));
				return true;


		}

		return false;
	}*/
    // Give a new inputString for rhino, add the string to the UI, call rhino, and then update the UI
    // with rhino's response
    //private void feedRhino(String inputString) {

    //MediaPlayer mp = MediaPlayer.create(this, R.raw.tos_working);
    //mp.start();

    // 1. Enter inputString as an interaction and update the UI
    //Interaction interaction = new Interaction();
    //interaction.theText = inputString;
    //interaction.fRhinoSpeaks = false;
    //interactions.add(interaction);
    //runOnUiThread(
    //new Runnable() {
    //public void run() {
    //ia.notifyDataSetChanged();
    //}
    //}
    //);

    // 2. Now call Rhino
    //String rhinoResult = rhino(inputString);
    //interaction = new Interaction();
    //interaction.theText = rhinoResult;
    //interaction.fRhinoSpeaks = true;
    //interactions.add(interaction);
    //runOnUiThread(
    //new Runnable() {
    //public void run() {
    //ia.notifyDataSetChanged();
    //}
    //}
    //);

    //}

    //public void onActivityResult(int requestCode, int resultCode, Intent data) {
    //switch (requestCode) {
    //case RESULT_ENABLE:
    //if (resultCode == Activity.RESULT_OK) {
    //Log.i("DeviceAdminSample", "Admin enabled!");
    //} else {
    //Log.i("DeviceAdminSample", "Admin enable FAILED!");
    //}
    //return;
    //}
    //super.onActivityResult(requestCode, resultCode, data);
    //if (data == null) return;
    //String returnedText = data.getStringExtra("com.fyrecloud.andrino.theText");
    //feedRhino(returnedText);
    //}

    //private String rhino(String newline) {

    //Object result = null;
    //String retString = "";
    //try {
    //result = cx.evaluateString(scope, newline, "<cmd>", 1, null);
    //retString = result.toString();
    //}
    //catch(Throwable th) {
    //retString = th.getLocalizedMessage();
    //}

    //return retString;

    // 2.
    //s = "obj.run()";
    //result = cx.evaluateString(scope, s, "<cmd>", 1, null);
    //System.out.println(Context.toString(result));

    // 3.
    //s = "r = new java.lang.Runnable(obj);";
    //result = cx.evaluateString(scope, s, "<cmd>", 1, null);
    //System.out.println(Context.toString(result));

    // 4.
    //s = "t = new java.lang.Thread(r);";
    //result = cx.evaluateString(scope, s, "<cmd>", 1, null);
    //System.out.println(Context.toString(result));

    //s = "t.start()";
    //result = cx.evaluateString(scope, s, "<cmd>", 1, null);
    //return org.mozilla.javascript.Context.toString(result);
    //}

    //private class InteractionAdapter extends BaseAdapter {

    /** Must have this when constructing or inflating views */
    //private Context context;

    /** The statuses */
    //private Vector<Interaction> interactions;

    //public InteractionAdapter(Context context) {
    //this.context = context;
    //}
}