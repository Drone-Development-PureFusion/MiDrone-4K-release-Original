package com.p080b;

import android.text.TextUtils;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.autonavi.aps.amapapi.model.AmapLoc;
/* renamed from: com.b.aw */
/* loaded from: classes.dex */
public class C1444aw {

    /* renamed from: a */
    private static C1444aw f5008a = null;

    /* renamed from: b */
    private AmapLoc f5009b = null;

    /* renamed from: c */
    private long f5010c = 0;

    /* renamed from: d */
    private long f5011d = 0;

    private C1444aw() {
    }

    /* renamed from: a */
    public static synchronized C1444aw m16218a() {
        C1444aw c1444aw;
        synchronized (C1444aw.class) {
            if (f5008a == null) {
                f5008a = new C1444aw();
            }
            c1444aw = f5008a;
        }
        return c1444aw;
    }

    /* renamed from: c */
    private AmapLoc m16214c(AmapLoc amapLoc) {
        if (C1477bs.m16006a(amapLoc) && (amapLoc.m16541b() == 5 || amapLoc.m16541b() == 6)) {
            amapLoc.m16546a(2);
        }
        return amapLoc;
    }

    /* renamed from: a */
    public synchronized AmapLoc m16217a(AmapLoc amapLoc) {
        if (!C1477bs.m16006a(this.f5009b) || !C1477bs.m16006a(amapLoc)) {
            this.f5010c = C1477bs.m15997b();
            this.f5009b = amapLoc;
            amapLoc = this.f5009b;
        } else if (amapLoc.m16516k() != this.f5009b.m16516k() || amapLoc.m16518j() >= 300.0f) {
            if (amapLoc.m16524g().equals(GeocodeSearch.GPS)) {
                this.f5010c = C1477bs.m15997b();
                this.f5009b = amapLoc;
                amapLoc = this.f5009b;
            } else if (amapLoc.m16555B() != this.f5009b.m16555B()) {
                this.f5010c = C1477bs.m15997b();
                this.f5009b = amapLoc;
                amapLoc = this.f5009b;
            } else if (amapLoc.m16557A().equals(this.f5009b.m16557A()) || TextUtils.isEmpty(amapLoc.m16557A())) {
                float m16005a = C1477bs.m16005a(amapLoc, this.f5009b);
                float m16518j = this.f5009b.m16518j();
                float m16518j2 = amapLoc.m16518j();
                float f = m16518j2 - m16518j;
                long m15997b = C1477bs.m15997b();
                long j = m15997b - this.f5010c;
                if ((m16518j < 101.0f && m16518j2 > 299.0f) || (m16518j > 299.0f && m16518j2 > 299.0f)) {
                    if (this.f5011d == 0) {
                        this.f5011d = m15997b;
                    } else if (m15997b - this.f5011d > 30000) {
                        this.f5010c = m15997b;
                        this.f5009b = amapLoc;
                        this.f5011d = 0L;
                        amapLoc = this.f5009b;
                    }
                    this.f5009b = m16214c(this.f5009b);
                    amapLoc = this.f5009b;
                } else if (m16518j2 >= 100.0f || m16518j <= 299.0f) {
                    if (m16518j2 <= 299.0f) {
                        this.f5011d = 0L;
                    }
                    if (m16005a >= 10.0f || m16005a <= 0.1d) {
                        if (f < 300.0f) {
                            this.f5010c = C1477bs.m15997b();
                            this.f5009b = amapLoc;
                            amapLoc = this.f5009b;
                        } else if (j >= 30000) {
                            this.f5010c = C1477bs.m15997b();
                            this.f5009b = amapLoc;
                            amapLoc = this.f5009b;
                        } else {
                            this.f5009b = m16214c(this.f5009b);
                            amapLoc = this.f5009b;
                        }
                    } else if (f >= -300.0f) {
                        this.f5009b = m16214c(this.f5009b);
                        amapLoc = this.f5009b;
                    } else if (m16518j / m16518j2 >= 2.0f) {
                        this.f5010c = m15997b;
                        this.f5009b = amapLoc;
                        amapLoc = this.f5009b;
                    } else {
                        this.f5009b = m16214c(this.f5009b);
                        amapLoc = this.f5009b;
                    }
                } else {
                    this.f5010c = m15997b;
                    this.f5009b = amapLoc;
                    this.f5011d = 0L;
                    amapLoc = this.f5009b;
                }
            } else {
                this.f5010c = C1477bs.m15997b();
                this.f5009b = amapLoc;
                amapLoc = this.f5009b;
            }
        }
        return amapLoc;
    }

    /* renamed from: b */
    public AmapLoc m16215b(AmapLoc amapLoc) {
        return amapLoc;
    }

    /* renamed from: b */
    public synchronized void m16216b() {
        this.f5009b = null;
        this.f5010c = 0L;
        this.f5011d = 0L;
    }
}
