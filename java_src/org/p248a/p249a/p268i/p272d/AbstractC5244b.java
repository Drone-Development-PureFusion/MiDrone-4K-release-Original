package org.p248a.p249a.p268i.p272d;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieSpec;
import org.p248a.p249a.p250a.AbstractC5006c;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5006c
/* renamed from: org.a.a.i.d.b */
/* loaded from: classes2.dex */
public abstract class AbstractC5244b implements CookieSpec {

    /* renamed from: a */
    private final Map<String, CookieAttributeHandler> f22135a = new HashMap(10);

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public Collection<CookieAttributeHandler> m1558a() {
        return this.f22135a.values();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public CookieAttributeHandler m1557a(String str) {
        return this.f22135a.get(str);
    }

    /* renamed from: a */
    public void m1556a(String str, CookieAttributeHandler cookieAttributeHandler) {
        C5351a.m1321a(str, "Attribute name");
        C5351a.m1321a(cookieAttributeHandler, "Attribute handler");
        this.f22135a.put(str, cookieAttributeHandler);
    }

    /* renamed from: b */
    protected CookieAttributeHandler m1555b(String str) {
        CookieAttributeHandler m1557a = m1557a(str);
        if (m1557a == null) {
            throw new IllegalStateException("Handler not registered for " + str + " attribute.");
        }
        return m1557a;
    }
}
