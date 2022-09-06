package org.p287b;

import java.io.IOException;
/* renamed from: org.b.n */
/* loaded from: classes2.dex */
public class C5433n extends AbstractC5391a {

    /* renamed from: b */
    private final Appendable f22504b;

    public C5433n() {
        this(new StringBuilder());
    }

    public C5433n(Appendable appendable) {
        this.f22504b = appendable;
    }

    /* renamed from: b */
    public static String m1073b(AbstractC5432m abstractC5432m) {
        return new C5433n().a(abstractC5432m).toString();
    }

    /* renamed from: c */
    public static String m1072c(AbstractC5432m abstractC5432m) {
        return m1073b(abstractC5432m);
    }

    @Override // org.p287b.AbstractC5391a
    /* renamed from: a */
    protected void mo1075a(char c) {
        try {
            this.f22504b.append(c);
        } catch (IOException e) {
            throw new RuntimeException("Could not write description", e);
        }
    }

    @Override // org.p287b.AbstractC5391a
    /* renamed from: b */
    protected void mo1074b(String str) {
        try {
            this.f22504b.append(str);
        } catch (IOException e) {
            throw new RuntimeException("Could not write description", e);
        }
    }

    public String toString() {
        return this.f22504b.toString();
    }
}
