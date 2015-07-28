package com.fyrecloud.andrino;

import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;

public class AITC2_MainActivity extends ActivityInstrumentationTestCase2<MainActivity> {

    public AITC2_MainActivity() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void test() {

        MainActivity mActivity = getActivity();
        assertTrue(true);
    }


}
