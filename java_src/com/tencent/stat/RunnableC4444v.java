package com.tencent.stat;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.tencent.stat.v */
/* loaded from: classes2.dex */
public class RunnableC4444v implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f18511a;

    /* renamed from: b */
    final /* synthetic */ C4436n f18512b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC4444v(C4436n c4436n, int i) {
        this.f18512b = c4436n;
        this.f18511a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        int m5300a = StatConfig.m5300a();
        int i = this.f18511a == -1 ? this.f18512b.f18492b : this.f18511a;
        int i2 = i / m5300a;
        int i3 = i % m5300a;
        for (int i4 = 0; i4 < i2 + 1; i4++) {
            this.f18512b.m5122b(m5300a);
        }
        if (i3 > 0) {
            this.f18512b.m5122b(i3);
        }
    }
}
