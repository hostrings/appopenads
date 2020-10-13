# AppOpenAds
App open ads are a special ad format intended for publishers wishing to monetize their app load screens. App open ads can be closed at any time, and are designed to be shown when your users bring your app to the foreground.
Please check [this](https://developers.google.com/admob/android/app-open-ads)!

# Demo
![Demo 1](https://cdn.chandan.app/gh/aoa_1.jpg)
![Demo 2](https://cdn.chandan.app/gh/aoa_2.jpg)
![Demo 3](https://cdn.chandan.app/gh/aoa_3.jpg)

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
```groovy
dependencies {
	implementation 'com.github.realchandan:appopenads:1.0.1'
}
```

## Now in Application subclass
```java
public class MyApp extends Application {
    private AppOpenManager<MyApp> appOpenManager;

    @Override
    public void onCreate() {
        super.onCreate();
        MobileAds.initialize(this);
        // TODO: Very Important
        // TODO: MAKE SURE YOU TEST WITH TEST IDS
        // TODO: OR CONFIGURE TEST DEVICES
        appOpenManager = new AppOpenManager<>(this, "<your-ad-id>");
    }
}
```

# Contribution
Please do contribute!

# License
MIT License