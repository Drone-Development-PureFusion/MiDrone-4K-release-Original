package org.p290c.p309e.p311b;

import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import org.p290c.p309e.C5619c;
/* renamed from: org.c.e.b.a */
/* loaded from: classes2.dex */
public class C5605a implements Serializable {
    private static final long serialVersionUID = 1;

    /* renamed from: a */
    private final C5619c f22693a;

    /* renamed from: b */
    private final Throwable f22694b;

    public C5605a(C5619c c5619c, Throwable th) {
        this.f22694b = th;
        this.f22693a = c5619c;
    }

    /* renamed from: a */
    public String m575a() {
        return this.f22693a.m552a();
    }

    /* renamed from: b */
    public C5619c m574b() {
        return this.f22693a;
    }

    /* renamed from: c */
    public Throwable m573c() {
        return this.f22694b;
    }

    /* renamed from: d */
    public String m572d() {
        StringWriter stringWriter = new StringWriter();
        m573c().printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    /* renamed from: e */
    public String m571e() {
        return m573c().getMessage();
    }

    public String toString() {
        return m575a() + ": " + this.f22694b.getMessage();
    }
}
