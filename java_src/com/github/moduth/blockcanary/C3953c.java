package com.github.moduth.blockcanary;

import android.os.Looper;
import com.github.moduth.blockcanary.p215b.C3947a;
import java.util.ArrayList;
/* renamed from: com.github.moduth.blockcanary.c */
/* loaded from: classes.dex */
public class C3953c {

    /* renamed from: d */
    private static C3953c f16942d;

    /* renamed from: e */
    private static AbstractC3963h f16943e;

    /* renamed from: a */
    public C3967k f16944a;

    /* renamed from: b */
    public C3972n f16945b = new C3972n(Looper.getMainLooper().getThread(), f16943e.mo6360k());

    /* renamed from: c */
    public C3960f f16946c = new C3960f(f16943e.mo6360k());

    /* renamed from: f */
    private AbstractC3969l f16947f;

    public C3953c() {
        m6382a(new C3967k(new AbstractC3958d() { // from class: com.github.moduth.blockcanary.c.1
            @Override // com.github.moduth.blockcanary.AbstractC3958d
            /* renamed from: a */
            public void mo6378a(long j, long j2, long j3, long j4) {
                ArrayList<String> m6345a = C3953c.this.f16945b.m6345a(j, j2);
                if (!m6345a.isEmpty()) {
                    C3947a m6398b = C3947a.m6404a().m6403a(j, j2, j3, j4).m6399a(C3953c.this.f16946c.m6377a(j, j2)).m6401a(C3953c.this.f16946c.m6375b()).m6400a(m6345a).m6398b();
                    C3965j.m6358a(m6398b.toString());
                    if (!C3953c.m6380b().mo6367b() || C3953c.this.f16947f == null) {
                        return;
                    }
                    C3953c.this.f16947f.mo6311a(C3953c.m6380b().mo6365e(), m6398b.f16922K);
                }
            }
        }, m6380b().mo6370a()));
        C3965j.m6359a();
    }

    /* renamed from: a */
    public static C3953c m6385a() {
        if (f16942d == null) {
            synchronized (C3953c.class) {
                if (f16942d == null) {
                    f16942d = new C3953c();
                }
            }
        }
        return f16942d;
    }

    /* renamed from: a */
    public static void m6383a(AbstractC3963h abstractC3963h) {
        f16943e = abstractC3963h;
    }

    /* renamed from: b */
    public static AbstractC3963h m6380b() {
        return f16943e;
    }

    /* renamed from: a */
    public void m6382a(C3967k c3967k) {
        this.f16944a = c3967k;
    }

    /* renamed from: a */
    public void m6381a(AbstractC3969l abstractC3969l) {
        this.f16947f = abstractC3969l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public long m6379c() {
        return m6380b().mo6370a() * 0.8f;
    }
}
