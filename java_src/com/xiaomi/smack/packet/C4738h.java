package com.xiaomi.smack.packet;

import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* renamed from: com.xiaomi.smack.packet.h */
/* loaded from: classes2.dex */
public class C4738h {

    /* renamed from: a */
    private int f19472a;

    /* renamed from: b */
    private String f19473b;

    /* renamed from: c */
    private String f19474c;

    /* renamed from: d */
    private String f19475d;

    /* renamed from: e */
    private String f19476e;

    /* renamed from: f */
    private List<C4728a> f19477f;

    /* renamed from: com.xiaomi.smack.packet.h$a */
    /* loaded from: classes2.dex */
    public static class C4739a {

        /* renamed from: a */
        public static final C4739a f19478a = new C4739a("internal-server-error");

        /* renamed from: b */
        public static final C4739a f19479b = new C4739a("forbidden");

        /* renamed from: c */
        public static final C4739a f19480c = new C4739a("bad-request");

        /* renamed from: d */
        public static final C4739a f19481d = new C4739a("conflict");

        /* renamed from: e */
        public static final C4739a f19482e = new C4739a("feature-not-implemented");

        /* renamed from: f */
        public static final C4739a f19483f = new C4739a("gone");

        /* renamed from: g */
        public static final C4739a f19484g = new C4739a("item-not-found");

        /* renamed from: h */
        public static final C4739a f19485h = new C4739a("jid-malformed");

        /* renamed from: i */
        public static final C4739a f19486i = new C4739a("not-acceptable");

        /* renamed from: j */
        public static final C4739a f19487j = new C4739a("not-allowed");

        /* renamed from: k */
        public static final C4739a f19488k = new C4739a("not-authorized");

        /* renamed from: l */
        public static final C4739a f19489l = new C4739a("payment-required");

        /* renamed from: m */
        public static final C4739a f19490m = new C4739a("recipient-unavailable");

        /* renamed from: n */
        public static final C4739a f19491n = new C4739a("redirect");

        /* renamed from: o */
        public static final C4739a f19492o = new C4739a("registration-required");

        /* renamed from: p */
        public static final C4739a f19493p = new C4739a("remote-server-error");

        /* renamed from: q */
        public static final C4739a f19494q = new C4739a("remote-server-not-found");

        /* renamed from: r */
        public static final C4739a f19495r = new C4739a("remote-server-timeout");

        /* renamed from: s */
        public static final C4739a f19496s = new C4739a("resource-constraint");

        /* renamed from: t */
        public static final C4739a f19497t = new C4739a("service-unavailable");

        /* renamed from: u */
        public static final C4739a f19498u = new C4739a("subscription-required");

        /* renamed from: v */
        public static final C4739a f19499v = new C4739a("undefined-condition");

        /* renamed from: w */
        public static final C4739a f19500w = new C4739a("unexpected-request");

        /* renamed from: x */
        public static final C4739a f19501x = new C4739a("request-timeout");

        /* renamed from: y */
        private String f19502y;

        public C4739a(String str) {
            this.f19502y = str;
        }

        public String toString() {
            return this.f19502y;
        }
    }

    public C4738h(int i, String str, String str2, String str3, String str4, List<C4728a> list) {
        this.f19477f = null;
        this.f19472a = i;
        this.f19473b = str;
        this.f19475d = str2;
        this.f19474c = str3;
        this.f19476e = str4;
        this.f19477f = list;
    }

    public C4738h(Bundle bundle) {
        this.f19477f = null;
        this.f19472a = bundle.getInt("ext_err_code");
        if (bundle.containsKey("ext_err_type")) {
            this.f19473b = bundle.getString("ext_err_type");
        }
        this.f19474c = bundle.getString("ext_err_cond");
        this.f19475d = bundle.getString("ext_err_reason");
        this.f19476e = bundle.getString("ext_err_msg");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.f19477f = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                C4728a m3923a = C4728a.m3923a((Bundle) parcelable);
                if (m3923a != null) {
                    this.f19477f.add(m3923a);
                }
            }
        }
    }

    public C4738h(C4739a c4739a) {
        this.f19477f = null;
        m3860a(c4739a);
        this.f19476e = null;
    }

    /* renamed from: a */
    private void m3860a(C4739a c4739a) {
        this.f19474c = c4739a.f19502y;
    }

    /* renamed from: a */
    public Bundle m3861a() {
        Bundle bundle = new Bundle();
        if (this.f19473b != null) {
            bundle.putString("ext_err_type", this.f19473b);
        }
        bundle.putInt("ext_err_code", this.f19472a);
        if (this.f19475d != null) {
            bundle.putString("ext_err_reason", this.f19475d);
        }
        if (this.f19474c != null) {
            bundle.putString("ext_err_cond", this.f19474c);
        }
        if (this.f19476e != null) {
            bundle.putString("ext_err_msg", this.f19476e);
        }
        if (this.f19477f != null) {
            Bundle[] bundleArr = new Bundle[this.f19477f.size()];
            int i = 0;
            Iterator<C4728a> it2 = this.f19477f.iterator();
            while (true) {
                int i2 = i;
                if (!it2.hasNext()) {
                    break;
                }
                Bundle m3916e = it2.next().m3916e();
                if (m3916e != null) {
                    i = i2 + 1;
                    bundleArr[i2] = m3916e;
                } else {
                    i = i2;
                }
            }
            bundle.putParcelableArray("ext_exts", bundleArr);
        }
        return bundle;
    }

    /* renamed from: b */
    public String m3859b() {
        StringBuilder sb = new StringBuilder();
        sb.append("<error code=\"").append(this.f19472a).append("\"");
        if (this.f19473b != null) {
            sb.append(" type=\"");
            sb.append(this.f19473b);
            sb.append("\"");
        }
        if (this.f19475d != null) {
            sb.append(" reason=\"");
            sb.append(this.f19475d);
            sb.append("\"");
        }
        sb.append(">");
        if (this.f19474c != null) {
            sb.append("<").append(this.f19474c);
            sb.append(" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\"/>");
        }
        if (this.f19476e != null) {
            sb.append("<text xml:lang=\"en\" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\">");
            sb.append(this.f19476e);
            sb.append("</text>");
        }
        for (C4728a c4728a : m3858c()) {
            sb.append(c4728a.mo3868d());
        }
        sb.append("</error>");
        return sb.toString();
    }

    /* renamed from: c */
    public synchronized List<C4728a> m3858c() {
        return this.f19477f == null ? Collections.emptyList() : Collections.unmodifiableList(this.f19477f);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f19474c != null) {
            sb.append(this.f19474c);
        }
        sb.append("(").append(this.f19472a).append(")");
        if (this.f19476e != null) {
            sb.append(" ").append(this.f19476e);
        }
        return sb.toString();
    }
}
