package com.amap.api.mapcore.util;

import android.content.Context;
import java.util.List;
/* renamed from: com.amap.api.mapcore.util.ge */
/* loaded from: classes.dex */
public class C1027ge {

    /* renamed from: a */
    private C1016fu f3210a;

    /* renamed from: b */
    private Context f3211b;

    public C1027ge(Context context, boolean z) {
        this.f3211b = context;
        this.f3210a = m17930a(this.f3211b, z);
    }

    /* renamed from: a */
    private C1016fu m17930a(Context context, boolean z) {
        try {
            return new C1016fu(context, C1016fu.m17968a((Class<? extends AbstractC1015ft>) C1024gb.class));
        } catch (Throwable th) {
            if (!z) {
                C1002fl.m18028a(th, "SDKDB", "getDB");
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public List<C0996fh> m17931a() {
        try {
            return this.f3210a.m17960a(C0996fh.m18064g(), C0996fh.class, true);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public void m17929a(C0996fh c0996fh) {
        if (c0996fh == null) {
            return;
        }
        try {
            if (this.f3210a == null) {
                this.f3210a = m17930a(this.f3211b, false);
            }
            String m18073a = C0996fh.m18073a(c0996fh.m18074a());
            List m17952b = this.f3210a.m17952b(m18073a, C0996fh.class);
            if (m17952b == null || m17952b.size() == 0) {
                this.f3210a.m17966a((C1016fu) c0996fh);
            } else {
                this.f3210a.m17959a(m18073a, c0996fh);
            }
        } catch (Throwable th) {
            C1002fl.m18028a(th, "SDKDB", "insert");
            th.printStackTrace();
        }
    }
}
