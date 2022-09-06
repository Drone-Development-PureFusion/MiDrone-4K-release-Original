package com.tencent.stat;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.tencent.stat.q */
/* loaded from: classes2.dex */
public class RunnableC4439q implements Runnable {

    /* renamed from: a */
    final /* synthetic */ List f18500a;

    /* renamed from: b */
    final /* synthetic */ C4436n f18501b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC4439q(C4436n c4436n, List list) {
        this.f18501b = c4436n;
        this.f18500a = list;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f18501b.m5117b(this.f18500a);
    }
}
