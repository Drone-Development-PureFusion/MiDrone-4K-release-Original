package com.amap.api.services.core;

import java.io.Writer;
import java.util.concurrent.Callable;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.amap.api.services.core.bl */
/* loaded from: classes.dex */
public class CallableC1216bl implements Callable<Void> {

    /* renamed from: a */
    final /* synthetic */ C1211bk f4126a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallableC1216bl(C1211bk c1211bk) {
        this.f4126a = c1211bk;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a */
    public Void call() {
        Writer writer;
        boolean m17100h;
        synchronized (this.f4126a) {
            writer = this.f4126a.f4103k;
            if (writer != null) {
                this.f4126a.m17098j();
                m17100h = this.f4126a.m17100h();
                if (m17100h) {
                    this.f4126a.m17101g();
                    this.f4126a.f4105m = 0;
                }
            }
        }
        return null;
    }
}
