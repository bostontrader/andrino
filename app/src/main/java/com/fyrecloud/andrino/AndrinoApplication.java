package com.fyrecloud.andrino;

import android.app.Application;
import android.os.Bundle;

import org.mozilla.javascript.Scriptable;

/**
 *  @author Thomas Radloff  bostontrader@gmail.com
 *
 * The objects used by Rhino need to survive the gyrations of Activity lifecycles.
 * Since said objects have proven to be remarkably difficult to "serialize" I've decided to put
 * them here.  Please see randomnotes for links for how we might otherwise serialize
 * the Rhino objects.
 *
 * I've chosen to use an Application object instead of a Singleton because the later
 * are more likely to get GC'ed at embarrassing moments. Please see the following links
 * for an intro to the issue of Application vs. Singleton
 *
 * http://stackoverflow.com/questions/3826905/singletons-vs-application-context-in-android
 * http://stackoverflow.com/questions/9178245/android-application-as-singleton?lq=1
 */

public class AndrinoApplication extends Application {

    private Scriptable scope;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public Scriptable getScope(org.mozilla.javascript.Context cx) {
        if(scope == null)
            scope = cx.initStandardObjects();
        return scope;
    }

}