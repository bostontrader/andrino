package com.fyrecloud.andrino;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.mozilla.javascript.Scriptable;

import java.util.Vector;

/**
 * This Activity is the entry point to the application.
 *
 * @author Thomas Radloff  bostontrader@gmail.com
 */
public class MainActivity extends AppCompatActivity {

    private Vector<RhinoInteraction> rhinoInteractions;
    private RhinoInteractionAdapter ria;

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

        final EditText thePrompt = (EditText) findViewById(R.id.thePrompt);
        ListView lvRhinoInteractions;

        // 1. Hook the submit button.
        Button btnSubmit = (Button) this.findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(
                new OnClickListener() {

                    @Override
                    public void onClick(View arg0) {
                        // When clicked, submit the javascript to rhino.
						feedRhino(thePrompt.getText().toString());
						thePrompt.setText("");
                    }
                }
        );

        // 2. Hook the full screen editor button.
		Button btnFullScreenEditor = (Button) this.findViewById(R.id.btnFullScreenEditor);
        btnFullScreenEditor.setOnClickListener(
            new OnClickListener() {

                @Override
                public void onClick(View arg0) {

                    // MediaPlayer mp = MediaPlayer.create(Andrino.this, R.raw.tos_computer_3);
                    //mp.start();

                    String theText = thePrompt.getText().toString();
                    //thePrompt.setText(""); // blank to reuse

                    Intent myIntent = new Intent();
                    myIntent.setClassName("com.fyrecloud.andrino", "com.fyrecloud.andrino.Editor");
                    //myIntent.setAction(Intent.ACTION_MAIN);
                    myIntent.putExtra("com.fyrecloud.andrino.theText",theText);
                    startActivityForResult(myIntent,0);
                }
            }
        );

 		lvRhinoInteractions = (ListView) findViewById(R.id.rhinoInteractions);
        rhinoInteractions = new Vector<>();
		ria = new RhinoInteractionAdapter(this, rhinoInteractions);
		lvRhinoInteractions.setAdapter(ria);

		/*

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

    //@Override
    //protected void onStart() {super.onStart();}

    //@Override
    //protected void onResume() {super.onResume();
    //this.invalidateView();
    //}

    //@Override
    //protected void onPause() {super.onPause();}

    //@Override
    //protected void onStop() {super.onStop();}

    //@Override
    //protected void onDestroy() {super.onDestroy();}

    //@Override
    //protected void onRestart() {super.onRestart();}

    //protected void onSaveInstanceState (Bundle outState) {
    //}

    //@Override
	//public boolean onCreateOptionsMenu(Menu menu) {
		//MenuInflater inflater = getMenuInflater();
		//inflater.inflate(R.menu.menu, menu);
		//return true;
	//}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch(item.getItemId()) {

			case R.id.action_about:
				startActivity(new Intent(this, About.class));
				return true;

		}

		return false;
	}

    // Give a new inputString for rhino, add the string to the UI, call rhino, and then update the UI
    // with rhino's response
    private void feedRhino(String inputString) {

    	//MediaPlayer mp = MediaPlayer.create(this, R.raw.tos_working);
    	//mp.start();

    	// 1. Enter inputString as an interaction and update the UI
    	RhinoInteraction rhinoInteraction = new RhinoInteraction();
    	rhinoInteraction.theText = inputString;
    	rhinoInteraction.fRhinoSpeaks = false;
    	rhinoInteractions.add(rhinoInteraction);
    	runOnUiThread(
    	    new Runnable() {
    	        public void run() {
    	            ria.notifyDataSetChanged();
    	        }
    	    }
    	);

	    // 2. Now call Rhino
    	String rhinoResult = rhino(inputString);
    	rhinoInteraction = new RhinoInteraction();
        rhinoInteraction.theText = rhinoResult;
        rhinoInteraction.fRhinoSpeaks = true;
        rhinoInteractions.add(rhinoInteraction);
    	runOnUiThread(
    	    new Runnable() {
    	        public void run() {
    	            ria.notifyDataSetChanged();
    	        }
    	    }
    	);

    }

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

    private String rhino(String newline) {


        org.mozilla.javascript.Context cx = org.mozilla.javascript.Context.enter();

        // Disable optimization lest we get the dreaded
        // java.lang.UnsupportedOperationException: can't load this type of class file
        // error.
        cx.setOptimizationLevel(-1);
        Scriptable scope = cx.initStandardObjects();

        Object result;
        String retString;
        try {
            result = cx.evaluateString(scope, newline, "<cmd>", 1, null);
            retString = result.toString();
        } catch(Throwable th) {
            retString = th.getLocalizedMessage();
        }
        return retString;

    }

    private class RhinoInteractionAdapter extends BaseAdapter {
        // Must have this when constructing or inflating adapter element views
        private android.content.Context context;

        private Vector<RhinoInteraction> rhinoInteractions;

        public RhinoInteractionAdapter(android.content.Context context, Vector<RhinoInteraction> ri) {
            this.context = context;
            rhinoInteractions = ri;
        }

        //public void DI(Vector<Interaction> s) {
            //interactions = s;
        //}

        public int getCount() {
            return rhinoInteractions.size();
        }

        public Object getItem(int position) {
            return rhinoInteractions.get(position);
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {

            RhinoInteraction interaction = rhinoInteractions.elementAt(position);
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(android.content.Context.LAYOUT_INFLATER_SERVICE);
            View v = inflater.inflate(R.layout.rhino_interaction_tile, null);

            if (interaction.fRhinoSpeaks)
                v.setBackgroundResource(R.color.green_lite_m);
            else
                v.setBackgroundResource(R.color.green_lite_p);

            TextView tv = (TextView) v.findViewById(R.id.rhinoInteraction);
            tv.setText(interaction.theText);

            return v;

        }
    }
}