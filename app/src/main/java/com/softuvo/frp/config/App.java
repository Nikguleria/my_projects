package com.softuvo.frp.config;

import android.content.Context;
import android.support.multidex.MultiDexApplication;
import android.support.v7.app.AppCompatDelegate;

import com.facebook.stetho.Stetho;
import com.softuvo.frp.api.ApiHelper;

public class App extends MultiDexApplication {
    private static App instance;
    private static ApiHelper apiHelper;
    public static boolean isShowLogAndDvirDialog = true;
    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        apiHelper = ApiHelper.init();
        Stetho.initializeWithDefaults(this);
    }

    public static Context getAppContext() {
        return instance;
    }

    public static ApiHelper getApiHelper() {
        return apiHelper;
    }
}
