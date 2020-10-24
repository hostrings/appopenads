package app.chandan.demo;

import android.app.Application;

import com.google.android.gms.ads.MobileAds;

public class App extends Application {
    public static final boolean are_you_testing = true;
        private app.chandan.appopenads.AppOpenManager<App> appOpenManager;

    @Override
    public void onCreate() {
        super.onCreate();
        MobileAds.initialize(this);
        MoneyIds.AreYouTesting();
        appOpenManager = new app.chandan.appopenads.AppOpenManager<>(this, MoneyIds.getAppOpenAdId());
    }
}
