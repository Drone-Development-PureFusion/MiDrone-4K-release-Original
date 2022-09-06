package org.p248a.p249a.p268i.p270b;

import java.util.HashMap;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScheme;
import org.p248a.p249a.p250a.AbstractC5006c;
import org.p248a.p249a.p252c.AbstractC5016a;
import org.p248a.p249a.p261f.AbstractC5131i;
import org.p248a.p249a.p261f.C5132j;
import org.p248a.p249a.p268i.p271c.C5218k;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5006c
/* renamed from: org.a.a.i.b.c */
/* loaded from: classes2.dex */
public class C5178c implements AbstractC5016a {

    /* renamed from: a */
    private final HashMap<HttpHost, AuthScheme> f21947a;

    /* renamed from: b */
    private final AbstractC5131i f21948b;

    public C5178c() {
        this(null);
    }

    public C5178c(AbstractC5131i abstractC5131i) {
        this.f21947a = new HashMap<>();
        this.f21948b = abstractC5131i == null ? C5218k.f22086a : abstractC5131i;
    }

    @Override // org.p248a.p249a.p252c.AbstractC5016a
    /* renamed from: a */
    public AuthScheme mo1778a(HttpHost httpHost) {
        C5351a.m1321a(httpHost, "HTTP host");
        return this.f21947a.get(m1775c(httpHost));
    }

    @Override // org.p248a.p249a.p252c.AbstractC5016a
    /* renamed from: a */
    public void mo1779a() {
        this.f21947a.clear();
    }

    @Override // org.p248a.p249a.p252c.AbstractC5016a
    /* renamed from: a */
    public void mo1777a(HttpHost httpHost, AuthScheme authScheme) {
        C5351a.m1321a(httpHost, "HTTP host");
        this.f21947a.put(m1775c(httpHost), authScheme);
    }

    @Override // org.p248a.p249a.p252c.AbstractC5016a
    /* renamed from: b */
    public void mo1776b(HttpHost httpHost) {
        C5351a.m1321a(httpHost, "HTTP host");
        this.f21947a.remove(m1775c(httpHost));
    }

    /* renamed from: c */
    protected HttpHost m1775c(HttpHost httpHost) {
        if (httpHost.getPort() <= 0) {
            try {
                return new HttpHost(httpHost.getHostName(), this.f21948b.mo1630a(httpHost), httpHost.getSchemeName());
            } catch (C5132j e) {
                return httpHost;
            }
        }
        return httpHost;
    }

    public String toString() {
        return this.f21947a.toString();
    }
}
