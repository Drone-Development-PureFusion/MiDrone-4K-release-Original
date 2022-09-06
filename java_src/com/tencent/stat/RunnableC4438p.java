package com.tencent.stat;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.tencent.stat.p */
/* loaded from: classes2.dex */
public class RunnableC4438p implements Runnable {

    /* renamed from: a */
    final /* synthetic */ List f18497a;

    /* renamed from: b */
    final /* synthetic */ int f18498b;

    /* renamed from: c */
    final /* synthetic */ C4436n f18499c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC4438p(C4436n c4436n, List list, int i) {
        this.f18499c = c4436n;
        this.f18497a = list;
        this.f18498b = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f18499c.m5116b(this.f18497a, this.f18498b);
    }
}
