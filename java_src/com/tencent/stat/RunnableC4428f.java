package com.tencent.stat;

import com.tencent.stat.common.StatLogger;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.tencent.stat.f */
/* loaded from: classes2.dex */
public class RunnableC4428f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ List f18476a;

    /* renamed from: b */
    final /* synthetic */ AbstractC4409c f18477b;

    /* renamed from: c */
    final /* synthetic */ C4426d f18478c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC4428f(C4426d c4426d, List list, AbstractC4409c abstractC4409c) {
        this.f18478c = c4426d;
        this.f18476a = list;
        this.f18477b = abstractC4409c;
    }

    @Override // java.lang.Runnable
    public void run() {
        StatLogger statLogger;
        try {
            this.f18478c.m5145a(this.f18476a, this.f18477b);
        } catch (Throwable th) {
            statLogger = C4426d.f18469c;
            statLogger.m5236e(th);
        }
    }
}
