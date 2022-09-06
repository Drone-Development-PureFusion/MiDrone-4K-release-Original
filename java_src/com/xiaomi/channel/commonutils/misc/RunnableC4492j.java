package com.xiaomi.channel.commonutils.misc;

import com.xiaomi.channel.commonutils.misc.C4488h;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.xiaomi.channel.commonutils.misc.j */
/* loaded from: classes2.dex */
public class RunnableC4492j implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C4488h.AbstractC4490b f18566a;

    /* renamed from: b */
    final /* synthetic */ C4488h f18567b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC4492j(C4488h c4488h, C4488h.AbstractC4490b abstractC4490b) {
        this.f18567b = c4488h;
        this.f18566a = abstractC4490b;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f18567b.m5015a(this.f18566a);
    }
}
