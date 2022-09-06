package com.tencent.stat;

import com.tencent.stat.p232a.AbstractC4401e;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.tencent.stat.r */
/* loaded from: classes2.dex */
public class RunnableC4440r implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AbstractC4401e f18502a;

    /* renamed from: b */
    final /* synthetic */ AbstractC4409c f18503b;

    /* renamed from: c */
    final /* synthetic */ C4436n f18504c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC4440r(C4436n c4436n, AbstractC4401e abstractC4401e, AbstractC4409c abstractC4409c) {
        this.f18504c = c4436n;
        this.f18502a = abstractC4401e;
        this.f18503b = abstractC4409c;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f18504c.m5120b(this.f18502a, this.f18503b);
    }
}
