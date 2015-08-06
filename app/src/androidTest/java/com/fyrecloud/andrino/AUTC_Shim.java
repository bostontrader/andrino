package com.fyrecloud.andrino;

import android.app.Activity;
import android.test.ActivityUnitTestCase;

/**
 * The purpose of this class is to provide minor additional functionality
 * for the Andrino testing classes that want to use ActivityUnitTestCase
 *
 * @author Thomas Radloff  bostontrader@gmail.com
 *
 * Buttons of the Activities under test will create intents that would ultimately
 * be used to launch other activities.  We cannot directly follow this flow
 * but we can verify that intents are created, as well as their content.
 *
 * We cannot use Espresso testing with this class.  Doing so tends to hang the test.
 * Use ActivityInstrumentationTestCase2 instead.
 *
 * Each test method has a call to startActivity.
 * We cannot factor out startActivity from the test methods
 * into setUp because the docs (1) tell us not to, and because doing so
 * simply doesn't work.  We also need to annotate our test methods
 * with @UiThreadTest or startActivity will fail.
 *
 * Apparently this has something to do with which thread setUp and test
 * methods use (2).
 *
 * (1) http://developer.android.com/reference/android/test/ActivityUnitTestCase.html#startActivity%28android.content.Intent,%20android.os.Bundle,%20java.lang.Object%29
 * (2) http://stackoverflow.com/questions/4297458/activityunittestcase-and-startactivity
 * (3) http://developer.android.com/training/activity-testing/activity-unit-testing.html
 * (4) http://developer.android.com/reference/android/test/ActivityUnitTestCase.html
 */
public class AUTC_Shim<T extends Activity>  extends ActivityUnitTestCase<T> {
    public AUTC_Shim(Class<T> t) {super(t);}
}
