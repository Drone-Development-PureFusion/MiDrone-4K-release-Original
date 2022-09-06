package org.p287b.p288a;

import org.p287b.AbstractC5425g;
import org.p287b.AbstractC5435p;
/* renamed from: org.b.a.r */
/* loaded from: classes2.dex */
public abstract class AbstractC5411r extends AbstractC5435p<String> {

    /* renamed from: a */
    protected final String f22486a;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractC5411r(String str) {
        this.f22486a = str;
    }

    @Override // org.p287b.AbstractC5435p
    /* renamed from: a */
    public void mo902b(String str, AbstractC5425g abstractC5425g) {
        abstractC5425g.mo1086a("was \"").mo1086a(str).mo1086a("\"");
    }

    @Override // org.p287b.AbstractC5432m
    /* renamed from: a */
    public void mo905a(AbstractC5425g abstractC5425g) {
        abstractC5425g.mo1086a("a string ").mo1086a(mo1142b()).mo1086a(" ").mo1087a((Object) this.f22486a);
    }

    /* renamed from: a */
    protected abstract boolean mo1144a(String str);

    /* renamed from: b */
    protected abstract String mo1142b();

    @Override // org.p287b.AbstractC5435p
    /* renamed from: c */
    public boolean mo903b(String str) {
        return mo1144a(str);
    }
}
