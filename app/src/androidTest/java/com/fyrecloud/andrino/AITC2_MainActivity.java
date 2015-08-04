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
import static android.support.test.espresso.action.ViewActions.typeText;

import static org.hamcrest.Matchers.allOf;

import com.fyrecloud.andrino.activities.MainActivity;

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

        // 1. Initial peek.  Are the UI controls there?

        // 1.1 Action Bar
        // can I see the andrino icon in the action bar?
        onView(withId(R.id.action_settings)).check(matches(isDisplayed()));
        onView(withId(R.id.action_about)).check(matches(isDisplayed()));

        // 1.2 Other UI elements
        onView(withId(R.id.rhinoInteractions)).check(matches(isDisplayed()));
        onView(withId(R.id.thePrompt)).check(matches(isDisplayed()));
        onView(withId(R.id.thePrompt)).check(matches(withHint(R.string.enter_javascript)));
        onView(withId(R.id.btnSubmit)).check(matches(isDisplayed()));
        onView(withId(R.id.btnSubmit)).check(matches(withText(R.string.submit)));
        onView(withId(R.id.btnFullScreenEditor)).check(matches(isDisplayed()));
        onView(withId(R.id.btnFullScreenEditor)).check(matches(withText(R.string.full_screen_editor)));

        // 2. Can we navigate to the about screen?
        onView(withId(R.id.action_about)).perform(click());
        // Can I see the andrino icon?
        onView(withId(R.id.btnURL)).check(matches(isDisplayed()));
        onView(withId(R.id.btnSendEmail)).check(matches(isDisplayed()));
        // What happens when I click fyrecloud?
        // What happens when I click "send email"

        // 2.1 Now navigate back to MainActivity
        pressBack();

        // 3. Back to MainActivity.
        // How to check which activity now?  Don't bother.
        // If not correct, then the test will quickly fail.        //
        // Now enter a small bit o' code and click submit.  Do we get
        // a sensible result?
        onView(withId(R.id.thePrompt)).perform(typeText(activity.getString(R.string.one_plus_two)));
        onView(withId(R.id.btnSubmit)).perform(click());
        onView(allOf(withId(R.id.rhinoInteraction), withText(R.string.one_plus_two)));
        onView(allOf(withId(R.id.rhinoInteraction), withText(R.string.three_p_zero)));
    }

}
