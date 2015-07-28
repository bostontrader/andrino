package com.fyrecloud.andrino;

import android.test.ActivityInstrumentationTestCase2;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;

public class AITC2_MainActivity extends ActivityInstrumentationTestCase2<MainActivity> {

    public AITC2_MainActivity() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void test() {

        getActivity();

        onView(withId(R.id.thePrompt)).check(matches(isDisplayed()));
        onView(withId(R.id.thePrompt)).perform(typeText("catfood"));

        onView(withId(R.id.btnFullScreenEditor)).check(matches(isDisplayed()));
        onView(withId(R.id.btnFullScreenEditor)).perform(click());

        // Clicking launches a new activity that shows the text entered above. You don't need to do
        // anything special to handle the activity transitions. Espresso takes care of waiting for the
        // new activity to be resumed and its view hierarchy to be laid out.
        onView(withId(R.id.theText))
            .check(matches(withText(("catfood"))));
    }

}
