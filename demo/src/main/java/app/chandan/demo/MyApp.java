package app.chandan.demo;

import android.app.Application;

import com.google.android.gms.ads.MobileAds;

public class MyApp extends Application {
    public static final boolean are_you_testing = true;

    @Override
    public void onCreate() {
        super.onCreate();
        MobileAds.initialize(this);
        MoneyIds.AreYouTesting();
    }
}
