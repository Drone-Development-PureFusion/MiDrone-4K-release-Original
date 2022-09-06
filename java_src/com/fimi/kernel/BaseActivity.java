package com.fimi.kernel;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.p001v4.app.FragmentActivity;
import com.fimi.kernel.p157b.AbstractC2194b;
import com.fimi.kernel.p157b.EnumC2222d;
import com.fimi.kernel.p163c.AbstractC2239a;
import com.fimi.kernel.utils.C2281x;
import com.fimi.kernel.view.AbstractC2288b;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public abstract class BaseActivity extends FragmentActivity {
    private Handler activityInnerHandler;
    private Map<EnumC2222d, AbstractC2194b> networkManagerMap;

    /* renamed from: com.fimi.kernel.BaseActivity$a */
    /* loaded from: classes.dex */
    class HandlerC2166a extends Handler {
        HandlerC2166a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            BaseActivity.this.onHandleMessage(message);
            super.handleMessage(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Handler getHandler() {
        return this.activityInnerHandler;
    }

    protected AbstractC2239a getKeyValueStoreManager() {
        return C2238c.m13125c();
    }

    public AbstractC2194b getNetworkManager(EnumC2222d enumC2222d) {
        if (this.networkManagerMap == null) {
            this.networkManagerMap = new HashMap();
        }
        if (this.networkManagerMap.containsKey(enumC2222d)) {
            return this.networkManagerMap.get(enumC2222d);
        }
        AbstractC2194b abstractC2194b = (AbstractC2194b) C2238c.m13128a(enumC2222d);
        this.networkManagerMap.put(enumC2222d, abstractC2194b);
        return abstractC2194b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractC2288b getViewManager() {
        return C2238c.m13127b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C2238c.m13130a((Activity) this);
        this.activityInnerHandler = new HandlerC2166a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        C2238c.m13126b(this);
        super.onDestroy();
    }

    public void onHandleMessage(Message message) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        C2238c.m13130a((Activity) this);
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.p001v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        C2238c.m13130a((Activity) this);
        super.onStart();
    }

    public void runInBackground(Runnable runnable) {
        C2281x.m12704a(runnable);
    }
}
