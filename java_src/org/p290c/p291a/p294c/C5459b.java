package org.p290c.p291a.p294c;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.p290c.p299b.C5560j;
import org.p290c.p309e.AbstractC5627i;
import org.p290c.p309e.C5626h;
import org.p290c.p309e.C5629j;
import org.p290c.p309e.p311b.C5605a;
/* renamed from: org.c.a.c.b */
/* loaded from: classes2.dex */
public class C5459b {

    /* renamed from: a */
    private C5629j f22530a;

    public C5459b(List<C5605a> list) {
        this(new C5458a(list).m1007a());
    }

    private C5459b(C5629j c5629j) {
        this.f22530a = c5629j;
    }

    /* renamed from: a */
    public static C5459b m1005a(Class<?> cls) {
        return m1004a(AbstractC5627i.m499a(cls));
    }

    /* renamed from: a */
    public static C5459b m1004a(AbstractC5627i abstractC5627i) {
        return new C5459b(new C5626h().m507a(abstractC5627i));
    }

    /* renamed from: a */
    public int m1006a() {
        return this.f22530a.m482d().size();
    }

    public String toString() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        new C5560j(new PrintStream(byteArrayOutputStream)).mo474a(this.f22530a);
        return byteArrayOutputStream.toString();
    }
}
