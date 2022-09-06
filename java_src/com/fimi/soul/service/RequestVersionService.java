package com.fimi.soul.service;

import android.app.IntentService;
import android.content.Intent;
import com.fimi.soul.base.DroidPlannerApp;
import com.fimi.soul.module.update.p210a.C3579a;
import com.fimi.soul.module.update.p210a.C3585g;
/* loaded from: classes.dex */
public class RequestVersionService extends IntentService {

    /* renamed from: a */
    public static final String f14708a = "RequestVersionService";

    public RequestVersionService() {
        super(f14708a);
    }

    public RequestVersionService(String str) {
        super(str);
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        C3585g c3585g = new C3585g(this, ((DroidPlannerApp) getApplication()).f7895a);
        for (int i = 0; i < 5; i++) {
            c3585g.m7887c();
            if (C3579a.m7971a().m7970a(0).m7921b() > 0) {
                return;
            }
        }
    }
}
