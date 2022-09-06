package org.p318d.p320b;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.p248a.p249a.p261f.p264c.C5122l;
import org.p318d.AbstractC5756f;
/* renamed from: org.d.b.b */
/* loaded from: classes2.dex */
public class C5730b implements AbstractC5756f {

    /* renamed from: e */
    private static String f22991e = "[ ";

    /* renamed from: f */
    private static String f22992f = " ]";

    /* renamed from: g */
    private static String f22993g = ", ";
    private static final long serialVersionUID = 1803952589649545191L;

    /* renamed from: c */
    private final String f22994c;

    /* renamed from: d */
    private List<AbstractC5756f> f22995d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C5730b(String str) {
        if (str == null) {
            throw new IllegalArgumentException("A marker name cannot be null");
        }
        this.f22994c = str;
    }

    @Override // org.p318d.AbstractC5756f
    /* renamed from: a */
    public String mo11a() {
        return this.f22994c;
    }

    @Override // org.p318d.AbstractC5756f
    /* renamed from: a */
    public synchronized void mo9a(AbstractC5756f abstractC5756f) {
        if (abstractC5756f == null) {
            throw new IllegalArgumentException("A null value cannot be added to a Marker as reference.");
        }
        if (!mo5c(abstractC5756f) && !abstractC5756f.mo5c(this)) {
            if (this.f22995d == null) {
                this.f22995d = new Vector();
            }
            this.f22995d.add(abstractC5756f);
        }
    }

    @Override // org.p318d.AbstractC5756f
    /* renamed from: a */
    public boolean mo10a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Other cannot be null");
        }
        if (this.f22994c.equals(str)) {
            return true;
        }
        if (mo6c()) {
            for (AbstractC5756f abstractC5756f : this.f22995d) {
                if (abstractC5756f.mo10a(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // org.p318d.AbstractC5756f
    /* renamed from: b */
    public boolean mo8b() {
        return mo6c();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0020, code lost:
        r4.f22995d.remove(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0025, code lost:
        r0 = true;
     */
    @Override // org.p318d.AbstractC5756f
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean mo7b(AbstractC5756f abstractC5756f) {
        boolean z;
        if (this.f22995d != null) {
            int size = this.f22995d.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    z = false;
                    break;
                } else if (abstractC5756f.equals(this.f22995d.get(i))) {
                    break;
                } else {
                    i++;
                }
            }
        } else {
            z = false;
        }
        return z;
    }

    @Override // org.p318d.AbstractC5756f
    /* renamed from: c */
    public synchronized boolean mo6c() {
        boolean z;
        if (this.f22995d != null) {
            if (this.f22995d.size() > 0) {
                z = true;
            }
        }
        z = false;
        return z;
    }

    @Override // org.p318d.AbstractC5756f
    /* renamed from: c */
    public boolean mo5c(AbstractC5756f abstractC5756f) {
        if (abstractC5756f == null) {
            throw new IllegalArgumentException("Other cannot be null");
        }
        if (equals(abstractC5756f)) {
            return true;
        }
        if (mo6c()) {
            for (AbstractC5756f abstractC5756f2 : this.f22995d) {
                if (abstractC5756f2.mo5c(abstractC5756f)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // org.p318d.AbstractC5756f
    /* renamed from: d */
    public synchronized Iterator<AbstractC5756f> mo4d() {
        return this.f22995d != null ? this.f22995d.iterator() : Collections.emptyList().iterator();
    }

    @Override // org.p318d.AbstractC5756f
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof AbstractC5756f)) {
            return this.f22994c.equals(((AbstractC5756f) obj).mo11a());
        }
        return false;
    }

    @Override // org.p318d.AbstractC5756f
    public int hashCode() {
        return this.f22994c.hashCode();
    }

    public String toString() {
        if (!mo6c()) {
            return mo11a();
        }
        Iterator<AbstractC5756f> mo4d = mo4d();
        StringBuilder sb = new StringBuilder(mo11a());
        sb.append(C5122l.f21763c).append(f22991e);
        while (mo4d.hasNext()) {
            sb.append(mo4d.next().mo11a());
            if (mo4d.hasNext()) {
                sb.append(f22993g);
            }
        }
        sb.append(f22992f);
        return sb.toString();
    }
}
