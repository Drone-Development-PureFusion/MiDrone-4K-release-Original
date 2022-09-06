package org.p290c.p299b.p303d;

import java.util.Arrays;
import java.util.List;
@Deprecated
/* renamed from: org.c.b.d.d */
/* loaded from: classes.dex */
public class C5538d extends Exception {
    private static final long serialVersionUID = 1;

    /* renamed from: a */
    private final List<Throwable> f22618a;

    public C5538d(String str) {
        this(new Exception(str));
    }

    public C5538d(List<Throwable> list) {
        this.f22618a = list;
    }

    public C5538d(Throwable... thArr) {
        this(Arrays.asList(thArr));
    }

    /* renamed from: a */
    public List<Throwable> m843a() {
        return this.f22618a;
    }
}
