package com.fimi.soul.biz.p178g;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import com.fimi.soul.module.setting.C3495f;
import com.fimi.soul.module.setting.FlyLogsActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
/* renamed from: com.fimi.soul.biz.g.i */
/* loaded from: classes.dex */
public class HandlerC2458i extends Handler {

    /* renamed from: a */
    private WeakReference<Activity> f8462a;

    public HandlerC2458i(Activity activity) {
        this.f8462a = new WeakReference<>(activity);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        ArrayList<C3495f> m8455b;
        super.handleMessage(message);
        Activity activity = this.f8462a.get();
        if (activity == null || !(activity instanceof FlyLogsActivity)) {
            return;
        }
        FlyLogsActivity flyLogsActivity = (FlyLogsActivity) activity;
        if (message.what != 10 || (m8455b = flyLogsActivity.m8455b()) == null) {
            return;
        }
        ArrayList<C3495f> m8452c = flyLogsActivity.m8452c();
        m8452c.addAll((ArrayList) m8455b.clone());
        flyLogsActivity.m8460a().m8289a(m8452c);
        m8455b.clear();
    }
}
