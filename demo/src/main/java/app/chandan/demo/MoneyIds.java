package app.chandan.demo;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;

import java.util.ArrayList;
import java.util.List;

public class MoneyIds {
    public static void AreYouTesting() {
        if (MyApp.are_you_testing) {
            List<String> testDevices = new ArrayList<>();
            testDevices.add("15C1E3358412CF75C3DD412DD6EE2ED0");
            RequestConfiguration requestConfiguration = new RequestConfiguration.Builder().setTestDeviceIds(testDevices).build();
            MobileAds.setRequestConfiguration(requestConfiguration);
        }
    }

    public static String getAppOpenAdId() {
        return "ca-app-pub-3940256099942544/1033173712";
    }
}
