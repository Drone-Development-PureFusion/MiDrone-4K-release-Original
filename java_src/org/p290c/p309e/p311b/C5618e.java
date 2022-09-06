package org.p290c.p309e.p311b;

import org.p290c.p309e.C5619c;
import org.p290c.p309e.C5629j;
import org.p290c.p309e.p311b.C5606b;
/* JADX INFO: Access modifiers changed from: package-private */
@C5606b.AbstractC5607a
/* renamed from: org.c.e.b.e */
/* loaded from: classes.dex */
public final class C5618e extends C5606b {

    /* renamed from: a */
    private final C5606b f22713a;

    /* renamed from: b */
    private final Object f22714b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C5618e(C5606b c5606b, Object obj) {
        this.f22713a = c5606b;
        this.f22714b = obj;
    }

    @Override // org.p290c.p309e.p311b.C5606b
    /* renamed from: a */
    public void mo476a(C5605a c5605a) {
        synchronized (this.f22714b) {
            this.f22713a.mo476a(c5605a);
        }
    }

    @Override // org.p290c.p309e.p311b.C5606b
    /* renamed from: a */
    public void mo475a(C5619c c5619c) {
        synchronized (this.f22714b) {
            this.f22713a.mo475a(c5619c);
        }
    }

    @Override // org.p290c.p309e.p311b.C5606b
    /* renamed from: a */
    public void mo474a(C5629j c5629j) {
        synchronized (this.f22714b) {
            this.f22713a.mo474a(c5629j);
        }
    }

    @Override // org.p290c.p309e.p311b.C5606b
    /* renamed from: b */
    public void mo473b(C5605a c5605a) {
        synchronized (this.f22714b) {
            this.f22713a.mo473b(c5605a);
        }
    }

    @Override // org.p290c.p309e.p311b.C5606b
    /* renamed from: b */
    public void mo553b(C5619c c5619c) {
        synchronized (this.f22714b) {
            this.f22713a.mo553b(c5619c);
        }
    }

    @Override // org.p290c.p309e.p311b.C5606b
    /* renamed from: c */
    public void mo472c(C5619c c5619c) {
        synchronized (this.f22714b) {
            this.f22713a.mo472c(c5619c);
        }
    }

    @Override // org.p290c.p309e.p311b.C5606b
    /* renamed from: d */
    public void mo471d(C5619c c5619c) {
        synchronized (this.f22714b) {
            this.f22713a.mo471d(c5619c);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C5618e) {
            return this.f22713a.equals(((C5618e) obj).f22713a);
        }
        return false;
    }

    public int hashCode() {
        return this.f22713a.hashCode();
    }

    public String toString() {
        return this.f22713a.toString() + " (with synchronization wrapper)";
    }
}
