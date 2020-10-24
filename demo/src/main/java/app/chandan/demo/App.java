package app.chandan.demo;

import android.app.Application;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.appopen.AppOpenAd;

import app.chandan.aoa.AppOpenManager;
import app.chandan.aoa.delay.InitialDelay;

public class App extends Application {
    public static final boolean are_you_testing = true;
//    private app.chandan.aoa.AppOpenManager<App> appOpenManager;

    @Override
    public void onCreate() {
        super.onCreate();
        MobileAds.initialize(this);
        MoneyIds.AreYouTesting();
//        appOpenManager = new app.chandan.aoa.AppOpenManager<>(this, MoneyIds.getAppOpenAdId());
        new AppOpenManager(App.this, InitialDelay.NONE, MoneyIds.getAppOpenAdId(), new AdRequest.Builder().build(),
                AppOpenAd.APP_OPEN_AD_ORIENTATION_PORTRAIT);
    }
}
