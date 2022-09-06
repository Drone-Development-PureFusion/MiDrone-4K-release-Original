package org.p248a.p249a.p281n;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.protocol.HttpContext;
import org.p248a.p249a.p250a.AbstractC5007d;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5007d
/* renamed from: org.a.a.n.a */
/* loaded from: classes2.dex */
public class C5339a implements HttpContext {

    /* renamed from: a */
    private final HttpContext f22379a;

    /* renamed from: b */
    private final Map<String, Object> f22380b;

    public C5339a() {
        this(null);
    }

    public C5339a(HttpContext httpContext) {
        this.f22380b = new ConcurrentHashMap();
        this.f22379a = httpContext;
    }

    /* renamed from: a */
    public void m1360a() {
        this.f22380b.clear();
    }

    public Object getAttribute(String str) {
        C5351a.m1321a(str, "Id");
        Object obj = this.f22380b.get(str);
        return (obj != null || this.f22379a == null) ? obj : this.f22379a.getAttribute(str);
    }

    public Object removeAttribute(String str) {
        C5351a.m1321a(str, "Id");
        return this.f22380b.remove(str);
    }

    public void setAttribute(String str, Object obj) {
        C5351a.m1321a(str, "Id");
        if (obj != null) {
            this.f22380b.put(str, obj);
        } else {
            this.f22380b.remove(str);
        }
    }

    public String toString() {
        return this.f22380b.toString();
    }
}
