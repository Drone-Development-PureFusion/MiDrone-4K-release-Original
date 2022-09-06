package org.p290c.p308d;

import java.lang.management.ManagementFactory;
import java.util.List;
import org.p290c.p309e.C5619c;
import org.p290c.p312f.p313a.AbstractC5647j;
/* renamed from: org.c.d.a */
/* loaded from: classes2.dex */
public class C5565a implements AbstractC5582l {

    /* renamed from: a */
    private final AbstractC5582l f22644a;

    /* renamed from: b */
    private final boolean f22645b;

    public C5565a(AbstractC5582l abstractC5582l) {
        this(abstractC5582l, ManagementFactory.getRuntimeMXBean().getInputArguments());
    }

    C5565a(AbstractC5582l abstractC5582l, List<String> list) {
        this.f22644a = abstractC5582l;
        this.f22645b = m680a(list);
    }

    /* renamed from: a */
    private static boolean m680a(List<String> list) {
        for (String str : list) {
            if ("-Xdebug".equals(str)) {
                return true;
            }
            if (str.startsWith("-agentlib:jdwp")) {
                return true;
            }
        }
        return false;
    }

    @Override // org.p290c.p308d.AbstractC5582l
    /* renamed from: a */
    public AbstractC5647j mo587a(AbstractC5647j abstractC5647j, C5619c c5619c) {
        return this.f22645b ? abstractC5647j : this.f22644a.mo587a(abstractC5647j, c5619c);
    }

    /* renamed from: a */
    public boolean m681a() {
        return this.f22645b;
    }
}
