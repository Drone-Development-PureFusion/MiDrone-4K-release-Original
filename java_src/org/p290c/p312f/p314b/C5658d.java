package org.p290c.p312f.p314b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.p290c.p312f.p313a.C5648k;
/* renamed from: org.c.f.b.d */
/* loaded from: classes.dex */
public class C5658d {

    /* renamed from: a */
    private final String f22762a;

    /* renamed from: b */
    private final C5648k f22763b;

    /* renamed from: c */
    private final List<Object> f22764c;

    public C5658d(String str, C5648k c5648k, List<Object> list) {
        m363a(str, "The name is missing.");
        m363a(c5648k, "The test class is missing.");
        m363a(list, "The parameters are missing.");
        this.f22762a = str;
        this.f22763b = c5648k;
        this.f22764c = Collections.unmodifiableList(new ArrayList(list));
    }

    /* renamed from: a */
    private static void m363a(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    /* renamed from: a */
    public String m364a() {
        return this.f22762a;
    }

    /* renamed from: b */
    public C5648k m362b() {
        return this.f22763b;
    }

    /* renamed from: c */
    public List<Object> m361c() {
        return this.f22764c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            C5658d c5658d = (C5658d) obj;
            return this.f22762a.equals(c5658d.f22762a) && this.f22764c.equals(c5658d.f22764c) && this.f22763b.equals(c5658d.f22763b);
        }
        return false;
    }

    public int hashCode() {
        return (14747 * (((this.f22762a.hashCode() + 14747) * 14747) + this.f22763b.hashCode())) + this.f22764c.hashCode();
    }

    public String toString() {
        return this.f22763b.m410e() + " '" + this.f22762a + "' with parameters " + this.f22764c;
    }
}
