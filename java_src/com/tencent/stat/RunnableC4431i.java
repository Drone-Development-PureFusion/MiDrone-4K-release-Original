package com.tencent.stat;

import android.content.Context;
import com.fimi.kernel.p157b.p161d.C2227d;
import com.tencent.stat.common.StatLogger;
import com.tencent.stat.p232a.C4400d;
import java.io.File;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.tencent.stat.i */
/* loaded from: classes2.dex */
public class RunnableC4431i implements Runnable {

    /* renamed from: a */
    private Context f18481a;

    public RunnableC4431i(Context context) {
        this.f18481a = null;
        this.f18481a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        StatLogger statLogger;
        Iterator<File> it2 = StatNativeCrashReport.m5278a(this.f18481a).iterator();
        while (it2.hasNext()) {
            File next = it2.next();
            C4400d c4400d = new C4400d(this.f18481a, StatService.m5270a(this.f18481a, false), StatNativeCrashReport.m5277a(next), 3, C2227d.f7442b);
            c4400d.m5249a(StatNativeCrashReport.m5276b(next));
            if (StatService.m5265c(this.f18481a) != null) {
                StatService.m5265c(this.f18481a).post(new RunnableC4433k(c4400d));
            }
            next.delete();
            statLogger = StatService.f18354i;
            statLogger.m5238d("delete tombstone file:" + next.getAbsolutePath().toString());
        }
    }
}
