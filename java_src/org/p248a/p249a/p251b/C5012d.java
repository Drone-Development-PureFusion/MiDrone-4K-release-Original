package org.p248a.p249a.p251b;

import java.util.Queue;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.p248a.p249a.p250a.AbstractC5006c;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5006c
/* renamed from: org.a.a.b.d */
/* loaded from: classes.dex */
public class C5012d {

    /* renamed from: a */
    private EnumC5010b f21467a = EnumC5010b.UNCHALLENGED;

    /* renamed from: b */
    private AuthScheme f21468b;

    /* renamed from: c */
    private AuthScope f21469c;

    /* renamed from: d */
    private Credentials f21470d;

    /* renamed from: e */
    private Queue<C5009a> f21471e;

    /* renamed from: a */
    public void m2310a() {
        this.f21467a = EnumC5010b.UNCHALLENGED;
        this.f21471e = null;
        this.f21468b = null;
        this.f21469c = null;
        this.f21470d = null;
    }

    /* renamed from: a */
    public void m2309a(Queue<C5009a> queue) {
        C5351a.m1320a(queue, "Queue of auth options");
        this.f21471e = queue;
        this.f21468b = null;
        this.f21470d = null;
    }

    /* renamed from: a */
    public void m2308a(EnumC5010b enumC5010b) {
        if (enumC5010b == null) {
            enumC5010b = EnumC5010b.UNCHALLENGED;
        }
        this.f21467a = enumC5010b;
    }

    @Deprecated
    /* renamed from: a */
    public void m2307a(AuthScheme authScheme) {
        if (authScheme == null) {
            m2310a();
        } else {
            this.f21468b = authScheme;
        }
    }

    /* renamed from: a */
    public void m2306a(AuthScheme authScheme, Credentials credentials) {
        C5351a.m1321a(authScheme, "Auth scheme");
        C5351a.m1321a(credentials, "Credentials");
        this.f21468b = authScheme;
        this.f21470d = credentials;
        this.f21471e = null;
    }

    @Deprecated
    /* renamed from: a */
    public void m2305a(AuthScope authScope) {
        this.f21469c = authScope;
    }

    @Deprecated
    /* renamed from: a */
    public void m2304a(Credentials credentials) {
        this.f21470d = credentials;
    }

    /* renamed from: b */
    public EnumC5010b m2303b() {
        return this.f21467a;
    }

    /* renamed from: c */
    public AuthScheme m2302c() {
        return this.f21468b;
    }

    /* renamed from: d */
    public Credentials m2301d() {
        return this.f21470d;
    }

    /* renamed from: e */
    public Queue<C5009a> m2300e() {
        return this.f21471e;
    }

    /* renamed from: f */
    public boolean m2299f() {
        return this.f21471e != null && !this.f21471e.isEmpty();
    }

    @Deprecated
    /* renamed from: g */
    public void m2298g() {
        m2310a();
    }

    @Deprecated
    /* renamed from: h */
    public boolean m2297h() {
        return this.f21468b != null;
    }

    @Deprecated
    /* renamed from: i */
    public AuthScope m2296i() {
        return this.f21469c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("state:").append(this.f21467a).append(";");
        if (this.f21468b != null) {
            sb.append("auth scheme:").append(this.f21468b.getSchemeName()).append(";");
        }
        if (this.f21470d != null) {
            sb.append("credentials present");
        }
        return sb.toString();
    }
}
