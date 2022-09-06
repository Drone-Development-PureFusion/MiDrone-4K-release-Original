package org.p248a.p249a.p251b;

import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.Credentials;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5005b
/* renamed from: org.a.a.b.a */
/* loaded from: classes2.dex */
public final class C5009a {

    /* renamed from: a */
    private final AuthScheme f21459a;

    /* renamed from: b */
    private final Credentials f21460b;

    public C5009a(AuthScheme authScheme, Credentials credentials) {
        C5351a.m1321a(authScheme, "Auth scheme");
        C5351a.m1321a(credentials, "User credentials");
        this.f21459a = authScheme;
        this.f21460b = credentials;
    }

    /* renamed from: a */
    public AuthScheme m2312a() {
        return this.f21459a;
    }

    /* renamed from: b */
    public Credentials m2311b() {
        return this.f21460b;
    }

    public String toString() {
        return this.f21459a.toString();
    }
}
