package com.fyrecloud.andrino;

import android.test.ActivityInstrumentationTestCase2;

import com.fyrecloud.andrino.activities.About;
import com.fyrecloud.andrino.activities.SettingsActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 *  @author Thomas Radloff  bostontrader@gmail.com
 */

public class AITC2_SettingsActivity extends ActivityInstrumentationTestCase2<SettingsActivity> {

    public AITC2_SettingsActivity() {
        super(SettingsActivity.class);
    }

}
