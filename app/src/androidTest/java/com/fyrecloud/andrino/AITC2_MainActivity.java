package com.fyrecloud.andrino;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
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

        Activity activity = getActivity();

        // 1. thePrompt, in MainActivity and the Editor should both have
        // the same hint.
        onView(withId(R.id.thePrompt)).check(matches(isDisplayed()));
        onView(withId(R.id.thePrompt)).check(matches(withHint(R.string.enter_javascript)));
        onView(withId(R.id.btnFullScreenEditor)).check(matches(isDisplayed()));
        onView(withId(R.id.btnFullScreenEditor)).perform(click());
        onView(withId(R.id.theText)).check(matches(withHint(R.string.enter_javascript)));
        pressBack();

        // 2. Now enter some javascript at thePrompt and navigate to the Editor.
        // Did the javascript survive the trip?
        onView(withId(R.id.thePrompt)).perform(typeText(activity.getString(R.string.one_plus_two)));
        onView(withId(R.id.btnFullScreenEditor)).perform(click());
        onView(withId(R.id.theText)).check(matches(withText(activity.getString(R.string.one_plus_two))));
    }

}
