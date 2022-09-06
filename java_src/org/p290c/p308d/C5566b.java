package org.p290c.p308d;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import org.p287b.AbstractC5430k;
import org.p290c.C5562c;
import org.p290c.p312f.p313a.C5643f;
/* renamed from: org.c.d.b */
/* loaded from: classes2.dex */
public class C5566b extends AbstractC5590p {

    /* renamed from: a */
    private List<Throwable> f22646a = new ArrayList();

    /* renamed from: a */
    public <T> T m676a(Callable<T> callable) {
        try {
            return callable.call();
        } catch (Throwable th) {
            m677a(th);
            return null;
        }
    }

    @Override // org.p290c.p308d.AbstractC5590p
    /* renamed from: a */
    protected void mo588a() {
        C5643f.m438a(this.f22646a);
    }

    /* renamed from: a */
    public <T> void m679a(T t, AbstractC5430k<T> abstractC5430k) {
        m678a("", t, abstractC5430k);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public <T> void m678a(final String str, final T t, final AbstractC5430k<T> abstractC5430k) {
        m676a(new Callable<Object>() { // from class: org.c.d.b.1
            @Override // java.util.concurrent.Callable
            public Object call() {
                C5562c.m750a(str, t, (AbstractC5430k<? super Object>) abstractC5430k);
                return t;
            }
        });
    }

    /* renamed from: a */
    public void m677a(Throwable th) {
        this.f22646a.add(th);
    }
}
