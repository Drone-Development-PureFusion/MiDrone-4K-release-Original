package org.p290c.p299b.p301b;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Throwable;
import org.p287b.AbstractC5425g;
import org.p287b.AbstractC5428i;
import org.p287b.AbstractC5430k;
import org.p287b.AbstractC5435p;
/* renamed from: org.c.b.b.a */
/* loaded from: classes.dex */
public class C5501a<T extends Throwable> extends AbstractC5435p<T> {

    /* renamed from: a */
    private final AbstractC5430k<T> f22567a;

    public C5501a(AbstractC5430k<T> abstractC5430k) {
        this.f22567a = abstractC5430k;
    }

    @AbstractC5428i
    /* renamed from: a */
    public static <T extends Throwable> AbstractC5430k<T> m913a(AbstractC5430k<T> abstractC5430k) {
        return new C5501a(abstractC5430k);
    }

    /* renamed from: b */
    private String m912b(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    @AbstractC5428i
    /* renamed from: b */
    public static <T extends Exception> AbstractC5430k<T> m911b(AbstractC5430k<T> abstractC5430k) {
        return new C5501a(abstractC5430k);
    }

    /* renamed from: a */
    protected void m914a(T t, AbstractC5425g abstractC5425g) {
        this.f22567a.mo1070a(t, abstractC5425g);
        abstractC5425g.mo1086a("\nStacktrace was: ");
        abstractC5425g.mo1086a(m912b((Throwable) t));
    }

    @Override // org.p287b.AbstractC5432m
    /* renamed from: a */
    public void mo905a(AbstractC5425g abstractC5425g) {
        this.f22567a.a(abstractC5425g);
    }

    /* renamed from: a */
    protected boolean m915a(T t) {
        return this.f22567a.mo900a(t);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.p287b.AbstractC5435p
    /* renamed from: b */
    protected /* synthetic */ void mo902b(Object obj, AbstractC5425g abstractC5425g) {
        m914a((C5501a<T>) ((Throwable) obj), abstractC5425g);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.p287b.AbstractC5435p
    /* renamed from: b */
    protected /* synthetic */ boolean mo903b(Object obj) {
        return m915a((C5501a<T>) ((Throwable) obj));
    }
}
