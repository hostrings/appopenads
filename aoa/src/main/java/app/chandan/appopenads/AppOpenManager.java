package app.chandan.appopenads;


import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.appopen.AppOpenAd;

import java.util.Date;

import static androidx.lifecycle.Lifecycle.Event.ON_START;

public class AppOpenManager<App extends Application> implements Application.ActivityLifecycleCallbacks, LifecycleObserver {
    public static final String TAG = "AppOpenAds";
    private App myApplication;
    private Activity currentActivity;
    private AppOpenAd appOpenAd = null;
    private long loadTime = 0;
    private static boolean isShowingAd = false;
    String ad_id;

    public AppOpenManager(App app, String ad_id) {
        myApplication = app;
        this.ad_id = ad_id;
    }

    @OnLifecycleEvent(ON_START)
    public void onStart() {
        showAdIfAvailable();
        Log.d(TAG, "onStart");
    }

    public AppOpenManager(App myApplication) {
        this.myApplication = myApplication;
        this.myApplication.registerActivityLifecycleCallbacks(this);
        ProcessLifecycleOwner.get().getLifecycle().addObserver(this);
    }

    public void fetchAd() {
        if (isAdAvailable()) {
            return;
        }
        AppOpenAd.load(myApplication, ad_id, new AdRequest.Builder().build(), AppOpenAd.APP_OPEN_AD_ORIENTATION_PORTRAIT,
                new AppOpenAd.AppOpenAdLoadCallback() {
                    @Override
                    public void onAppOpenAdLoaded(AppOpenAd ad) {
                        AppOpenManager.this.appOpenAd = ad;
                        AppOpenManager.this.loadTime = (new Date()).getTime();
                        Log.d(TAG, "Ad loaded successfully!");
                    }

                    @Override
                    public void onAppOpenAdFailedToLoad(LoadAdError loadAdError) {
                        Log.d(TAG, "Failed to load Ad \n" + loadAdError.toString());
                    }
                });
    }

    public void showAdIfAvailable() {
        if (!isShowingAd && isAdAvailable()) {
            Log.d(TAG, "Will show ad!");
            appOpenAd.show(currentActivity, new FullScreenContentCallback() {
                @Override
                public void onAdDismissedFullScreenContent() {
                    appOpenAd = null;
                    isShowingAd = false;
                    fetchAd();
                }

                @Override
                public void onAdFailedToShowFullScreenContent(AdError adError) {
                    Log.d(TAG, adError.toString());
                }

                @Override
                public void onAdShowedFullScreenContent() {
                    isShowingAd = true;
                }
            });
        } else {
            Log.d(TAG, "Can't show ad!");
            fetchAd();
        }
    }

    public boolean isAdAvailable() {
        return appOpenAd != null && wasLoadTimeLessThanNHoursAgo(4);
    }

    @Override
    public void onActivityCreated(@NonNull Activity activity, Bundle savedInstanceState) {
    }

    @Override
    public void onActivityStarted(@NonNull Activity activity) {
        currentActivity = activity;
    }

    @Override
    public void onActivityResumed(@NonNull Activity activity) {
        currentActivity = activity;
    }

    @Override
    public void onActivityStopped(@NonNull Activity activity) {
    }

    @Override
    public void onActivityPaused(@NonNull Activity activity) {
    }

    @Override
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
    }

    @Override
    public void onActivityDestroyed(@NonNull Activity activity) {
        currentActivity = null;
    }

    private boolean wasLoadTimeLessThanNHoursAgo(long numHours) {
        long dateDifference = (new Date()).getTime() - this.loadTime;
        long numMilliSecondsPerHour = 3600000;
        return (dateDifference < (numMilliSecondsPerHour * numHours));
    }
}
