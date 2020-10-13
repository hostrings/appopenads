package app.chandan.demo;

import android.app.Application;

import com.google.android.gms.ads.MobileAds;

import app.chandan.appopenads.AppOpenManager;

public class MyApp extends Application {
    public static final boolean are_you_testing = true;
    private AppOpenManager<MyApp> appOpenManager;

    @Override
    public void onCreate() {
        super.onCreate();
        MobileAds.initialize(this);
        MoneyIds.AreYouTesting();
        appOpenManager = new AppOpenManager<>(this, MoneyIds.getAppOpenAdId());
    }
}
