package org.p318d.p320b;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import org.p318d.AbstractC5721a;
import org.p318d.AbstractC5744c;
import org.p318d.p319a.C5726e;
/* renamed from: org.d.b.l */
/* loaded from: classes2.dex */
public class C5740l implements AbstractC5721a {

    /* renamed from: a */
    boolean f23014a = false;

    /* renamed from: b */
    final Map<String, C5739k> f23015b = new HashMap();

    /* renamed from: c */
    final LinkedBlockingQueue<C5726e> f23016c = new LinkedBlockingQueue<>();

    /* renamed from: a */
    public List<String> m131a() {
        return new ArrayList(this.f23015b.keySet());
    }

    /* renamed from: b */
    public List<C5739k> m130b() {
        return new ArrayList(this.f23015b.values());
    }

    /* renamed from: c */
    public LinkedBlockingQueue<C5726e> m129c() {
        return this.f23016c;
    }

    /* renamed from: d */
    public void m128d() {
        this.f23014a = true;
    }

    @Override // org.p318d.AbstractC5721a
    /* renamed from: e */
    public synchronized AbstractC5744c mo126e(String str) {
        C5739k c5739k;
        c5739k = this.f23015b.get(str);
        if (c5739k == null) {
            c5739k = new C5739k(str, this.f23016c, this.f23014a);
            this.f23015b.put(str, c5739k);
        }
        return c5739k;
    }

    /* renamed from: e */
    public void m127e() {
        this.f23015b.clear();
        this.f23016c.clear();
    }
}
