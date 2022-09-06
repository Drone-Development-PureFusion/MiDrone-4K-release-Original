package org.p290c.p312f.p313a;

import java.util.Arrays;
import java.util.List;
/* renamed from: org.c.f.a.e */
/* loaded from: classes.dex */
public class C5642e extends Exception {
    private static final long serialVersionUID = 1;

    /* renamed from: a */
    private final List<Throwable> f22747a;

    public C5642e(String str) {
        this(new Exception(str));
    }

    public C5642e(Throwable th) {
        this(Arrays.asList(th));
    }

    public C5642e(List<Throwable> list) {
        this.f22747a = list;
    }

    /* renamed from: a */
    public List<Throwable> m440a() {
        return this.f22747a;
    }
}
