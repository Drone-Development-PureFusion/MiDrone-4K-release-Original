package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Bundle;
import com.amap.api.mapcore.util.AbstractC0858bw;
import com.amap.api.mapcore.util.C0848br;
import com.amap.api.maps.AMap;
import java.io.IOException;
/* renamed from: com.amap.api.mapcore.util.bc */
/* loaded from: classes.dex */
public class C0832bc extends AbstractRunnableC1086hm implements C0848br.AbstractC0849a {

    /* renamed from: a */
    private C0848br f2327a;

    /* renamed from: b */
    private C0851bt f2328b;

    /* renamed from: c */
    private AbstractC0857bv f2329c;

    /* renamed from: e */
    private Context f2330e;

    /* renamed from: f */
    private Bundle f2331f;

    /* renamed from: g */
    private AMap f2332g;

    /* renamed from: h */
    private boolean f2333h;

    public C0832bc(AbstractC0857bv abstractC0857bv, Context context) {
        this.f2331f = new Bundle();
        this.f2333h = false;
        this.f2329c = abstractC0857bv;
        this.f2330e = context;
    }

    public C0832bc(AbstractC0857bv abstractC0857bv, Context context, AMap aMap) {
        this(abstractC0857bv, context);
        this.f2332g = aMap;
    }

    /* renamed from: f */
    private String m18855f() {
        return C0945eh.m18318b(this.f2330e);
    }

    /* renamed from: g */
    private void m18854g() {
        this.f2327a = new C0848br(new C0850bs(this.f2329c.getUrl(), m18855f(), this.f2329c.mo18739z(), 1, this.f2329c.mo18741A()), this.f2329c.getUrl(), this.f2330e, this.f2329c);
        this.f2327a.m18789a(this);
        this.f2328b = new C0851bt(this.f2329c, this.f2329c);
        if (!this.f2333h) {
            this.f2327a.m18792a();
        }
    }

    @Override // com.amap.api.mapcore.util.AbstractRunnableC1086hm
    /* renamed from: a */
    public void mo17658a() {
        if (this.f2329c.mo18740y()) {
            this.f2329c.a(AbstractC0858bw.EnumC0859a.file_io_exception);
            return;
        }
        try {
            m18854g();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public void m18857b() {
        this.f2333h = true;
        if (this.f2327a != null) {
            this.f2327a.m18787c();
        } else {
            e();
        }
        if (this.f2328b != null) {
            this.f2328b.m18774a();
        }
    }

    /* renamed from: c */
    public void m18856c() {
        this.f2332g = null;
        if (this.f2331f != null) {
            this.f2331f.clear();
            this.f2331f = null;
        }
    }

    @Override // com.amap.api.mapcore.util.C0848br.AbstractC0849a
    /* renamed from: d */
    public void mo18780d() {
        if (this.f2328b != null) {
            this.f2328b.m18767b();
        }
    }
}
