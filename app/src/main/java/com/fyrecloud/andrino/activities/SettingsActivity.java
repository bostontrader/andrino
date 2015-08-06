package com.fyrecloud.andrino.activities;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class SettingsActivity extends PreferenceActivity  {

    @Override
    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(com.fyrecloud.andrino.R.xml.preferences);
    }

}