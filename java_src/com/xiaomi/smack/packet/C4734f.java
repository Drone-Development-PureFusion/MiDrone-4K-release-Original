package com.xiaomi.smack.packet;

import android.os.Bundle;
import com.xiaomi.smack.util.C4746d;
/* renamed from: com.xiaomi.smack.packet.f */
/* loaded from: classes.dex */
public class C4734f extends AbstractC4732d {

    /* renamed from: c */
    private EnumC4736b f19452c;

    /* renamed from: d */
    private String f19453d;

    /* renamed from: e */
    private int f19454e;

    /* renamed from: f */
    private EnumC4735a f19455f;

    /* renamed from: com.xiaomi.smack.packet.f$a */
    /* loaded from: classes2.dex */
    public enum EnumC4735a {
        chat,
        available,
        away,
        xa,
        dnd
    }

    /* renamed from: com.xiaomi.smack.packet.f$b */
    /* loaded from: classes2.dex */
    public enum EnumC4736b {
        available,
        unavailable,
        subscribe,
        subscribed,
        unsubscribe,
        unsubscribed,
        error,
        probe
    }

    public C4734f(Bundle bundle) {
        super(bundle);
        this.f19452c = EnumC4736b.available;
        this.f19453d = null;
        this.f19454e = Integer.MIN_VALUE;
        this.f19455f = null;
        if (bundle.containsKey("ext_pres_type")) {
            this.f19452c = EnumC4736b.valueOf(bundle.getString("ext_pres_type"));
        }
        if (bundle.containsKey("ext_pres_status")) {
            this.f19453d = bundle.getString("ext_pres_status");
        }
        if (bundle.containsKey("ext_pres_prio")) {
            this.f19454e = bundle.getInt("ext_pres_prio");
        }
        if (bundle.containsKey("ext_pres_mode")) {
            this.f19455f = EnumC4735a.valueOf(bundle.getString("ext_pres_mode"));
        }
    }

    public C4734f(EnumC4736b enumC4736b) {
        this.f19452c = EnumC4736b.available;
        this.f19453d = null;
        this.f19454e = Integer.MIN_VALUE;
        this.f19455f = null;
        m3865a(enumC4736b);
    }

    /* renamed from: a */
    public void m3867a(int i) {
        if (i < -128 || i > 128) {
            throw new IllegalArgumentException("Priority value " + i + " is not valid. Valid range is -128 through 128.");
        }
        this.f19454e = i;
    }

    /* renamed from: a */
    public void m3866a(EnumC4735a enumC4735a) {
        this.f19455f = enumC4735a;
    }

    /* renamed from: a */
    public void m3865a(EnumC4736b enumC4736b) {
        if (enumC4736b == null) {
            throw new NullPointerException("Type cannot be null");
        }
        this.f19452c = enumC4736b;
    }

    /* renamed from: a */
    public void m3864a(String str) {
        this.f19453d = str;
    }

    @Override // com.xiaomi.smack.packet.AbstractC4732d
    /* renamed from: b */
    public Bundle mo3863b() {
        Bundle mo3863b = super.mo3863b();
        if (this.f19452c != null) {
            mo3863b.putString("ext_pres_type", this.f19452c.toString());
        }
        if (this.f19453d != null) {
            mo3863b.putString("ext_pres_status", this.f19453d);
        }
        if (this.f19454e != Integer.MIN_VALUE) {
            mo3863b.putInt("ext_pres_prio", this.f19454e);
        }
        if (this.f19455f != null && this.f19455f != EnumC4735a.available) {
            mo3863b.putString("ext_pres_mode", this.f19455f.toString());
        }
        return mo3863b;
    }

    @Override // com.xiaomi.smack.packet.AbstractC4732d
    /* renamed from: c */
    public String mo3862c() {
        StringBuilder sb = new StringBuilder();
        sb.append("<presence");
        if (t() != null) {
            sb.append(" xmlns=\"").append(t()).append("\"");
        }
        if (k() != null) {
            sb.append(" id=\"").append(k()).append("\"");
        }
        if (m() != null) {
            sb.append(" to=\"").append(C4746d.m3838a(m())).append("\"");
        }
        if (n() != null) {
            sb.append(" from=\"").append(C4746d.m3838a(n())).append("\"");
        }
        if (l() != null) {
            sb.append(" chid=\"").append(C4746d.m3838a(l())).append("\"");
        }
        if (this.f19452c != null) {
            sb.append(" type=\"").append(this.f19452c).append("\"");
        }
        sb.append(">");
        if (this.f19453d != null) {
            sb.append("<status>").append(C4746d.m3838a(this.f19453d)).append("</status>");
        }
        if (this.f19454e != Integer.MIN_VALUE) {
            sb.append("<priority>").append(this.f19454e).append("</priority>");
        }
        if (this.f19455f != null && this.f19455f != EnumC4735a.available) {
            sb.append("<show>").append(this.f19455f).append("</show>");
        }
        sb.append(s());
        C4738h p = p();
        if (p != null) {
            sb.append(p.m3859b());
        }
        sb.append("</presence>");
        return sb.toString();
    }
}
