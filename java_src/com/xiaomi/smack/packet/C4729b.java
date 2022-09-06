package com.xiaomi.smack.packet;

import android.os.Bundle;
import com.xiaomi.account.openauth.XiaomiOAuthConstants;
import com.xiaomi.smack.util.C4746d;
import java.util.HashMap;
import java.util.Map;
/* renamed from: com.xiaomi.smack.packet.b */
/* loaded from: classes.dex */
public class C4729b extends AbstractC4732d {

    /* renamed from: c */
    private C4730a f19417c;

    /* renamed from: d */
    private final Map<String, String> f19418d;

    /* renamed from: com.xiaomi.smack.packet.b$a */
    /* loaded from: classes2.dex */
    public static class C4730a {

        /* renamed from: a */
        public static final C4730a f19419a = new C4730a("get");

        /* renamed from: b */
        public static final C4730a f19420b = new C4730a("set");

        /* renamed from: c */
        public static final C4730a f19421c = new C4730a("result");

        /* renamed from: d */
        public static final C4730a f19422d = new C4730a(XiaomiOAuthConstants.EXTRA_ERROR_CODE_2);

        /* renamed from: e */
        public static final C4730a f19423e = new C4730a("command");

        /* renamed from: f */
        private String f19424f;

        private C4730a(String str) {
            this.f19424f = str;
        }

        /* renamed from: a */
        public static C4730a m3911a(String str) {
            if (str == null) {
                return null;
            }
            String lowerCase = str.toLowerCase();
            if (f19419a.toString().equals(lowerCase)) {
                return f19419a;
            }
            if (f19420b.toString().equals(lowerCase)) {
                return f19420b;
            }
            if (f19422d.toString().equals(lowerCase)) {
                return f19422d;
            }
            if (f19421c.toString().equals(lowerCase)) {
                return f19421c;
            }
            if (!f19423e.toString().equals(lowerCase)) {
                return null;
            }
            return f19423e;
        }

        public String toString() {
            return this.f19424f;
        }
    }

    public C4729b() {
        this.f19417c = C4730a.f19419a;
        this.f19418d = new HashMap();
    }

    public C4729b(Bundle bundle) {
        super(bundle);
        this.f19417c = C4730a.f19419a;
        this.f19418d = new HashMap();
        if (bundle.containsKey("ext_iq_type")) {
            this.f19417c = C4730a.m3911a(bundle.getString("ext_iq_type"));
        }
    }

    /* renamed from: a */
    public C4730a m3914a() {
        return this.f19417c;
    }

    /* renamed from: a */
    public void m3913a(C4730a c4730a) {
        if (c4730a == null) {
            this.f19417c = C4730a.f19419a;
        } else {
            this.f19417c = c4730a;
        }
    }

    /* renamed from: a */
    public synchronized void m3912a(Map<String, String> map) {
        this.f19418d.putAll(map);
    }

    @Override // com.xiaomi.smack.packet.AbstractC4732d
    /* renamed from: b */
    public Bundle mo3863b() {
        Bundle mo3863b = super.mo3863b();
        if (this.f19417c != null) {
            mo3863b.putString("ext_iq_type", this.f19417c.toString());
        }
        return mo3863b;
    }

    @Override // com.xiaomi.smack.packet.AbstractC4732d
    /* renamed from: c */
    public String mo3862c() {
        StringBuilder sb = new StringBuilder();
        sb.append("<iq ");
        if (k() != null) {
            sb.append("id=\"" + k() + "\" ");
        }
        if (m() != null) {
            sb.append("to=\"").append(C4746d.m3838a(m())).append("\" ");
        }
        if (n() != null) {
            sb.append("from=\"").append(C4746d.m3838a(n())).append("\" ");
        }
        if (l() != null) {
            sb.append("chid=\"").append(C4746d.m3838a(l())).append("\" ");
        }
        for (Map.Entry<String, String> entry : this.f19418d.entrySet()) {
            sb.append(C4746d.m3838a(entry.getKey())).append("=\"");
            sb.append(C4746d.m3838a(entry.getValue())).append("\" ");
        }
        if (this.f19417c == null) {
            sb.append("type=\"get\">");
        } else {
            sb.append("type=\"").append(m3914a()).append("\">");
        }
        String mo3841d = mo3841d();
        if (mo3841d != null) {
            sb.append(mo3841d);
        }
        sb.append(s());
        C4738h p = p();
        if (p != null) {
            sb.append(p.m3859b());
        }
        sb.append("</iq>");
        return sb.toString();
    }

    /* renamed from: d */
    public String mo3841d() {
        return null;
    }
}
