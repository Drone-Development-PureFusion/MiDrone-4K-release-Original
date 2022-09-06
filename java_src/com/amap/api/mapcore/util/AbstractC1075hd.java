package com.amap.api.mapcore.util;

import android.text.TextUtils;
import java.net.Proxy;
import java.util.Map;
import p004b.p005a.p006a.p007a.p025n.C0228a;
/* renamed from: com.amap.api.mapcore.util.hd */
/* loaded from: classes.dex */
public abstract class AbstractC1075hd {

    /* renamed from: f */
    int f3367f = 20000;

    /* renamed from: g */
    int f3368g = 20000;

    /* renamed from: h */
    Proxy f3369h = null;

    /* renamed from: a */
    public abstract Map<String, String> mo17702a();

    /* renamed from: a */
    public final void m17701a(int i) {
        this.f3367f = i;
    }

    /* renamed from: a */
    public final void m17700a(Proxy proxy) {
        this.f3369h = proxy;
    }

    /* renamed from: b */
    public abstract Map<String, String> mo17699b();

    /* renamed from: b */
    public final void m17698b(int i) {
        this.f3368g = i;
    }

    /* renamed from: c */
    public abstract String mo17697c();

    /* renamed from: g */
    public byte[] mo17696g() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k */
    public String m17695k() {
        byte[] mo17696g = mo17696g();
        if (mo17696g == null || mo17696g.length == 0) {
            return mo17697c();
        }
        Map<String, String> mo17699b = mo17699b();
        if (mo17699b == null) {
            return mo17697c();
        }
        String m17716a = C1069ha.m17716a(mo17699b);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(mo17697c()).append(C0228a.f351a).append(m17716a);
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: l */
    public byte[] m17694l() {
        byte[] mo17696g = mo17696g();
        if (mo17696g == null || mo17696g.length == 0) {
            String m17716a = C1069ha.m17716a(mo17699b());
            return !TextUtils.isEmpty(m17716a) ? C0999fi.m18047a(m17716a) : mo17696g;
        }
        return mo17696g;
    }
}
