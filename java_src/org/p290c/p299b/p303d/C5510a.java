package org.p290c.p299b.p303d;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.p290c.p299b.C5500b;
import org.p290c.p309e.C5619c;
import org.p290c.p309e.p311b.C5605a;
import org.p290c.p309e.p311b.C5608c;
@Deprecated
/* renamed from: org.c.b.d.a */
/* loaded from: classes.dex */
public class C5510a {

    /* renamed from: a */
    private C5608c f22579a;

    /* renamed from: b */
    private C5551j f22580b;

    /* renamed from: c */
    private C5619c f22581c;

    /* renamed from: d */
    private final Runnable f22582d;

    public C5510a(C5608c c5608c, C5551j c5551j, C5619c c5619c, Runnable runnable) {
        this.f22579a = c5608c;
        this.f22580b = c5551j;
        this.f22581c = c5619c;
        this.f22582d = runnable;
    }

    /* renamed from: c */
    private void m890c() {
        try {
            try {
                for (Method method : this.f22580b.m796b()) {
                    method.invoke(null, new Object[0]);
                }
            } catch (InvocationTargetException e) {
                throw e.getTargetException();
            }
        } catch (C5500b e2) {
            throw new C5528c();
        } catch (Throwable th) {
            m892a(th);
            throw new C5528c();
        }
    }

    /* renamed from: d */
    private void m889d() {
        for (Method method : this.f22580b.m794c()) {
            try {
                method.invoke(null, new Object[0]);
            } catch (InvocationTargetException e) {
                m892a(e.getTargetException());
            } catch (Throwable th) {
                m892a(th);
            }
        }
    }

    /* renamed from: a */
    protected void m893a() {
        this.f22582d.run();
    }

    /* renamed from: a */
    protected void m892a(Throwable th) {
        this.f22579a.m568a(new C5605a(this.f22581c, th));
    }

    /* renamed from: b */
    public void m891b() {
        try {
            m890c();
            m893a();
        } catch (C5528c e) {
        } finally {
            m889d();
        }
    }
}
