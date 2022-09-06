package p004b.p005a.p006a.p028b.p051m.p052a;

import java.io.File;
import java.util.Date;
import p004b.p005a.p006a.p028b.p044i.AbstractC0431b;
import p004b.p005a.p006a.p028b.p044i.C0453h;
import p004b.p005a.p006a.p028b.p054o.C0527f;
/* renamed from: b.a.a.b.m.a.g */
/* loaded from: classes.dex */
public abstract class AbstractC0478g extends C0527f implements AbstractC0471a {

    /* renamed from: a */
    protected static final long f1060a = -1;

    /* renamed from: b */
    protected static final long f1061b = 5529600000L;

    /* renamed from: c */
    static final int f1062c = 336;

    /* renamed from: d */
    final C0483i f1063d;

    /* renamed from: e */
    final C0489o f1064e;

    /* renamed from: f */
    int f1065f;

    /* renamed from: g */
    final boolean f1066g;

    /* renamed from: h */
    long f1067h = f1060a;

    public AbstractC0478g(C0483i c0483i, C0489o c0489o) {
        this.f1063d = c0483i;
        this.f1064e = c0489o;
        this.f1066g = m20404a(c0483i);
    }

    /* renamed from: a */
    private void m20402a(File file, int i) {
        if (i < 3 && file.isDirectory() && C0479h.m20400a(file)) {
            d("deleting folder [" + file + "]");
            file.delete();
            m20402a(file.getParentFile(), i + 1);
        }
    }

    /* renamed from: a */
    int m20405a(long j) {
        long j2 = 336;
        if (this.f1067h == f1060a) {
            d("first clean up after appender initialization");
            long m20369a = this.f1064e.m20369a(j, f1061b + j);
            if (m20369a <= 336) {
                j2 = m20369a;
            }
        } else {
            j2 = this.f1064e.m20369a(this.f1067h, j);
            if (j2 < 1) {
                e("Unexpected periodsElapsed value " + j2);
                j2 = 1;
            }
        }
        return (int) j2;
    }

    @Override // p004b.p005a.p006a.p028b.p051m.p052a.AbstractC0471a
    /* renamed from: a */
    public void mo20406a(int i) {
        this.f1065f = (-i) - 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m20403a(File file) {
        m20402a(file, 0);
    }

    @Override // p004b.p005a.p006a.p028b.p051m.p052a.AbstractC0471a
    /* renamed from: a */
    public void mo20401a(Date date) {
        long time = date.getTime();
        int m20405a = m20405a(time);
        this.f1067h = time;
        if (m20405a > 1) {
            d("periodsElapsed = " + m20405a);
        }
        for (int i = 0; i < m20405a; i++) {
            mo20360a(date, this.f1065f - i);
        }
    }

    /* renamed from: a */
    abstract void mo20360a(Date date, int i);

    /* renamed from: a */
    boolean m20404a(C0483i c0483i) {
        if (c0483i.m20383b().m20410a().indexOf(47) != -1) {
            return true;
        }
        AbstractC0431b<Object> abstractC0431b = c0483i.f1071c;
        while (abstractC0431b != null && !(abstractC0431b instanceof C0477f)) {
            abstractC0431b = abstractC0431b.m20542b();
        }
        while (abstractC0431b != null) {
            if ((abstractC0431b instanceof C0453h) && abstractC0431b.mo20376a(null).indexOf(47) != -1) {
                return true;
            }
            abstractC0431b = abstractC0431b.m20542b();
        }
        return false;
    }
}
