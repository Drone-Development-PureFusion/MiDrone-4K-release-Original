package org.p290c.p312f;

import java.lang.reflect.Method;
import java.util.Comparator;
import org.p290c.p299b.C5556h;
/* renamed from: org.c.f.d */
/* loaded from: classes.dex */
public enum EnumC5660d {
    NAME_ASCENDING(C5556h.f22642b),
    JVM(null),
    DEFAULT(C5556h.f22641a);
    

    /* renamed from: d */
    private final Comparator<Method> f22769d;

    EnumC5660d(Comparator comparator) {
        this.f22769d = comparator;
    }

    /* renamed from: a */
    public Comparator<Method> m360a() {
        return this.f22769d;
    }
}
