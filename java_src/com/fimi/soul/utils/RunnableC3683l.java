package com.fimi.soul.utils;

import android.app.ProgressDialog;
import android.os.Handler;
import android.os.Message;
import com.fimi.soul.base.C2353b;
/* renamed from: com.fimi.soul.utils.l */
/* loaded from: classes.dex */
public class RunnableC3683l implements Runnable {

    /* renamed from: a */
    private Handler f14933a;

    /* renamed from: b */
    private ProgressDialog f14934b;

    /* renamed from: c */
    private String f14935c;

    public RunnableC3683l(String str, Handler handler) {
        this.f14935c = str;
        this.f14933a = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        System.out.println("下载线程开启");
        new Message().what = C3635ae.m7713a(this.f14935c, C2353b.f7912C, C3681j.m7470i(), this.f14933a);
    }
}
