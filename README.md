[![](https://jitpack.io/v/realchandan/appopenads.svg)](https://jitpack.io/#realchandan/appopenads)

# AppOpenAds
App open ads are a special ad format intended for publishers wishing to monetize their app load screens. App open ads can be closed at any time, and are designed to be shown when your users bring your app to the foreground.
Please check [this](https://developers.google.com/admob/android/app-open-ads)!

# Demo
![Demo 1](https://raw.githubusercontent.com/realchandan/appopenads/code/demo/screenshots/aoa_1.jpg)
![Demo 2](https://raw.githubusercontent.com/realchandan/appopenads/code/demo/screenshots/aoa_2.jpg)
![Demo 3](https://raw.githubusercontent.com/realchandan/appopenads/code/demo/screenshots/aoa_3.jpg)

# How to use?

## Add below to project level gradle
```groovy
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

## Add below to app level gradle
Check the latest version from above.
```groovy
dependencies {
	implementation 'com.github.realchandan:appopenads:1.0.3'
}
```

## Now in Application subclass
```java
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        MobileAds.initialize(this);
        // TODO: Very Important
        // TODO: MAKE SURE YOU TEST WITH TEST IDS
        // TODO: OR CONFIGURE TEST DEVICES
        new AppOpenManager(App.this, InitialDelay.NONE, MoneyIds.getAppOpenAdId(), new AdRequest.Builder().build(),
            AppOpenAd.APP_OPEN_AD_ORIENTATION_PORTRAIT);
    }
}
```

# Contribution
Please do contribute!

# License
MIT License