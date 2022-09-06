package com.fimi.kernel;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;
import com.fimi.kernel.utils.C2281x;
/* loaded from: classes.dex */
public class BaseApplication extends MultiDexApplication {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.multidex.MultiDexApplication, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(context);
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        C2238c.m13129a(getApplicationContext());
    }

    @Override // android.app.Application
    public void onTerminate() {
        C2281x.m12703b();
        super.onTerminate();
    }
}
