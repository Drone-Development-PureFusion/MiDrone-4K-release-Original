package org.p290c.p291a;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.p290c.p309e.AbstractC5634l;
import org.p290c.p309e.C5593a;
import org.p290c.p312f.AbstractC5665f;
import org.p290c.p312f.p313a.AbstractC5645h;
import org.p290c.p312f.p313a.AbstractC5646i;
/* renamed from: org.c.a.a */
/* loaded from: classes2.dex */
public class C5437a extends C5593a {

    /* renamed from: a */
    private final boolean f22509a;

    /* renamed from: b */
    private final boolean f22510b;

    public C5437a(boolean z, boolean z2) {
        this.f22509a = z;
        this.f22510b = z2;
    }

    /* renamed from: a */
    public static C5593a m1069a() {
        return new C5437a(true, false);
    }

    /* renamed from: a */
    private static AbstractC5634l m1068a(AbstractC5634l abstractC5634l) {
        if (abstractC5634l instanceof AbstractC5665f) {
            ((AbstractC5665f) abstractC5634l).m340a(new AbstractC5646i() { // from class: org.c.a.a.1

                /* renamed from: a */
                private final ExecutorService f22511a = Executors.newCachedThreadPool();

                @Override // org.p290c.p312f.p313a.AbstractC5646i
                /* renamed from: a */
                public void mo320a() {
                    try {
                        this.f22511a.shutdown();
                        this.f22511a.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
                    } catch (InterruptedException e) {
                        e.printStackTrace(System.err);
                    }
                }

                @Override // org.p290c.p312f.p313a.AbstractC5646i
                /* renamed from: a */
                public void mo319a(Runnable runnable) {
                    this.f22511a.submit(runnable);
                }
            });
        }
        return abstractC5634l;
    }

    /* renamed from: b */
    public static C5593a m1067b() {
        return new C5437a(false, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.p290c.p309e.C5593a
    /* renamed from: a */
    public AbstractC5634l mo586a(AbstractC5645h abstractC5645h, Class<?> cls) {
        AbstractC5634l mo586a = super.mo586a(abstractC5645h, cls);
        return this.f22510b ? m1068a(mo586a) : mo586a;
    }

    @Override // org.p290c.p309e.C5593a
    /* renamed from: a */
    public AbstractC5634l mo585a(AbstractC5645h abstractC5645h, Class<?>[] clsArr) {
        AbstractC5634l mo585a = super.mo585a(abstractC5645h, clsArr);
        return this.f22509a ? m1068a(mo585a) : mo585a;
    }
}
