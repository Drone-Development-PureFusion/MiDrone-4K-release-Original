package org.p287b.p288a;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.p287b.AbstractC5412b;
import org.p287b.AbstractC5425g;
import org.p287b.AbstractC5428i;
import org.p287b.AbstractC5430k;
/* renamed from: org.b.a.d */
/* loaded from: classes.dex */
public class C5397d<T> extends AbstractC5412b<T> {

    /* renamed from: d */
    private static final Pattern f22472d = Pattern.compile("%([0-9]+)");

    /* renamed from: a */
    private final String f22473a;

    /* renamed from: b */
    private final AbstractC5430k<T> f22474b;

    /* renamed from: c */
    private final Object[] f22475c;

    public C5397d(String str, AbstractC5430k<T> abstractC5430k, Object[] objArr) {
        this.f22473a = str;
        this.f22474b = abstractC5430k;
        this.f22475c = (Object[]) objArr.clone();
    }

    @AbstractC5428i
    /* renamed from: a */
    public static <T> AbstractC5430k<T> m1180a(String str, AbstractC5430k<T> abstractC5430k, Object... objArr) {
        return new C5397d(str, abstractC5430k, objArr);
    }

    @Override // org.p287b.AbstractC5412b, org.p287b.AbstractC5430k
    /* renamed from: a */
    public void mo1070a(Object obj, AbstractC5425g abstractC5425g) {
        this.f22474b.mo1070a(obj, abstractC5425g);
    }

    @Override // org.p287b.AbstractC5432m
    /* renamed from: a */
    public void mo905a(AbstractC5425g abstractC5425g) {
        Matcher matcher = f22472d.matcher(this.f22473a);
        int i = 0;
        while (matcher.find()) {
            abstractC5425g.mo1086a(this.f22473a.substring(i, matcher.start()));
            abstractC5425g.mo1087a(this.f22475c[Integer.parseInt(matcher.group(1))]);
            i = matcher.end();
        }
        if (i < this.f22473a.length()) {
            abstractC5425g.mo1086a(this.f22473a.substring(i));
        }
    }

    @Override // org.p287b.AbstractC5430k
    /* renamed from: a */
    public boolean mo900a(Object obj) {
        return this.f22474b.mo900a(obj);
    }
}
