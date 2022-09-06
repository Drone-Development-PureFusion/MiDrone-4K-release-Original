package org.p248a.p283b;

import java.io.ByteArrayOutputStream;
import org.p248a.p283b.p285b.AbstractC5373e;
import org.p248a.p283b.p285b.AbstractC5375g;
import org.p248a.p283b.p285b.C5368a;
import org.p248a.p283b.p286c.C5382a;
/* renamed from: org.a.b.g */
/* loaded from: classes2.dex */
public class C5390g {

    /* renamed from: a */
    private final ByteArrayOutputStream f22465a;

    /* renamed from: b */
    private final C5382a f22466b;

    /* renamed from: c */
    private AbstractC5373e f22467c;

    public C5390g() {
        this(new C5368a.C5369a());
    }

    public C5390g(AbstractC5375g abstractC5375g) {
        this.f22465a = new ByteArrayOutputStream();
        this.f22466b = new C5382a(this.f22465a);
        this.f22467c = abstractC5375g.mo1221a(this.f22466b);
    }

    /* renamed from: a */
    public byte[] m1207a(AbstractC5358a abstractC5358a) {
        this.f22465a.reset();
        abstractC5358a.mo1285b(this.f22467c);
        return this.f22465a.toByteArray();
    }
}
