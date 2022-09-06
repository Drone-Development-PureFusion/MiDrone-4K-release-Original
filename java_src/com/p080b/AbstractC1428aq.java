package com.p080b;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.Proxy;
import java.util.Map;
import p004b.p005a.p006a.p007a.p025n.C0228a;
/* renamed from: com.b.aq */
/* loaded from: classes.dex */
public abstract class AbstractC1428aq {

    /* renamed from: a */
    int f4903a = 20000;

    /* renamed from: b */
    int f4904b = 20000;

    /* renamed from: c */
    Proxy f4905c = null;

    /* renamed from: a */
    public abstract Map<String, String> mo15505a();

    /* renamed from: a */
    public final void m16329a(int i) {
        this.f4903a = i;
    }

    /* renamed from: a */
    public final void m16328a(Proxy proxy) {
        this.f4905c = proxy;
    }

    /* renamed from: b */
    public abstract Map<String, String> mo15504b();

    /* renamed from: b */
    public final void m16327b(int i) {
        this.f4904b = i;
    }

    /* renamed from: c */
    public abstract String mo15503c();

    /* renamed from: d */
    public byte[] mo15502d() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public String m16326e() {
        byte[] mo15502d = mo15502d();
        if (mo15502d == null || mo15502d.length == 0) {
            return mo15503c();
        }
        Map<String, String> mo15504b = mo15504b();
        if (mo15504b == null) {
            return mo15503c();
        }
        String m16332a = C1425ao.m16332a(mo15504b);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(mo15503c()).append(C0228a.f351a).append(m16332a);
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public byte[] m16325f() {
        byte[] mo15502d = mo15502d();
        if (mo15502d == null || mo15502d.length == 0) {
            String m16332a = C1425ao.m16332a(mo15504b());
            try {
                return !TextUtils.isEmpty(m16332a) ? m16332a.getBytes("UTF-8") : mo15502d;
            } catch (UnsupportedEncodingException e) {
                byte[] bytes = m16332a.getBytes();
                C1450b.m16187a(e, "Request", "getConnectionDatas");
                return bytes;
            }
        }
        return mo15502d;
    }
}
