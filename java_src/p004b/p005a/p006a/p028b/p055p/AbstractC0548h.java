package p004b.p005a.p006a.p028b.p055p;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* renamed from: b.a.a.b.p.h */
/* loaded from: classes.dex */
public abstract class AbstractC0548h implements AbstractC0547g {

    /* renamed from: j */
    private static final List<AbstractC0547g> f1210j = new ArrayList(0);

    /* renamed from: d */
    int f1211d;

    /* renamed from: e */
    final String f1212e;

    /* renamed from: f */
    final Object f1213f;

    /* renamed from: g */
    List<AbstractC0547g> f1214g;

    /* renamed from: h */
    Throwable f1215h;

    /* renamed from: i */
    long f1216i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC0548h(int i, String str, Object obj) {
        this(i, str, obj, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC0548h(int i, String str, Object obj, Throwable th) {
        this.f1211d = i;
        this.f1212e = str;
        this.f1213f = obj;
        this.f1215h = th;
        this.f1216i = System.currentTimeMillis();
    }

    @Override // p004b.p005a.p006a.p028b.p055p.AbstractC0547g
    /* renamed from: a */
    public int mo20201a() {
        return this.f1211d;
    }

    @Override // p004b.p005a.p006a.p028b.p055p.AbstractC0547g
    /* renamed from: a */
    public synchronized void mo20200a(AbstractC0547g abstractC0547g) {
        if (abstractC0547g == null) {
            throw new NullPointerException("Null values are not valid Status.");
        }
        if (this.f1214g == null) {
            this.f1214g = new ArrayList();
        }
        this.f1214g.add(abstractC0547g);
    }

    @Override // p004b.p005a.p006a.p028b.p055p.AbstractC0547g
    /* renamed from: b */
    public synchronized int mo20199b() {
        int i;
        int i2 = this.f1211d;
        Iterator<AbstractC0547g> mo20192h = mo20192h();
        i = i2;
        while (mo20192h.hasNext()) {
            int mo20199b = mo20192h.next().mo20199b();
            if (mo20199b > i) {
                i = mo20199b;
            }
        }
        return i;
    }

    @Override // p004b.p005a.p006a.p028b.p055p.AbstractC0547g
    /* renamed from: b */
    public synchronized boolean mo20198b(AbstractC0547g abstractC0547g) {
        return this.f1214g == null ? false : this.f1214g.remove(abstractC0547g);
    }

    @Override // p004b.p005a.p006a.p028b.p055p.AbstractC0547g
    /* renamed from: c */
    public Object mo20197c() {
        return this.f1213f;
    }

    @Override // p004b.p005a.p006a.p028b.p055p.AbstractC0547g
    /* renamed from: d */
    public String mo20196d() {
        return this.f1212e;
    }

    @Override // p004b.p005a.p006a.p028b.p055p.AbstractC0547g
    /* renamed from: e */
    public Throwable mo20195e() {
        return this.f1215h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            AbstractC0548h abstractC0548h = (AbstractC0548h) obj;
            if (this.f1211d != abstractC0548h.f1211d) {
                return false;
            }
            return this.f1212e == null ? abstractC0548h.f1212e == null : this.f1212e.equals(abstractC0548h.f1212e);
        }
        return false;
    }

    @Override // p004b.p005a.p006a.p028b.p055p.AbstractC0547g
    /* renamed from: f */
    public Long mo20194f() {
        return Long.valueOf(this.f1216i);
    }

    @Override // p004b.p005a.p006a.p028b.p055p.AbstractC0547g
    /* renamed from: g */
    public synchronized boolean mo20193g() {
        boolean z;
        if (this.f1214g != null) {
            if (this.f1214g.size() > 0) {
                z = true;
            }
        }
        z = false;
        return z;
    }

    @Override // p004b.p005a.p006a.p028b.p055p.AbstractC0547g
    /* renamed from: h */
    public synchronized Iterator<AbstractC0547g> mo20192h() {
        return this.f1214g != null ? this.f1214g.iterator() : f1210j.iterator();
    }

    public int hashCode() {
        return (this.f1212e == null ? 0 : this.f1212e.hashCode()) + ((this.f1211d + 31) * 31);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        switch (mo20199b()) {
            case 0:
                stringBuffer.append("INFO");
                break;
            case 1:
                stringBuffer.append("WARN");
                break;
            case 2:
                stringBuffer.append("ERROR");
                break;
        }
        if (this.f1213f != null) {
            stringBuffer.append(" in ");
            stringBuffer.append(this.f1213f);
            stringBuffer.append(" -");
        }
        stringBuffer.append(" ");
        stringBuffer.append(this.f1212e);
        if (this.f1215h != null) {
            stringBuffer.append(" ");
            stringBuffer.append(this.f1215h);
        }
        return stringBuffer.toString();
    }
}
