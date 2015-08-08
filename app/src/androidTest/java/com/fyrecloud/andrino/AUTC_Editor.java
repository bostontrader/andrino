package com.fyrecloud.andrino;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.test.UiThreadTest;
import android.widget.Button;

import com.fyrecloud.andrino.activities.About;
import com.fyrecloud.andrino.activities.Editor;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 *  @author Thomas Radloff  bostontrader@gmail.com
 */

public class AUTC_Editor extends AUTC_Shim<Editor> {

    public AUTC_Editor() {super(Editor.class);}

    // Need @UiThreadTest to ensure that startActivity runs on UI thread.
    // remove this at your peril.
    @UiThreadTest
    public void testSubmitButton() {

        // 1. Start the activity and click on the Submit button.
        startActivity(new Intent(getInstrumentation().getTargetContext(), Editor.class), null, null);
        Button btnSubmit = (Button) getActivity().findViewById(R.id.btnSubmit);
        btnSubmit.performClick();

        assertTrue(isFinishCalled());

        // 2. Examine the resulting intent.
        // This comes up null.  How do we test setResult Intents?
        //final Intent launchIntent = getStartedActivityIntent();
        //assertNotNull(launchIntent);

        //Context ctx = getInstrumentation().getTargetContext();

        //assertThat(launchIntent.getAction(),equalTo(Intent.ACTION_VIEW));
        //assertThat(launchIntent.getDataString(),equalTo(ctx.getString(R.string.url)));
    }

}