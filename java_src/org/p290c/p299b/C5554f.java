package org.p290c.p299b;

import org.p290c.C5562c;
/* renamed from: org.c.b.f */
/* loaded from: classes2.dex */
public class C5554f extends AbstractC5509d {

    /* renamed from: a */
    public Object f22640a;

    public C5554f(double d) {
        this.f22640a = Double.valueOf(d);
    }

    public C5554f(float f) {
        this.f22640a = Float.valueOf(f);
    }

    @Override // org.p290c.p299b.AbstractC5509d
    /* renamed from: a */
    protected void mo781a(Object obj, Object obj2) {
        if (obj instanceof Double) {
            C5562c.m729b(((Double) obj).doubleValue(), ((Double) obj2).doubleValue(), ((Double) this.f22640a).doubleValue());
        } else {
            C5562c.m728b(((Float) obj).floatValue(), ((Float) obj2).floatValue(), ((Float) this.f22640a).floatValue());
        }
    }
}
