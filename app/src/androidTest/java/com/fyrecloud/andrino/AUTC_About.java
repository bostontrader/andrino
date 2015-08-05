package com.fyrecloud.andrino;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.test.ActivityUnitTestCase;
import android.test.UiThreadTest;
import android.widget.Button;

import com.fyrecloud.andrino.activities.About;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.Set;

// Test the functionality of the buttons.  Based on (3) and (4).
//
// The buttons of this activity should create intents that will ultimately
// be used to launch other activities.  We cannot directly follow this flow
// but we can verify that intents are created, as well as their content.
//
// Each test method has a call to startActivity.
// We cannot factor out startActivity from the test methods
// into setUp because the docs (1) tell us not to, and because doing so
// simply doesn't work.  We also need to annotate our test methods
// with @UiThreadTest or startActivity will fail.
//
// Apparently this has something to do with which thread setUp and test
// methods use (2).
//
// (1) http://developer.android.com/reference/android/test/ActivityUnitTestCase.html#startActivity%28android.content.Intent,%20android.os.Bundle,%20java.lang.Object%29
// (2) http://stackoverflow.com/questions/4297458/activityunittestcase-and-startactivity
// (3) http://developer.android.com/training/activity-testing/activity-unit-testing.html
// (4) http://developer.android.com/reference/android/test/ActivityUnitTestCase.html

public class AUTC_About extends ActivityUnitTestCase<About> {

    public AUTC_About() {super(About.class);}

    // Need @UiThreadTest to ensure that startActivity runs on UI thread.
    // remove this at your peril.
    @UiThreadTest
    public void testURLButton() {

        // 1. Start the activity and click on the URL button.
        startActivity(new Intent(getInstrumentation().getTargetContext(), About.class), null, null);
        Button btnURL = (Button) getActivity().findViewById(R.id.btnURL);
        btnURL.performClick();

        // 2. Examine the resulting intent.
        final Intent launchIntent = getStartedActivityIntent();
        assertNotNull(launchIntent);

        Context ctx = getInstrumentation().getTargetContext();

        assertThat(launchIntent.getAction(),equalTo(Intent.ACTION_VIEW));
        assertThat(launchIntent.getDataString(),equalTo(ctx.getString(R.string.url)));
    }

    // Need @UiThreadTest to ensure that startActivity runs on UI thread.
    // remove this at your peril.
    @UiThreadTest
    public void testSendEmailButton() {

        // 1.
        startActivity(new Intent(getInstrumentation().getTargetContext(), About.class), null, null);
        Button btnSendEmail = (Button) getActivity().findViewById(R.id.btnSendEmail);
        btnSendEmail.performClick();

        // 2. Examine the resulting intent.
        final Intent launchIntent = getStartedActivityIntent();
        assertNotNull(launchIntent);

        Context ctx = getInstrumentation().getTargetContext();

        assertThat(launchIntent.getAction(),equalTo(Intent.ACTION_CHOOSER));

        // This chooser Intent has a Title and another Intent as its extras.
        // First retrieve the Bundle of extras and verify the title
        Bundle bundleOfExtras = launchIntent.getExtras();
        assertThat(bundleOfExtras.getString(Intent.EXTRA_TITLE),equalTo(ctx.getString(R.string.send_email)));

        // Now retrieve the inner Intent.  It also has extras that we need to verify
        Intent innerIntent = bundleOfExtras.getParcelable(Intent.EXTRA_INTENT);
        assertThat(innerIntent.getStringExtra(Intent.EXTRA_SUBJECT),equalTo(ctx.getString(R.string.regarding_andrino)));
        assertThat(innerIntent.getStringExtra(Intent.EXTRA_TEXT),equalTo(ctx.getString(R.string.body_of_email)));

        // Finally, the email address is a String[].  Retrieve that array
        // and verify it.
        String[] email_addresses = innerIntent.getStringArrayExtra(Intent.EXTRA_EMAIL);
        assertThat(1,equalTo(email_addresses.length));
        assertThat(ctx.getString(R.string.myemail),equalTo(email_addresses[0]));

    }

}