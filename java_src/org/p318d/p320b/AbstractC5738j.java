package org.p318d.p320b;

import java.io.Serializable;
import org.p318d.AbstractC5744c;
import org.p318d.C5748d;
/* renamed from: org.d.b.j */
/* loaded from: classes2.dex */
abstract class AbstractC5738j implements Serializable, AbstractC5744c {
    private static final long serialVersionUID = 7535258609338176893L;

    /* renamed from: b */
    protected String f23006b;

    /* renamed from: d */
    public String mo88d() {
        return this.f23006b;
    }

    protected Object readResolve() {
        return C5748d.m48a(mo88d());
    }
}
