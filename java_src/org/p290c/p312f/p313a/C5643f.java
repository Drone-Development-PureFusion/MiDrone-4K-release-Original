package org.p290c.p312f.p313a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.p290c.p299b.C5561k;
import org.p290c.p299b.p303d.p304a.C5512b;
/* renamed from: org.c.f.a.f */
/* loaded from: classes2.dex */
public class C5643f extends Exception {
    private static final long serialVersionUID = 1;

    /* renamed from: a */
    private final List<Throwable> f22748a;

    public C5643f(List<Throwable> list) {
        this.f22748a = new ArrayList(list);
    }

    /* renamed from: a */
    public static void m438a(List<Throwable> list) {
        if (list.isEmpty()) {
            return;
        }
        if (list.size() != 1) {
            throw new C5512b(list);
        }
        throw C5561k.m768a(list.get(0));
    }

    /* renamed from: a */
    public List<Throwable> m439a() {
        return Collections.unmodifiableList(this.f22748a);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder sb = new StringBuilder(String.format("There were %d errors:", Integer.valueOf(this.f22748a.size())));
        for (Throwable th : this.f22748a) {
            sb.append(String.format("\n  %s(%s)", th.getClass().getName(), th.getMessage()));
        }
        return sb.toString();
    }
}
