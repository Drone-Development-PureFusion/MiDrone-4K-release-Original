package org.p248a.p249a.p268i.p270b;

import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.HttpRequest;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p252c.p255c.C5041h;
import org.p248a.p249a.p252c.p255c.C5042i;
import org.p248a.p249a.p252c.p255c.C5045l;
import org.p248a.p249a.p252c.p255c.C5050o;
@AbstractC5005b
/* renamed from: org.a.a.i.b.ae */
/* loaded from: classes2.dex */
public class C5173ae extends C5187l {

    /* renamed from: b */
    private final Map<String, Boolean> f21939b;

    public C5173ae() {
        this(3, false);
    }

    public C5173ae(int i, boolean z) {
        super(i, z);
        this.f21939b = new ConcurrentHashMap();
        this.f21939b.put("GET", Boolean.TRUE);
        this.f21939b.put(C5041h.f21543a, Boolean.TRUE);
        this.f21939b.put(C5045l.f21547a, Boolean.TRUE);
        this.f21939b.put("DELETE", Boolean.TRUE);
        this.f21939b.put(C5042i.f21544a, Boolean.TRUE);
        this.f21939b.put(C5050o.f21556a, Boolean.TRUE);
    }

    @Override // org.p248a.p249a.p268i.p270b.C5187l
    /* renamed from: a */
    protected boolean mo1760a(HttpRequest httpRequest) {
        Boolean bool = this.f21939b.get(httpRequest.getRequestLine().getMethod().toUpperCase(Locale.ENGLISH));
        return bool != null && bool.booleanValue();
    }
}
