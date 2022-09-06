package org.p318d.p320b;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.p318d.AbstractC5727b;
import org.p318d.AbstractC5756f;
/* renamed from: org.d.b.c */
/* loaded from: classes2.dex */
public class C5731c implements AbstractC5727b {

    /* renamed from: a */
    private final ConcurrentMap<String, AbstractC5756f> f22996a = new ConcurrentHashMap();

    @Override // org.p318d.AbstractC5727b
    /* renamed from: a */
    public AbstractC5756f mo164a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Marker name cannot be null");
        }
        AbstractC5756f abstractC5756f = this.f22996a.get(str);
        if (abstractC5756f != null) {
            return abstractC5756f;
        }
        C5730b c5730b = new C5730b(str);
        AbstractC5756f putIfAbsent = this.f22996a.putIfAbsent(str, c5730b);
        return putIfAbsent != null ? putIfAbsent : c5730b;
    }

    @Override // org.p318d.AbstractC5727b
    /* renamed from: b */
    public boolean mo163b(String str) {
        if (str == null) {
            return false;
        }
        return this.f22996a.containsKey(str);
    }

    @Override // org.p318d.AbstractC5727b
    /* renamed from: c */
    public boolean mo162c(String str) {
        return (str == null || this.f22996a.remove(str) == null) ? false : true;
    }

    @Override // org.p318d.AbstractC5727b
    /* renamed from: d */
    public AbstractC5756f mo161d(String str) {
        return new C5730b(str);
    }
}
