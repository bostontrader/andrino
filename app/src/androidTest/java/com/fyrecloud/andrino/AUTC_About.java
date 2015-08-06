package com.fyrecloud.andrino;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.test.ActivityUnitTestCase;
import android.test.UiThreadTest;
import android.widget.Button;

import com.fyrecloud.andrino.activities.About;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 *  @author Thomas Radloff  bostontrader@gmail.com
 */
import java.util.Set;

public class AUTC_About extends AUTC_Shim<About> {

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