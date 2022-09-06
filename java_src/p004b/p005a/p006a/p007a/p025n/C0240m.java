package p004b.p005a.p006a.p007a.p025n;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import org.p318d.AbstractC5756f;
import org.p318d.p320b.C5734f;
import p004b.p005a.p006a.p007a.C0146d;
/* renamed from: b.a.a.a.n.m */
/* loaded from: classes.dex */
public class C0240m implements AbstractC0231d, Serializable {

    /* renamed from: a */
    private static final int f381a = -1;

    /* renamed from: b */
    private static final String f382b = "NULL_ARGUMENT_ARRAY_ELEMENT";
    private static final long serialVersionUID = 6553722650255690312L;

    /* renamed from: c */
    private String f383c;

    /* renamed from: d */
    private String f384d;

    /* renamed from: e */
    private C0237j f385e;

    /* renamed from: f */
    private transient C0146d f386f;

    /* renamed from: g */
    private String f387g;

    /* renamed from: h */
    private transient String f388h;

    /* renamed from: i */
    private transient Object[] f389i;

    /* renamed from: j */
    private C0246s f390j;

    /* renamed from: k */
    private StackTraceElement[] f391k;

    /* renamed from: l */
    private AbstractC5756f f392l;

    /* renamed from: m */
    private Map<String, String> f393m;

    /* renamed from: n */
    private long f394n;

    /* renamed from: a */
    public static C0240m m21221a(AbstractC0231d abstractC0231d) {
        C0240m c0240m = new C0240m();
        c0240m.f384d = abstractC0231d.mo21216f();
        c0240m.f385e = abstractC0231d.mo21215g();
        c0240m.f383c = abstractC0231d.mo21222a();
        c0240m.f386f = abstractC0231d.mo21220b();
        c0240m.f387g = abstractC0231d.mo21219c();
        c0240m.f389i = abstractC0231d.mo21218d();
        c0240m.f392l = abstractC0231d.mo21211k();
        c0240m.f393m = abstractC0231d.mo21210l();
        c0240m.f394n = abstractC0231d.mo21208n();
        c0240m.f390j = C0246s.m21171a(abstractC0231d.mo21214h());
        if (abstractC0231d.mo21212j()) {
            c0240m.f391k = abstractC0231d.mo21213i();
        }
        return c0240m;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.f386f = C0146d.m21485a(objectInputStream.readInt());
        int readInt = objectInputStream.readInt();
        if (readInt != -1) {
            this.f389i = new String[readInt];
            for (int i = 0; i < readInt; i++) {
                Object readObject = objectInputStream.readObject();
                if (!f382b.equals(readObject)) {
                    this.f389i[i] = readObject;
                }
            }
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.f386f.f208v);
        if (this.f389i == null) {
            objectOutputStream.writeInt(-1);
            return;
        }
        objectOutputStream.writeInt(this.f389i.length);
        for (int i = 0; i < this.f389i.length; i++) {
            if (this.f389i[i] != null) {
                objectOutputStream.writeObject(this.f389i[i].toString());
            } else {
                objectOutputStream.writeObject(f382b);
            }
        }
    }

    @Override // p004b.p005a.p006a.p007a.p025n.AbstractC0231d
    /* renamed from: a */
    public String mo21222a() {
        return this.f383c;
    }

    @Override // p004b.p005a.p006a.p007a.p025n.AbstractC0231d
    /* renamed from: b */
    public C0146d mo21220b() {
        return this.f386f;
    }

    @Override // p004b.p005a.p006a.p007a.p025n.AbstractC0231d
    /* renamed from: c */
    public String mo21219c() {
        return this.f387g;
    }

    @Override // p004b.p005a.p006a.p007a.p025n.AbstractC0231d
    /* renamed from: d */
    public Object[] mo21218d() {
        return this.f389i;
    }

    @Override // p004b.p005a.p006a.p007a.p025n.AbstractC0231d
    /* renamed from: e */
    public String mo21217e() {
        if (this.f388h != null) {
            return this.f388h;
        }
        if (this.f389i != null) {
            this.f388h = C5734f.m154a(this.f387g, this.f389i).m160a();
        } else {
            this.f388h = this.f387g;
        }
        return this.f388h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            C0240m c0240m = (C0240m) obj;
            if (this.f387g == null) {
                if (c0240m.f387g != null) {
                    return false;
                }
            } else if (!this.f387g.equals(c0240m.f387g)) {
                return false;
            }
            if (this.f384d == null) {
                if (c0240m.f384d != null) {
                    return false;
                }
            } else if (!this.f384d.equals(c0240m.f384d)) {
                return false;
            }
            if (this.f383c == null) {
                if (c0240m.f383c != null) {
                    return false;
                }
            } else if (!this.f383c.equals(c0240m.f383c)) {
                return false;
            }
            if (this.f394n != c0240m.f394n) {
                return false;
            }
            if (this.f392l == null) {
                if (c0240m.f392l != null) {
                    return false;
                }
            } else if (!this.f392l.equals(c0240m.f392l)) {
                return false;
            }
            return this.f393m == null ? c0240m.f393m == null : this.f393m.equals(c0240m.f393m);
        }
        return false;
    }

    @Override // p004b.p005a.p006a.p007a.p025n.AbstractC0231d
    /* renamed from: f */
    public String mo21216f() {
        return this.f384d;
    }

    @Override // p004b.p005a.p006a.p007a.p025n.AbstractC0231d
    /* renamed from: g */
    public C0237j mo21215g() {
        return this.f385e;
    }

    @Override // p004b.p005a.p006a.p007a.p025n.AbstractC0231d
    /* renamed from: h */
    public AbstractC0232e mo21214h() {
        return this.f390j;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f387g == null ? 0 : this.f387g.hashCode()) + 31) * 31;
        if (this.f383c != null) {
            i = this.f383c.hashCode();
        }
        return ((hashCode + i) * 31) + ((int) (this.f394n ^ (this.f394n >>> 32)));
    }

    @Override // p004b.p005a.p006a.p007a.p025n.AbstractC0231d
    /* renamed from: i */
    public StackTraceElement[] mo21213i() {
        return this.f391k;
    }

    @Override // p004b.p005a.p006a.p007a.p025n.AbstractC0231d
    /* renamed from: j */
    public boolean mo21212j() {
        return this.f391k != null;
    }

    @Override // p004b.p005a.p006a.p007a.p025n.AbstractC0231d
    /* renamed from: k */
    public AbstractC5756f mo21211k() {
        return this.f392l;
    }

    @Override // p004b.p005a.p006a.p007a.p025n.AbstractC0231d
    /* renamed from: l */
    public Map<String, String> mo21210l() {
        return this.f393m;
    }

    @Override // p004b.p005a.p006a.p007a.p025n.AbstractC0231d
    /* renamed from: m */
    public Map<String, String> mo21209m() {
        return this.f393m;
    }

    @Override // p004b.p005a.p006a.p007a.p025n.AbstractC0231d
    /* renamed from: n */
    public long mo21208n() {
        return this.f394n;
    }

    @Override // p004b.p005a.p006a.p007a.p025n.AbstractC0231d, p004b.p005a.p006a.p028b.p054o.AbstractC0530i
    /* renamed from: o */
    public void mo20213o() {
    }

    /* renamed from: p */
    public long m21207p() {
        return this.f385e.m21239c();
    }

    /* renamed from: q */
    public C0237j m21206q() {
        return this.f385e;
    }
}
