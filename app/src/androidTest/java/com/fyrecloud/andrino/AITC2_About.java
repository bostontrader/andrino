package com.fyrecloud.andrino;

import android.test.ActivityInstrumentationTestCase2;

import com.fyrecloud.andrino.activities.About;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class AITC2_About extends ActivityInstrumentationTestCase2<About> {

    public AITC2_About() {
        super(About.class);
    }

    public void test() {

        // We need to invoke this in order to start the activity but
        // we don't need reference to it.
        getActivity();

        // 1. Initial peek.  Are the UI elements there?
        onView(withId(R.id.andrino_icon_128x128)).check(matches(isDisplayed()));
        onView(withId(R.id.btnURL)).check(matches(isDisplayed()));
        onView(withId(R.id.btnURL)).check(matches(withText(R.string.url)));
        onView(withId(R.id.btnSendEmail)).check(matches(isDisplayed()));
        onView(withId(R.id.btnSendEmail)).check(matches(withText(R.string.send_email)));
    }

}
