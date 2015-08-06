package com.fyrecloud.andrino;

import android.view.ContextThemeWrapper;

import com.fyrecloud.andrino.activities.MainActivity;

/**
 *  @author Thomas Radloff  bostontrader@gmail.com
 */

public class AUTC_MainActivity extends AUTC_Shim<MainActivity> {

    public AUTC_MainActivity() {super(MainActivity.class);}

    protected void setUp() throws Exception {
        super.setUp();

        // Because MainActivity extends AppCompatActivity we need this lump
        // of code to make the test work.
        // https://code.google.com/p/android/issues/detail?id=128421
        ContextThemeWrapper context = new ContextThemeWrapper(
                getInstrumentation().getTargetContext(), R.style.Theme_AppCompat_Light);
        setActivityContext(context);


    }

    // Unfortunately, the buttons on the Action Bar cannot be tested
    // from here.  This Action, in isolation, doesn't have a MenuBar.
    // Need @UiThreadTest to ensure that startActivity runs on UI thread.
    // remove this at your peril.
    /*@UiThreadTest
    public void testAboutButton() {

        // 1. Start the activity and click on the About button.
        startActivity(new Intent(getInstrumentation().getTargetContext(), MainActivity.class), null, null);
        Object o = getActivity();
        Button btnAbout = (Button) getActivity().findViewById(R.id.action_about);
        btnAbout.performClick();

        // 2. Examine the resulting intent.
        final Intent launchIntent = getStartedActivityIntent();
        assertNotNull(launchIntent);

        Context ctx = getInstrumentation().getTargetContext();

        assertThat(launchIntent.getAction(),equalTo(Intent.ACTION_VIEW));
        assertThat(launchIntent.getDataString(),equalTo(ctx.getString(R.string.about)));
    }*/

    // Need @UiThreadTest to ensure that startActivity runs on UI thread.
    // remove this at your peril.
    /*@UiThreadTest
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

    }*/

}