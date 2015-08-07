package com.fyrecloud.andrino;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.test.ActivityInstrumentationTestCase2;

import com.fyrecloud.andrino.activities.SettingsActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

/**
 *  @author Thomas Radloff  bostontrader@gmail.com
 */

public class AITC2_SettingsActivity extends ActivityInstrumentationTestCase2<SettingsActivity> {

    public AITC2_SettingsActivity() {
        super(SettingsActivity.class);
    }

    // Can we toggle the value of the soundfx setting?
    public void testToggleSoundFX() {

        // 1. What is the present value of the setting?
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String soundFXKey = getActivity().getString(R.string.SOUND_FX_KEY);
        boolean soundFX = sharedPref.getBoolean(soundFXKey, false);

        // 2. Can we see the button?
        String buttonText = getActivity().getString(R.string.SOUND_FX_TITLE);
        onView(withText(buttonText)).check(matches(isDisplayed()));

        // 3. Click the button.
        onView(withText(buttonText)).perform(click());

        // 4. Did the setting change?
        boolean soundFXNew = sharedPref.getBoolean(soundFXKey, false);
        assertThat(soundFXNew, is(not(soundFX)));
    }
}
