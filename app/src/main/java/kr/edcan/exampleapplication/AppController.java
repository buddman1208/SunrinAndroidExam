package kr.edcan.exampleapplication;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by Sunrin on 2017-03-06.
 */

public class AppController extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
